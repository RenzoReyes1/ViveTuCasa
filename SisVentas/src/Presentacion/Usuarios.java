package Presentacion;

import DAO.UsuarioDao;
import DAO.UsuarioDaoImpl;
import Entidad.Usuario;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Usuarios extends javax.swing.JPanel {
    Usuario usuario;
    UsuarioDao usuarioDao = new UsuarioDaoImpl();
    DefaultTableModel tableModel = new DefaultTableModel();
    
    String id_usuario, id_rol, nombres, apellidos, tipo_documento, nro_documento, telefono, email, username;
    
    public Usuarios() {
        initComponents();
        personalizarTable();
        refrescar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRefrescar = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jspMarcas = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        txtBusqueda = new Custom.TextField();
        lblBusqueda = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblTituloMarcas = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRefrescar.setBackground(new java.awt.Color(255, 202, 125));
        btnRefrescar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnRefrescarMousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/actualizar.png"))); // NOI18N
        jLabel3.setText("  Refrescar");

        javax.swing.GroupLayout btnRefrescarLayout = new javax.swing.GroupLayout(btnRefrescar);
        btnRefrescar.setLayout(btnRefrescarLayout);
        btnRefrescarLayout.setHorizontalGroup(
            btnRefrescarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnRefrescarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnRefrescarLayout.setVerticalGroup(
            btnRefrescarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnRefrescarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(btnRefrescar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 630, -1, -1));

        btnEditar.setBackground(new java.awt.Color(45, 83, 218));
        btnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnEditarMousePressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/editar.png"))); // NOI18N
        jLabel2.setText("  Editar");

        javax.swing.GroupLayout btnEditarLayout = new javax.swing.GroupLayout(btnEditar);
        btnEditar.setLayout(btnEditarLayout);
        btnEditarLayout.setHorizontalGroup(
            btnEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnEditarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnEditarLayout.setVerticalGroup(
            btnEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEditarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 630, -1, -1));

        jspMarcas.setBackground(new java.awt.Color(255, 255, 255));
        jspMarcas.setBorder(null);

        tblUsuarios.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tblUsuarios.setForeground(new java.awt.Color(32, 40, 87));
        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblUsuarios.setFocusable(false);
        tblUsuarios.setGridColor(new java.awt.Color(247, 248, 252));
        tblUsuarios.setOpaque(false);
        tblUsuarios.setRowHeight(40);
        tblUsuarios.setSelectionBackground(new java.awt.Color(247, 248, 252));
        tblUsuarios.setSelectionForeground(new java.awt.Color(32, 40, 87));
        tblUsuarios.setShowVerticalLines(false);
        tblUsuarios.getTableHeader().setReorderingAllowed(false);
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblUsuariosMousePressed(evt);
            }
        });
        jspMarcas.setViewportView(tblUsuarios);

        add(jspMarcas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 1030, 450));

        txtBusqueda.setBackground(new java.awt.Color(247, 248, 252));
        txtBusqueda.setForeground(new java.awt.Color(124, 131, 167));
        txtBusqueda.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtBusqueda.setLabelText("Busqueda");
        txtBusqueda.setLineColor(new java.awt.Color(45, 83, 218));
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
        });
        add(txtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 90, 390, -1));

        lblBusqueda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBusqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/busqueda.png"))); // NOI18N
        add(lblBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 90, 60, 50));

        btnNuevo.setBackground(new java.awt.Color(0, 202, 128));
        btnNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnNuevoMousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/agregar.png"))); // NOI18N
        jLabel4.setText(" Nuevo usuario");

        javax.swing.GroupLayout btnNuevoLayout = new javax.swing.GroupLayout(btnNuevo);
        btnNuevo.setLayout(btnNuevoLayout);
        btnNuevoLayout.setHorizontalGroup(
            btnNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnNuevoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnNuevoLayout.setVerticalGroup(
            btnNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnNuevoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 250, -1));

        lblTituloMarcas.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        lblTituloMarcas.setForeground(new java.awt.Color(13, 22, 81));
        lblTituloMarcas.setText("Administrar Usuarios");
        add(lblTituloMarcas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        btnEliminar.setBackground(new java.awt.Color(255, 82, 108));
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnEliminarMousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/eliminar.png"))); // NOI18N
        jLabel5.setText("  Eliminar");

        javax.swing.GroupLayout btnEliminarLayout = new javax.swing.GroupLayout(btnEliminar);
        btnEliminar.setLayout(btnEliminarLayout);
        btnEliminarLayout.setHorizontalGroup(
            btnEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnEliminarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnEliminarLayout.setVerticalGroup(
            btnEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEliminarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 630, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private DefaultTableModel cargarTable(String busqueda){
        List<Usuario> lista = new ArrayList<>();
        lista.addAll(usuarioDao.listar(busqueda));
        String[] cabeceras = {"ID", "ROL", "NOMBRES", "APELLIDOS", "DNI/CE", "NRO DOCUMENTO", "TELEFONO", "EMAIL", "USERNAME"};
        tableModel = new DefaultTableModel(null, cabeceras);

        String[] registro = new String[9];
        
        for (Usuario item : lista){
            registro[0] = Integer.toString(item.getId_usuario());
            registro[1] = item.getId_rol();
            registro[2] = item.getNombres();
            registro[3] = item.getApellidos();
            registro[4] = item.getTipo_documento();
            registro[5] = item.getNro_documento();
            registro[6] = item.getTelefono();
            registro[7] = item.getEmail();
            registro[8] = item.getUsername();
            tableModel.addRow(registro);
        }
        
        return tableModel;
    }
    
    private void refrescar(){
        cargarTable("");
        tblUsuarios.setModel(tableModel);
    }
    
    private void personalizarTable(){
        tblUsuarios.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 14));
        tblUsuarios.getTableHeader().setBackground(Color.WHITE);
        tblUsuarios.getTableHeader().setForeground(new Color(188, 198, 209));
        tblUsuarios.getTableHeader().setOpaque(false);
        
    }
    
    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        String busqueda = txtBusqueda.getText();
        cargarTable(busqueda);
        tblUsuarios.setModel(tableModel);
    }//GEN-LAST:event_txtBusquedaKeyReleased

    private void btnNuevoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMousePressed
        NuevoUsuario nuevo = new NuevoUsuario(null, true);
        nuevo.setVisible(true);
    }//GEN-LAST:event_btnNuevoMousePressed

    private void btnRefrescarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefrescarMousePressed
        refrescar();
    }//GEN-LAST:event_btnRefrescarMousePressed

    private void btnEliminarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMousePressed
        int result = JOptionPane.showConfirmDialog(null,"¿Eliminar registro?", "Esta operación es irreversible",
                                                        JOptionPane.YES_NO_OPTION,
                                                        JOptionPane.QUESTION_MESSAGE);
        
        if(result == JOptionPane.YES_OPTION){
            if (usuarioDao.eliminar(1, Integer.valueOf(id_usuario))){
                refrescar();
                JOptionPane.showMessageDialog(null, "Registro eliminado");
            }
        }
    }//GEN-LAST:event_btnEliminarMousePressed

    private void tblUsuariosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMousePressed
        id_usuario = tblUsuarios.getValueAt(tblUsuarios.getSelectedRow(),0).toString();
        id_rol = tblUsuarios.getValueAt(tblUsuarios.getSelectedRow(),1).toString();
        nombres = tblUsuarios.getValueAt(tblUsuarios.getSelectedRow(),2).toString();
        apellidos = tblUsuarios.getValueAt(tblUsuarios.getSelectedRow(),3).toString();
        tipo_documento = tblUsuarios.getValueAt(tblUsuarios.getSelectedRow(),4).toString();
        nro_documento = tblUsuarios.getValueAt(tblUsuarios.getSelectedRow(),5).toString();
        telefono = tblUsuarios.getValueAt(tblUsuarios.getSelectedRow(),6).toString();
        email = tblUsuarios.getValueAt(tblUsuarios.getSelectedRow(),7).toString();
        username = tblUsuarios.getValueAt(tblUsuarios.getSelectedRow(),8).toString();
    }//GEN-LAST:event_tblUsuariosMousePressed

    private void btnEditarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMousePressed
        NuevoUsuario nuevo = new NuevoUsuario(null, true);
        nuevo.x = 1;
        nuevo.lblTitulo.setText("Actualizar usuario");
        nuevo.id_usuario = Integer.valueOf(id_usuario);
        nuevo.cboRoles.setSelectedItem(id_rol);
        nuevo.txtNombres.setText(nombres);
        nuevo.txtApellidos.setText(apellidos);
        nuevo.cboTipoDocumento.setSelectedItem(tipo_documento);
        nuevo.txtNroDocumento.setText(nro_documento);
        nuevo.txtTelefono.setText(telefono);
        nuevo.txtEmail.setText(email);
        nuevo.txtUsername.setText(username);
        nuevo.lblRegistrarEditar.setText("Guardar cambios");
        nuevo.setVisible(true);
    }//GEN-LAST:event_btnEditarMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnEditar;
    private javax.swing.JPanel btnEliminar;
    private javax.swing.JPanel btnNuevo;
    private javax.swing.JPanel btnRefrescar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jspMarcas;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JLabel lblTituloMarcas;
    private javax.swing.JTable tblUsuarios;
    private Custom.TextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
