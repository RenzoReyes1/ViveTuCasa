package Presentacion;

import DAO.ClienteDao;
import DAO.ClienteDaoImpl;
import Entidad.Cliente;
import javax.swing.JOptionPane;

public class NuevoCliente extends java.awt.Dialog {

    Cliente cliente;
    ClienteDao clienteDao = new ClienteDaoImpl();
    
    int id_cliente;
    
    int x = 0; //0 INSERTAR - 1 EDITAR
    
    public NuevoCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
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

        txtNombres.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtNombres.setLabelText("Nombres");

        cboTipoDocumento.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        cboTipoDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DNI", "CE" }));

        txtNroDocumento.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtNroDocumento.setLabelText("Número de documento");

        txtTelefono.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtTelefono.setLabelText("Telefono");

        txtEmail.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtEmail.setLabelText("Email");

        lblTitulo.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lblTitulo.setText("Nuevo cliente");
        lblTitulo.setToolTipText("");

        txtDireccion.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtDireccion.setLabelText("Direccion");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cboTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtNroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 490));

        btnRgistrarEditar.setBackground(new java.awt.Color(45, 83, 218));
        btnRgistrarEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnRgistrarEditarMousePressed(evt);
            }
        });

        lblRegistrarEditar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblRegistrarEditar.setForeground(new java.awt.Color(255, 255, 255));
        lblRegistrarEditar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRegistrarEditar.setText("Registrar");

        javax.swing.GroupLayout btnRgistrarEditarLayout = new javax.swing.GroupLayout(btnRgistrarEditar);
        btnRgistrarEditar.setLayout(btnRgistrarEditarLayout);
        btnRgistrarEditarLayout.setHorizontalGroup(
            btnRgistrarEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnRgistrarEditarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRegistrarEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnRgistrarEditarLayout.setVerticalGroup(
            btnRgistrarEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnRgistrarEditarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRegistrarEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(btnRgistrarEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void btnRgistrarEditarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRgistrarEditarMousePressed
        String nombres= txtNombres.getText();
        String tipo_documento = cboTipoDocumento.getSelectedItem().toString();
        String nro_documento = txtNroDocumento.getText();
        String direccion = txtDireccion.getText();
        String telefono = txtTelefono.getText();
        String email = txtEmail.getText();

        if (x == 0){
            cliente = new Cliente(0, nombres, tipo_documento, nro_documento, direccion, telefono, email, 0);

            if(clienteDao.insertar(cliente)){
                JOptionPane.showMessageDialog(null, "Registro exitoso");
                this.dispose();
            }
            else JOptionPane.showMessageDialog(null, "Error");
        }
        else if (x == 1){
            cliente = new Cliente(id_cliente, nombres, tipo_documento, nro_documento, direccion, telefono, email, 0);

            if(clienteDao.editar(cliente)){
                x = 0;
                JOptionPane.showMessageDialog(null, "Registro modificado");
                this.dispose();
            }
            else JOptionPane.showMessageDialog(null, "Error");
        }
    }//GEN-LAST:event_btnRgistrarEditarMousePressed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NuevoCliente dialog = new NuevoCliente(new java.awt.Frame(), true);
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
    public final javax.swing.JPanel btnRgistrarEditar = new javax.swing.JPanel();
    public final javax.swing.JComboBox<String> cboTipoDocumento = new javax.swing.JComboBox<>();
    private javax.swing.JPanel jPanel1;
    public final javax.swing.JLabel lblRegistrarEditar = new javax.swing.JLabel();
    public final javax.swing.JLabel lblTitulo = new javax.swing.JLabel();
    public final Custom.TextField txtDireccion = new Custom.TextField();
    public final Custom.TextField txtEmail = new Custom.TextField();
    public final Custom.TextField txtNombres = new Custom.TextField();
    public final Custom.TextField txtNroDocumento = new Custom.TextField();
    public final Custom.TextField txtTelefono = new Custom.TextField();
    // End of variables declaration//GEN-END:variables
}
