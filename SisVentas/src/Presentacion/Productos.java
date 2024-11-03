package Presentacion;

import DAO.ProductoDao;
import DAO.ProductoDaoImpl;
import Entidad.Producto;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import DAO.ExcelDAOImpl;
import java.io.IOException;

public class Productos extends javax.swing.JPanel {

    Producto producto;
    ProductoDao productoDao = new ProductoDaoImpl();
    DefaultTableModel tableModel = new DefaultTableModel();
    
    String id_producto, nombre_producto, categoria, marca, precio_compra, precio_venta, stock;

    public Productos() {
        initComponents();

        personalizarTable();
        refrescar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnEditar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jspMarcas = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        txtBusqueda = new Custom.TextField();
        lblBusqueda = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblTituloMarcas = new javax.swing.JLabel();
        btnRefrescar = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnExportar = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 640, -1, -1));

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

        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 640, -1, -1));

        jspMarcas.setBackground(new java.awt.Color(255, 255, 255));
        jspMarcas.setBorder(null);

        tblProductos.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tblProductos.setForeground(new java.awt.Color(32, 40, 87));
        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        tblProductos.setFocusable(false);
        tblProductos.setGridColor(new java.awt.Color(247, 248, 252));
        tblProductos.setOpaque(false);
        tblProductos.setRowHeight(40);
        tblProductos.setSelectionBackground(new java.awt.Color(247, 248, 252));
        tblProductos.setSelectionForeground(new java.awt.Color(32, 40, 87));
        tblProductos.setShowVerticalLines(false);
        tblProductos.getTableHeader().setReorderingAllowed(false);
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblProductosMousePressed(evt);
            }
        });
        jspMarcas.setViewportView(tblProductos);

        jPanel1.add(jspMarcas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 1030, 450));

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
        jPanel1.add(txtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 90, 280, -1));

        lblBusqueda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBusqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/busqueda.png"))); // NOI18N
        jPanel1.add(lblBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 90, 60, 50));

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
        jLabel4.setText(" Nuevo producto");

        javax.swing.GroupLayout btnNuevoLayout = new javax.swing.GroupLayout(btnNuevo);
        btnNuevo.setLayout(btnNuevoLayout);
        btnNuevoLayout.setHorizontalGroup(
            btnNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnNuevoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnNuevoLayout.setVerticalGroup(
            btnNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnNuevoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 210, -1));

        lblTituloMarcas.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        lblTituloMarcas.setForeground(new java.awt.Color(13, 22, 81));
        lblTituloMarcas.setText("Administrar Productos");
        jPanel1.add(lblTituloMarcas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

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

        jPanel1.add(btnRefrescar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 640, -1, -1));

        btnExportar.setBackground(new java.awt.Color(255, 202, 125));
        btnExportar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnExportarMousePressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/el icono excel real.png"))); // NOI18N
        jLabel6.setText("Exportar Excel");

        javax.swing.GroupLayout btnExportarLayout = new javax.swing.GroupLayout(btnExportar);
        btnExportar.setLayout(btnExportarLayout);
        btnExportarLayout.setHorizontalGroup(
            btnExportarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnExportarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnExportarLayout.setVerticalGroup(
            btnExportarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnExportarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(btnExportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 640, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private DefaultTableModel cargarTable(String busqueda){
        List<Producto> lista = new ArrayList<>();
        lista.addAll(productoDao.listar(busqueda));
        String[] cabeceras = {"ID", "PRODUCTO", "CATEGORIA", "MARCA", "P. COMPRA", "P. vENTA", "STOCK", "INGRESO"};
        tableModel = new DefaultTableModel(null, cabeceras);

        String[] registro = new String[8];
        
        for (Producto item : lista){
            registro[0] = Integer.toString(item.getId_producto());
            registro[1] = item.getNombre_producto();
            registro[2] = item.getId_categoria();
            registro[3] = item.getId_marca();
            registro[4] = String.valueOf(item.getPrecio_compra());
            registro[5] = String.valueOf(item.getPrecio_venta());
            registro[6] = Integer.toString(item.getStock());
            registro[7] = String.valueOf(item.getFecha_ingreso());
            tableModel.addRow(registro);
        }
        
        return tableModel;
    }
    
    private void refrescar(){
        cargarTable("");
        
        tblProductos.getColumnModel().getColumn(0).setPreferredWidth(0);
        tblProductos.setModel(tableModel);
    }
    
    private void personalizarTable(){
        tblProductos.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 14));
        tblProductos.getTableHeader().setBackground(Color.WHITE);
        tblProductos.getTableHeader().setForeground(new Color(188, 198, 209)); 
    }
    
    
    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        String busqueda = txtBusqueda.getText();
        cargarTable(busqueda);
        tblProductos.setModel(tableModel);
    }//GEN-LAST:event_txtBusquedaKeyReleased

    private void btnRefrescarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefrescarMousePressed
        refrescar();
    }//GEN-LAST:event_btnRefrescarMousePressed

    private void tblProductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMousePressed
        id_producto = tblProductos.getValueAt(tblProductos.getSelectedRow(),0).toString();
        nombre_producto = tblProductos.getValueAt(tblProductos.getSelectedRow(),1).toString();
        categoria = tblProductos.getValueAt(tblProductos.getSelectedRow(),2).toString();
        marca = tblProductos.getValueAt(tblProductos.getSelectedRow(),3).toString();
        precio_compra = tblProductos.getValueAt(tblProductos.getSelectedRow(),4).toString();
        precio_venta = tblProductos.getValueAt(tblProductos.getSelectedRow(),5).toString();
        stock = tblProductos.getValueAt(tblProductos.getSelectedRow(),6).toString();
    }//GEN-LAST:event_tblProductosMousePressed

    private void btnEditarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMousePressed
        NuevoProducto nuevo = new NuevoProducto(null, true);
        nuevo.x = 1;
        nuevo.id_producto = Integer.valueOf(id_producto);
        nuevo.lblTitulo.setText("Actualizar producto");
        nuevo.txtNombreProducto.setText(nombre_producto);
        nuevo.cboCategorias.setSelectedItem(categoria);
        nuevo.cboMarcas.setSelectedItem(marca);
        nuevo.txtPrecioCompra.setText(precio_compra);
        nuevo.txtPrecioVenta.setText(precio_venta);
        nuevo.txtStock.setText(stock);
        nuevo.lblRegistrarEditar.setText("Guardar cambios");
        nuevo.setVisible(true);
    }//GEN-LAST:event_btnEditarMousePressed

    private void btnNuevoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMousePressed
        NuevoProducto nuevo = new NuevoProducto(null, true);
        nuevo.setVisible(true);
    }//GEN-LAST:event_btnNuevoMousePressed

    private void btnEliminarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMousePressed

        int result = JOptionPane.showConfirmDialog(null,"¿Eliminar registro?", "Esta operación es irreversible",
                                                        JOptionPane.YES_NO_OPTION,
                                                        JOptionPane.QUESTION_MESSAGE);
        
        if(result == JOptionPane.YES_OPTION){
            if (productoDao.eliminar(1, Integer.valueOf(id_producto))){
                refrescar();
                JOptionPane.showMessageDialog(null, "Registro eliminado");
            }
        }
    }//GEN-LAST:event_btnEliminarMousePressed

    private void btnExportarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportarMousePressed
        ExcelDAOImpl obj = new ExcelDAOImpl();
        try {
            obj.exportarExcel(tblProductos);
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnExportarMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnEditar;
    private javax.swing.JPanel btnEliminar;
    private javax.swing.JPanel btnExportar;
    private javax.swing.JPanel btnNuevo;
    private javax.swing.JPanel btnRefrescar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jspMarcas;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JLabel lblTituloMarcas;
    private javax.swing.JTable tblProductos;
    private Custom.TextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
