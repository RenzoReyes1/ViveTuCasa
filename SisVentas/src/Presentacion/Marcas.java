package Presentacion;

import DAO.MarcaDao;
import DAO.MarcaDaoImpl;
import Entidad.Marca;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Marcas extends javax.swing.JPanel {

    Marca marca;
    MarcaDao marcaDao = new MarcaDaoImpl();
    DefaultTableModel tableModel = new DefaultTableModel();
    
    String id_marca, nombre_marca;
    
    public Marcas() {
        initComponents();
        personalizarTable();
        refrescar();
    }

    private DefaultTableModel cargarTable(String busqueda){
        List<Marca> lista = new ArrayList<>();
        lista.addAll(marcaDao.listar(busqueda));
        String[] cabeceras = {"ID", "MARCA"};
        tableModel = new DefaultTableModel(null, cabeceras);

        String[] registro = new String[2];
        
        for (Marca item : lista){
            registro[0] = Integer.toString(item.getId_marca());
            registro[1] = item.getNombre_marca();
            tableModel.addRow(registro);
        }
        
        return tableModel;
    }
    
    public  void refrescar(){
        cargarTable("");
        tblMarcas.setModel(tableModel);
    }
    
    private void personalizarTable(){
        tblMarcas.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 14));
        tblMarcas.getTableHeader().setBackground(Color.WHITE);
        tblMarcas.getTableHeader().setForeground(new Color(188, 198, 209));
        tblMarcas.getTableHeader().setOpaque(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTituloMarcas = new javax.swing.JLabel();
        jspMarcas = new javax.swing.JScrollPane();
        tblMarcas = new javax.swing.JTable();
        btnNuevo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtBusqueda = new Custom.TextField();
        jLabel4 = new javax.swing.JLabel();
        btnRefrescar = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTituloMarcas.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        lblTituloMarcas.setForeground(new java.awt.Color(13, 22, 81));
        lblTituloMarcas.setText("Administrar Marcas");
        add(lblTituloMarcas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jspMarcas.setBackground(new java.awt.Color(255, 255, 255));
        jspMarcas.setBorder(null);

        tblMarcas.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tblMarcas.setForeground(new java.awt.Color(32, 40, 87));
        tblMarcas.setModel(new javax.swing.table.DefaultTableModel(
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
        tblMarcas.setFocusable(false);
        tblMarcas.setGridColor(new java.awt.Color(247, 248, 252));
        tblMarcas.setOpaque(false);
        tblMarcas.setRowHeight(40);
        tblMarcas.setSelectionBackground(new java.awt.Color(247, 248, 252));
        tblMarcas.setSelectionForeground(new java.awt.Color(32, 40, 87));
        tblMarcas.setShowVerticalLines(false);
        tblMarcas.getTableHeader().setReorderingAllowed(false);
        tblMarcas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblMarcasMousePressed(evt);
            }
        });
        jspMarcas.setViewportView(tblMarcas);

        add(jspMarcas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 1030, 450));

        btnNuevo.setBackground(new java.awt.Color(0, 202, 128));
        btnNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnNuevoMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/agregar.png"))); // NOI18N
        jLabel1.setText("  Nueva marca");

        javax.swing.GroupLayout btnNuevoLayout = new javax.swing.GroupLayout(btnNuevo);
        btnNuevo.setLayout(btnNuevoLayout);
        btnNuevoLayout.setHorizontalGroup(
            btnNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnNuevoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnNuevoLayout.setVerticalGroup(
            btnNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnNuevoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 250, -1));

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

        btnEliminar.setBackground(new java.awt.Color(255, 82, 108));
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnEliminarMousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/eliminar.png"))); // NOI18N
        jLabel3.setText("  Eliminar");

        javax.swing.GroupLayout btnEliminarLayout = new javax.swing.GroupLayout(btnEliminar);
        btnEliminar.setLayout(btnEliminarLayout);
        btnEliminarLayout.setHorizontalGroup(
            btnEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnEliminarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnEliminarLayout.setVerticalGroup(
            btnEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEliminarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 630, -1, -1));

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

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/busqueda.png"))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 90, 60, 50));

        btnRefrescar.setBackground(new java.awt.Color(255, 202, 125));
        btnRefrescar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnRefrescarMousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/actualizar.png"))); // NOI18N
        jLabel5.setText("  Refrescar");

        javax.swing.GroupLayout btnRefrescarLayout = new javax.swing.GroupLayout(btnRefrescar);
        btnRefrescar.setLayout(btnRefrescarLayout);
        btnRefrescarLayout.setHorizontalGroup(
            btnRefrescarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnRefrescarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnRefrescarLayout.setVerticalGroup(
            btnRefrescarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnRefrescarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(btnRefrescar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 630, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        String busqueda = txtBusqueda.getText();
        cargarTable(busqueda);
        tblMarcas.setModel(tableModel);
    }//GEN-LAST:event_txtBusquedaKeyReleased

    private void tblMarcasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMarcasMousePressed
        id_marca = tblMarcas.getValueAt(tblMarcas.getSelectedRow(),0).toString();
        nombre_marca = tblMarcas.getValueAt(tblMarcas.getSelectedRow(),1).toString();
    }//GEN-LAST:event_tblMarcasMousePressed

    private void btnNuevoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMousePressed
        NuevaMarca nuevo = new NuevaMarca(null, true);
        nuevo.setVisible(true);
    }//GEN-LAST:event_btnNuevoMousePressed

    private void btnEliminarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMousePressed
        int result = JOptionPane.showConfirmDialog(null,"¿Eliminar registro?", "Esta operación es irreversible",
                                                        JOptionPane.YES_NO_OPTION,
                                                        JOptionPane.QUESTION_MESSAGE);
        
        if(result == JOptionPane.YES_OPTION){
            if (marcaDao.eliminar(1, Integer.valueOf(id_marca))){
                refrescar();
                JOptionPane.showMessageDialog(null, "Registro eliminado");
            }
        }
    }//GEN-LAST:event_btnEliminarMousePressed

    private void btnEditarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMousePressed
        NuevaMarca nuevo = new NuevaMarca(null, true);
        nuevo.x = 1;
        nuevo.id_marca = Integer.valueOf(id_marca);
        nuevo.txtNombreMarca.setText(nombre_marca);
        nuevo.lblTitulo.setText("Actualizar categoría");
        nuevo.lblRegistrarEditar.setText("Guardar cambios");
        nuevo.setVisible(true);
    }//GEN-LAST:event_btnEditarMousePressed

    private void btnRefrescarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefrescarMousePressed
        refrescar();
    }//GEN-LAST:event_btnRefrescarMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel btnEditar;
    public javax.swing.JPanel btnEliminar;
    public javax.swing.JPanel btnNuevo;
    public javax.swing.JPanel btnRefrescar;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JScrollPane jspMarcas;
    public javax.swing.JLabel lblTituloMarcas;
    public javax.swing.JTable tblMarcas;
    public Custom.TextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
