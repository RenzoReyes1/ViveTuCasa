package Presentacion;

import Menu.MenuEvent;
import java.awt.Component;
import javax.swing.UIManager;

public class MainAdmin extends javax.swing.JFrame {

    public MainAdmin() {
        initComponents();
        setLocationRelativeTo(null);
        showForm(new Dashboard());
        
        menu1.setEvent(new MenuEvent() {
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
                
                if (index == 2 && subIndex == 2) {
                    showForm(new Proveedores());
                }
                
                if (index == 1 && subIndex == 3) {
                    showForm(new Categorias());
                }
                
                if (index == 1 && subIndex == 4) {
                    showForm(new Marcas());
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
    
    private void showForm(Component com) {
        jPanel2.removeAll();
        jPanel2.add(com);
        jPanel2.repaint();
        jPanel2.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        scrollPaneWin111 = new Scroll.ScrollPaneWin11();
        menu1 = new Menu.Menu();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(246, 247, 251));

        scrollPaneWin111.setViewportView(menu1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(scrollPaneWin111, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPaneWin111, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        try
        {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch(Exception e){} 
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private Menu.Menu menu1;
    private Scroll.ScrollPaneWin11 scrollPaneWin111;
    // End of variables declaration//GEN-END:variables
}
