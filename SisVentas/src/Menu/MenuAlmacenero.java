package Menu;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;



public class MenuAlmacenero extends JComponent {
    private MenuEvent event;
    private MigLayout layout;
    
    // Mantenemos los items de menú final para evitar la reasignación accidental
    private final String[][] menuItems = {
        {"Almacen", "Productos", "Categorías", "Marcas"},
        {"Compras", "Administrar compras", "Nueva compra", "Proveedores"},
        {"Reportes"},
        {"Cerrar sesión"}
    };

    public MenuAlmacenero() {
        init();
    }

    // Encapsula la obtención y asignación del evento en métodos estándar
    public MenuEvent getEvent() {
        return event;
    }

    public void setEvent(MenuEvent event) {
        this.event = event;
    }

    private void init() {
        // Configura layout solo una vez
        layout = new MigLayout("wrap 1, fillx, gapy 0, inset 2", "fill");
        setLayout(layout);
        setOpaque(true);

        // Inicia y agrega cada menú
        for (int i = 0; i < menuItems.length; i++) {
            addMenu(menuItems[i][0], i);
        }
    }

    // Obtiene el ícono según el índice del menú; reutiliza iconos si no cambian
    private Icon getIcon(int index) {
        URL url = getClass().getResource("/menu/" + index + ".png");
        return url != null ? new ImageIcon(url) : null;
    }

    private void addMenu(String menuName, int index) {
        int length = menuItems[index].length;
        MenuItem item = new MenuItem(menuName, index, length > 1);

        // Solo asigna ícono si está presente
        Icon icon = getIcon(index);
        if (icon != null) {
            item.setIcon(icon);
        }

        item.addActionListener(e -> handleMenuAction(item, index, length));

        add(item);
        revalidate();
        repaint();
    }

    // Manejador de acción para el menú principal
    private void handleMenuAction(MenuItem item, int index, int length) {
        if (length > 1) {
            if (!item.isSelected()) {
                item.setSelected(true);
                addSubMenu(item, index, length, getComponentZOrder(item));
            } else {
                hideMenu(item, index);
                item.setSelected(false);
            }
        } else if (event != null) {
            event.selected(index, 0);
        }
    }

    private void addSubMenu(MenuItem item, int index, int length, int indexZorder) {
        JPanel panel = createSubMenuPanel(index, length);
        add(panel, "h 0!", indexZorder + 1);
        revalidate();
        repaint();
        MenuAnimation.showMenu(panel, item, layout, true);
    }

    // Refactoriza la creación de paneles de submenú en un método separado
    private JPanel createSubMenuPanel(int index, int length) {
        JPanel panel = new JPanel(new MigLayout("wrap 1, fillx, inset 0, gapy 0", "fill"));
        panel.setOpaque(false);
        panel.setName(String.valueOf(index));

        for (int i = 1; i < length; i++) {
            MenuItem subItem = createSubMenuItem(index, i);
            panel.add(subItem);
        }
        return panel;
    }

    // Método de ayuda para crear submenús
    private MenuItem createSubMenuItem(int menuIndex, int subIndex) {
        MenuItem subItem = new MenuItem(menuItems[menuIndex][subIndex], subIndex, false);
        subItem.addActionListener(ae -> {
            if (event != null) {
                event.selected(menuIndex, subIndex);
            }
        });
        subItem.initSubMenu(subIndex, menuItems[menuIndex].length);
        return subItem;
    }

    private void hideMenu(MenuItem item, int index) {
        // Itera y oculta el menú seleccionado
        for (Component com : getComponents()) {
            if (com instanceof JPanel && String.valueOf(index).equals(com.getName())) {
                com.setName(null);
                MenuAnimation.showMenu(com, item, layout, false);
                break;
            }
        }
    }

    // Método de dibujo optimizado
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        try {
            g2.setColor(new Color(12, 15, 58));
            g2.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
        } finally {
            g2.dispose();
        }
        super.paintComponent(g);
    }
}
