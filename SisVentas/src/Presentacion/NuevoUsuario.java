package Presentacion;

import DAO.UsuarioDao;
import DAO.UsuarioDaoImpl;
import DB.Conexion;
import Entidad.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class NuevoUsuario extends java.awt.Dialog {

    Usuario usuario = new Usuario();
    UsuarioDao usuarioDao = new UsuarioDaoImpl();
    
    private ResultSet rs;
    private PreparedStatement ps;
    private Connection cnn;
    
    int x = 0;
    int id_usuario;
    String id_rol;
    
    public NuevoUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        comboRol();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsername.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtUsername.setLabelText("Username");
        jPanel1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, 320, -1));

        txtEmail.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtEmail.setLabelText("Email");
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 320, -1));

        txtNroDocumento.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtNroDocumento.setLabelText("Número de documento");
        jPanel1.add(txtNroDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 320, -1));

        txtApellidos.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtApellidos.setLabelText("Apellidos");
        jPanel1.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 320, -1));

        lblTitulo.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lblTitulo.setText("Nuevo usuario");
        lblTitulo.setToolTipText("");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 224, -1));

        txtNombres.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtNombres.setLabelText("Nombres");
        jPanel1.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 320, -1));

        txtPassword.setText("********");
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 610, 320, 50));

        txtTelefono.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtTelefono.setLabelText("Telefono");
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 320, -1));

        cboTipoDocumento.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        cboTipoDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DNI", "CE" }));
        jPanel1.add(cboTipoDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 320, 50));

        jPanel1.add(cboRoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 320, 50));

        txtDireccion.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtDireccion.setLabelText("Dirección");
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 320, -1));

        btnRgistrar.setBackground(new java.awt.Color(45, 83, 218));
        btnRgistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnRgistrarMousePressed(evt);
            }
        });

        lblRegistrarEditar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblRegistrarEditar.setForeground(new java.awt.Color(255, 255, 255));
        lblRegistrarEditar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRegistrarEditar.setText("Registrar");

        javax.swing.GroupLayout btnRgistrarLayout = new javax.swing.GroupLayout(btnRgistrar);
        btnRgistrar.setLayout(btnRgistrarLayout);
        btnRgistrarLayout.setHorizontalGroup(
            btnRgistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnRgistrarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRegistrarEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnRgistrarLayout.setVerticalGroup(
            btnRgistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnRgistrarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRegistrarEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(btnRgistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 680, 320, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void comboRol()
    {				
        try
        {
            cnn = Conexion.MySQL();
            ps = cnn.prepareStatement("SELECT rol FROM roles");
            rs = ps.executeQuery();

            while (rs.next())
            {
                cboRoles.addItem(rs.getString(1));
            }
        }
        catch(Exception e) {}
    }
    
    private void getIdRol(String rol)
    {		
        try
        {
            cnn = Conexion.MySQL();
            ps = cnn.prepareStatement("SELECT id_rol FROM roles WHERE rol LIKE '" + rol + "'");
            rs = ps.executeQuery();

            rs.next();
            id_rol = rs.getString(1);
            System.out.println(id_rol);
        }
        catch(Exception e) {}
    }
    
    private void btnRgistrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRgistrarMousePressed
        try {
            getIdRol(cboRoles.getSelectedItem().toString());
            String nombres = txtNombres.getText();
            String apellidos = txtApellidos.getText();
            String tipo_documento = cboTipoDocumento.getSelectedItem().toString();
            String nro_documento = txtNroDocumento.getText();
            String telefono = txtTelefono.getText();
            String email = txtEmail.getText();
            String username = txtUsername.getText();
            char[] arrayC = txtPassword.getPassword();
            String pass = new String(arrayC);

            if (x == 0){
                usuario = new Usuario(0, id_rol, nombres, apellidos, tipo_documento, nro_documento, telefono, email, username, pass, 0);
                
                if(usuarioDao.insertar(usuario)){
                    JOptionPane.showMessageDialog(null, "Registro exitoso");
                    this.dispose();
                }
                else JOptionPane.showMessageDialog(null, "Error");
            }
            else if (x == 1){
                usuario = new Usuario(id_usuario, id_rol, nombres, apellidos, tipo_documento, nro_documento, telefono, email, username, pass, 0);
                
                if(usuarioDao.editar(usuario)){
                    x = 0;
                    JOptionPane.showMessageDialog(null, "Registro modificado");
                    this.dispose();
                }
            else JOptionPane.showMessageDialog(null, "Error");
        }
        }
        catch (Exception e) {
            System.out.println(e);
        }

        getIdRol(cboRoles.getSelectedItem().toString());
    }//GEN-LAST:event_btnRgistrarMousePressed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NuevoUsuario dialog = new NuevoUsuario(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public final javax.swing.JPanel btnRgistrar = new javax.swing.JPanel();
    public final javax.swing.JComboBox<String> cboRoles = new javax.swing.JComboBox<>();
    public final javax.swing.JComboBox<String> cboTipoDocumento = new javax.swing.JComboBox<>();
    private javax.swing.JPanel jPanel1;
    public final javax.swing.JLabel lblRegistrarEditar = new javax.swing.JLabel();
    public final javax.swing.JLabel lblTitulo = new javax.swing.JLabel();
    public final Custom.TextField txtApellidos = new Custom.TextField();
    public final Custom.TextField txtDireccion = new Custom.TextField();
    public final Custom.TextField txtEmail = new Custom.TextField();
    public final Custom.TextField txtNombres = new Custom.TextField();
    public final Custom.TextField txtNroDocumento = new Custom.TextField();
    public final javax.swing.JPasswordField txtPassword = new javax.swing.JPasswordField();
    public final Custom.TextField txtTelefono = new Custom.TextField();
    public final Custom.TextField txtUsername = new Custom.TextField();
    // End of variables declaration//GEN-END:variables

}
