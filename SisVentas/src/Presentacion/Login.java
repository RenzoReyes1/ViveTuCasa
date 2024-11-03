package Presentacion;

import DAO.UsuarioDao;
import DAO.UsuarioDaoImpl;
import DB.Conexion;
import Entidad.Usuario;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Login extends javax.swing.JFrame {

    Usuario usuario = new Usuario();
    UsuarioDao usuarioDao = new UsuarioDaoImpl();
    
    int xMouse, yMouse;
    
    
    public Login() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblImg = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        btnAcceder = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        lblIniciarSesion = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        pnlHeader = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(247, 248, 252));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/login.jpg"))); // NOI18N
        jPanel1.add(lblImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 620, 500));

        txtUsername.setBackground(new java.awt.Color(247, 248, 252));
        txtUsername.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(32, 40, 87));
        txtUsername.setText("Nombre de usuario");
        txtUsername.setBorder(null);
        txtUsername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtUsernameMousePressed(evt);
            }
        });
        jPanel1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 299, 50));

        btnAcceder.setBackground(new java.awt.Color(45, 83, 218));
        btnAcceder.setForeground(new java.awt.Color(255, 255, 255));
        btnAcceder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAcceder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAccederMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAccederMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAccederMousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ACCEDER");

        javax.swing.GroupLayout btnAccederLayout = new javax.swing.GroupLayout(btnAcceder);
        btnAcceder.setLayout(btnAccederLayout);
        btnAccederLayout.setHorizontalGroup(
            btnAccederLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnAccederLayout.createSequentialGroup()
                .addContainerGap(118, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(117, 117, 117))
        );
        btnAccederLayout.setVerticalGroup(
            btnAccederLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAccederLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel1.add(btnAcceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, 299, -1));

        jSeparator1.setBackground(new java.awt.Color(12, 15, 58));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 299, 10));

        jSeparator2.setBackground(new java.awt.Color(12, 15, 58));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, 299, 10));

        lblIniciarSesion.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        lblIniciarSesion.setForeground(new java.awt.Color(12, 15, 58));
        lblIniciarSesion.setText("INICIA SESIÓN");
        jPanel1.add(lblIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, -1, -1));

        txtPassword.setBackground(new java.awt.Color(247, 248, 252));
        txtPassword.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(32, 40, 87));
        txtPassword.setText("********");
        txtPassword.setBorder(null);
        txtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtPasswordMousePressed(evt);
            }
        });
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 299, 49));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/logo_vivetucasa_colors.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 250, 140));

        pnlHeader.setBackground(new java.awt.Color(247, 248, 252));
        pnlHeader.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlHeaderMouseDragged(evt);
            }
        });
        pnlHeader.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlHeaderMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1220, Short.MAX_VALUE)
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(pnlHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1220, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAccederMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAccederMousePressed
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        int id_usuario = 0, id_rol = 0;
        String nombres = "", apellidos = "";
        
        Connection cnn;
        PreparedStatement ps;
        ResultSet rs;

        try {
            String query = "SELECT id_usuario, id_rol, nombres, apellidos "
                    + " FROM usuarios WHERE estado=0 "
                    + " AND username = '" + username + "' AND password = '" + password + "'";
            
            cnn = Conexion.MySQL();
            ps = cnn.prepareStatement(query);
            rs = ps.executeQuery();
            boolean permitirAcceso = false;
            
            while (rs.next()){
                id_usuario = rs.getInt(1);
                id_rol = rs.getInt(2);
                nombres = rs.getString(3);
                apellidos = rs.getString(4);
                Usuario autenticarUsuario = new Usuario(id_usuario);
                permitirAcceso = true;
            }
            
            if (permitirAcceso == true){
                switch (id_rol) {
                    case 1:
                        MainAdministrador admin = new MainAdministrador();
                        admin.lblIdUsuario.setText(String.valueOf(id_usuario));
                        admin.lblUsuario.setText(nombres + " " + apellidos);
                        admin.setVisible(true);
                        this.dispose();
                        break;
                    case 2:
                        MainVendedor vendedor = new MainVendedor();
                        vendedor.lblIdUsuario.setText(String.valueOf(id_usuario));
                        vendedor.lblUsuario.setText(nombres + " " + apellidos);
                        vendedor.setVisible(true);
                        this.dispose();
                        break;
                    case 3:
                        MainAlmacenero almacenero = new MainAlmacenero();
                        //almacenero.lblIdUsuario.setText(String.valueOf(id_usuario));
                        almacenero.lblUsuario.setText(nombres + " " + apellidos);
                        almacenero.setVisible(true);
                        this.dispose();
                        break;
                    default:
                        break;
                }
            }
            else JOptionPane.showMessageDialog(null, "Error");
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnAccederMousePressed

    private void pnlHeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHeaderMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_pnlHeaderMousePressed

    private void pnlHeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHeaderMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_pnlHeaderMouseDragged

    private void btnAccederMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAccederMouseEntered
        btnAcceder.setBackground(new Color(62, 101, 242));
    }//GEN-LAST:event_btnAccederMouseEntered

    private void btnAccederMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAccederMouseExited
        btnAcceder.setBackground(new Color(45, 83, 218));
    }//GEN-LAST:event_btnAccederMouseExited

    private void txtUsernameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsernameMousePressed
        if (txtUsername.getText().equals("Nombre de usuario")){
            txtUsername.setText("");
            txtUsername.setForeground(Color.black);
        }
        
        if (String.valueOf(txtPassword.getPassword()).isEmpty()){
            txtPassword.setText("********");
            txtPassword.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtUsernameMousePressed

    private void txtPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMousePressed
        if (String.valueOf(txtPassword.getPassword()).equals("********")){
            txtPassword.setText("");
            txtPassword.setForeground(Color.black);
        }
        
        if (txtUsername.getText().isEmpty()){
            txtUsername.setText("Nombre de usuario");
            txtUsername.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtPasswordMousePressed

    
    public static void main(String args[]) {
        try
        {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch(Exception e){} 
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnAcceder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblImg;
    private javax.swing.JLabel lblIniciarSesion;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
