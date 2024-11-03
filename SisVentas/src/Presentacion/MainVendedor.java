package Presentacion;

import Menu.MenuEvent;
import java.awt.Component;
import javax.swing.UIManager;

public class MainVendedor extends javax.swing.JFrame {

    public MainVendedor() {
        initComponents();
        this.setLocationRelativeTo(null);
        lblIdUsuario.setVisible(false);
        showForm(new Ventas());
        
        
        menuVendedor.setEvent(new MenuEvent() {
            @Override
            public void selected(int index, int subIndex) {
                System.out.println(index + " " + subIndex);
                
                if (index == 0 && subIndex == 1) {
                    showForm(new Ventas());
                }  
                
                if (index == 0 && subIndex == 2) {
                    showForm(new NuevaVenta());
                }  
                
                if (index == 0 && subIndex == 3) {
                    showForm(new Clientes());
                }
                

                
                if (index == 2) {
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
        menuVendedor = new Menu.MenuVendedor();
        lblIdUsuario = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        pnlContenedor = new javax.swing.JPanel();

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
        scrollPaneWin111.setViewportView(menuVendedor);

        jPanel2.add(scrollPaneWin111, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 222, 240, 544));

        lblIdUsuario.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblIdUsuario.setText("1");
        jPanel2.add(lblIdUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));

        lblUsuario.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblUsuario.setText("Daniel Ramos Geng");
        jPanel2.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1066, 11, 290, -1));

        pnlContenedor.setBackground(new java.awt.Color(255, 255, 255));
        pnlContenedor.setLayout(new java.awt.BorderLayout());
        jPanel2.add(pnlContenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 72, 1110, 680));

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
                new MainVendedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JLabel lblIdUsuario;
    public static javax.swing.JLabel lblUsuario;
    private Menu.MenuVendedor menuVendedor;
    private javax.swing.JPanel pnlContenedor;
    private Scroll.ScrollPaneWin11 scrollPaneWin111;
    // End of variables declaration//GEN-END:variables
}
