package Presentacion;

import Menu.MenuEvent;
import java.awt.Component;
import javax.swing.UIManager;

public class MainAdministrador extends javax.swing.JFrame {

    public MainAdministrador() {
        initComponents();
        this.setLocationRelativeTo(null);
        showForm(new Dashboard());
        lblIdUsuario.setVisible(false);
        
        menuAdministrador.setEvent(new MenuEvent() {
            @Override
            public void selected(int index, int subIndex) {
                System.out.println(index + " " + subIndex);
                
                if (index == 0) {
                    showForm(new Dashboard());
                }  
                
                if (index == 1 && subIndex == 1) {
                    showForm(new Usuarios());
                }
                
                if (index == 1 && subIndex == 2) {
                    showForm(new Productos());
                }
                
                if (index == 2 && subIndex == 1) {
                    showForm(new Compras());
                }
                
                if (index == 2 && subIndex == 2) {
                    showForm(new NuevaCompra());
                }
                
                if (index == 2 && subIndex == 3) {
                    showForm(new Proveedores());
                }
                
                if (index == 1 && subIndex == 3) {
                    showForm(new Categorias());
                }
                
                if (index == 1 && subIndex == 4) {
                    showForm(new Marcas());
                }
                
                if (index == 3 && subIndex == 1) {
                    showForm(new Ventas());
                }
                
                if (index == 3 && subIndex == 3) {
                    showForm(new Clientes());
                }
                
                
                if (index == 3 && subIndex==2) {
                    showForm(new NuevaVenta());
                }
                
                else if (index == 4 && subIndex==1) {
                    showForm(new Usuarios());
                }
                
                else if (index == 4 && subIndex==2) {
                    showForm(new Roles());
                }
               
                if (index == 6) {
                    showForm(new Ajustes());
                }
                
                
                if (index == 7) {
                    Login login = new Login();
                    login.show();
                    dispose();
                }
            }
        });
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        scrollPaneWin111 = new Scroll.ScrollPaneWin11();
        menuAdministrador = new Menu.Menu();
        lblIdUsuario = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        pnlContenedor = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(247, 248, 252));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(12, 15, 58));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/logo_vivetucasa_white.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        scrollPaneWin111.setBorder(null);
        scrollPaneWin111.setViewportView(menuAdministrador);

        jPanel2.add(scrollPaneWin111, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 222, 240, 544));

        lblIdUsuario.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblIdUsuario.setText("1");
        jPanel2.add(lblIdUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        lblUsuario.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblUsuario.setText("Daniel Ramos Geng");
        jPanel2.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 10, 190, 30));

        pnlContenedor.setBackground(new java.awt.Color(255, 255, 255));
        pnlContenedor.setLayout(new java.awt.BorderLayout());
        jPanel2.add(pnlContenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 1110, 700));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/cuenta.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 10, 20, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showForm(Component com) {
        pnlContenedor.removeAll();
        pnlContenedor.add(com);
        pnlContenedor.repaint();
        pnlContenedor.revalidate();
    }
    
    public static void main(String args[]) {
        try
        {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch(Exception e){} 
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JLabel lblIdUsuario;
    public static javax.swing.JLabel lblUsuario;
    private Menu.Menu menuAdministrador;
    private javax.swing.JPanel pnlContenedor;
    private Scroll.ScrollPaneWin11 scrollPaneWin111;
    // End of variables declaration//GEN-END:variables
}
