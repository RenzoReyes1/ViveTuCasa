package Presentacion;

import DAO.CompraDao;
import DAO.CompraDaoImpl;
import DAO.DetalleCompraDao;
import DAO.DetalleCompraDaoImpl;
import DAO.ProductoDao;
import DAO.ProductoDaoImpl;
import Entidad.Compra;
import Entidad.DetalleCompra;
import Entidad.Producto;
import Util.Funciones;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class NuevaCompra extends javax.swing.JPanel {

    DefaultTableModel tableModelDetalleCompra = new DefaultTableModel();
    
    Producto producto;
    ProductoDao productoDao = new ProductoDaoImpl();
    CompraDao compraDao = new CompraDaoImpl();
    DetalleCompraDao detalleCompraDao = new DetalleCompraDaoImpl();
    
    public NuevaCompra() {
        initComponents();
        
        fecha();
        ocultarIds();
        generarCorrelativoBoleta();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTituloMarcas2 = new javax.swing.JLabel();
        txtIdProveedor = new javax.swing.JTextField();
        txtIdProducto = new javax.swing.JTextField();
        cboTipoComprobante = new javax.swing.JComboBox<>();
        txtFecha = new Custom.TextField();
        lblTituloMarcas3 = new javax.swing.JLabel();
        txtNroDocumento = new Custom.TextField();
        txtRazonSocial = new Custom.TextField();
        jLabel3 = new javax.swing.JLabel();
        txtProducto = new Custom.TextField();
        lblTituloMarcas1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPrecio = new Custom.TextField();
        txtStock = new Custom.TextField();
        txtCantidad = new Custom.TextField();
        btnAgregar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalleCompra = new javax.swing.JTable();
        lblTituloMarcas5 = new javax.swing.JLabel();
        lblTituloMarcas4 = new javax.swing.JLabel();
        txtTotal = new Custom.TextField();
        btnRealizarCompra = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnQuitar = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblTituloMarcas = new javax.swing.JLabel();
        txtNroComprobante = new Custom.TextField();
        btnBuscarProductos = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnBuscarProveedor = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblTituloMarcas8 = new javax.swing.JLabel();
        lblTituloMarcas9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTituloMarcas2.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        lblTituloMarcas2.setForeground(new java.awt.Color(13, 22, 81));
        lblTituloMarcas2.setText("Nueva Compra");
        add(lblTituloMarcas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));
        add(txtIdProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 50, -1));
        add(txtIdProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 50, -1));

        cboTipoComprobante.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        cboTipoComprobante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Boleta" }));
        add(cboTipoComprobante, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 270, 50));

        txtFecha.setBackground(new java.awt.Color(247, 248, 252));
        txtFecha.setForeground(new java.awt.Color(32, 40, 87));
        txtFecha.setEnabled(false);
        txtFecha.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtFecha.setLabelText("");
        txtFecha.setLineColor(new java.awt.Color(62, 101, 242));
        txtFecha.setPreferredSize(new java.awt.Dimension(54, 50));
        add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 160, 50));

        lblTituloMarcas3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblTituloMarcas3.setForeground(new java.awt.Color(13, 22, 81));
        lblTituloMarcas3.setText("Datos del proveedor");
        add(lblTituloMarcas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        txtNroDocumento.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtNroDocumento.setLabelText("Número de documento");
        txtNroDocumento.setLineColor(new java.awt.Color(62, 101, 242));
        txtNroDocumento.setPreferredSize(new java.awt.Dimension(54, 50));
        add(txtNroDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 170, 50));

        txtRazonSocial.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtRazonSocial.setLabelText("Razon Social");
        txtRazonSocial.setLineColor(new java.awt.Color(62, 101, 242));
        txtRazonSocial.setPreferredSize(new java.awt.Dimension(54, 50));
        add(txtRazonSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 330, 50));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/busqueda_white.png"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        txtProducto.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtProducto.setLabelText("Descripción del producto");
        txtProducto.setLineColor(new java.awt.Color(62, 101, 242));
        txtProducto.setPreferredSize(new java.awt.Dimension(54, 50));
        add(txtProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 510, 50));

        lblTituloMarcas1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblTituloMarcas1.setForeground(new java.awt.Color(13, 22, 81));
        lblTituloMarcas1.setText("Agrega productos");
        add(lblTituloMarcas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/busqueda_white.png"))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        txtPrecio.setEditable(false);
        txtPrecio.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtPrecio.setLabelText("Precio");
        txtPrecio.setLineColor(new java.awt.Color(62, 101, 242));
        txtPrecio.setPreferredSize(new java.awt.Dimension(54, 50));
        add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 170, 50));

        txtStock.setEditable(false);
        txtStock.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtStock.setLabelText("Stock");
        txtStock.setLineColor(new java.awt.Color(62, 101, 242));
        txtStock.setPreferredSize(new java.awt.Dimension(54, 50));
        add(txtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, 120, 50));

        txtCantidad.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtCantidad.setLabelText("Cantidad");
        txtCantidad.setLineColor(new java.awt.Color(62, 101, 242));
        txtCantidad.setPreferredSize(new java.awt.Dimension(54, 50));
        add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, 120, 50));

        btnAgregar.setBackground(new java.awt.Color(0, 202, 128));
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAgregarMousePressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/agregar_1.png"))); // NOI18N
        jLabel2.setText("  Agregar");

        javax.swing.GroupLayout btnAgregarLayout = new javax.swing.GroupLayout(btnAgregar);
        btnAgregar.setLayout(btnAgregarLayout);
        btnAgregarLayout.setHorizontalGroup(
            btnAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAgregarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnAgregarLayout.setVerticalGroup(
            btnAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnAgregarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 340, 170, -1));

        tblDetalleCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PRODUCTO", "PRECIO", "CANTIDAD", "IMPORTE"
            }
        ));
        jScrollPane1.setViewportView(tblDetalleCompra);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 840, 150));

        lblTituloMarcas5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblTituloMarcas5.setForeground(new java.awt.Color(13, 22, 81));
        lblTituloMarcas5.setText("Detalle de la orden");
        add(lblTituloMarcas5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, -1));

        lblTituloMarcas4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblTituloMarcas4.setForeground(new java.awt.Color(13, 22, 81));
        lblTituloMarcas4.setText("TOTAL:");
        add(lblTituloMarcas4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 633, -1, 40));

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtTotal.setLabelText("");
        txtTotal.setLineColor(new java.awt.Color(62, 101, 242));
        txtTotal.setPreferredSize(new java.awt.Dimension(54, 50));
        add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 630, 120, 50));

        btnRealizarCompra.setBackground(new java.awt.Color(45, 83, 218));
        btnRealizarCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnRealizarCompraMousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/realizar_venta.png"))); // NOI18N
        jLabel5.setText("  Realizar compra");

        javax.swing.GroupLayout btnRealizarCompraLayout = new javax.swing.GroupLayout(btnRealizarCompra);
        btnRealizarCompra.setLayout(btnRealizarCompraLayout);
        btnRealizarCompraLayout.setHorizontalGroup(
            btnRealizarCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnRealizarCompraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnRealizarCompraLayout.setVerticalGroup(
            btnRealizarCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnRealizarCompraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(btnRealizarCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 550, 170, -1));

        btnQuitar.setBackground(new java.awt.Color(255, 82, 108));
        btnQuitar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnQuitarMousePressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/agregar_1.png"))); // NOI18N
        jLabel6.setText("  Quitar");

        javax.swing.GroupLayout btnQuitarLayout = new javax.swing.GroupLayout(btnQuitar);
        btnQuitar.setLayout(btnQuitarLayout);
        btnQuitarLayout.setHorizontalGroup(
            btnQuitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnQuitarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnQuitarLayout.setVerticalGroup(
            btnQuitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnQuitarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(btnQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 480, 170, -1));

        lblTituloMarcas.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        lblTituloMarcas.setForeground(new java.awt.Color(13, 22, 81));
        lblTituloMarcas.setText("BOLETA DE COMPRA");
        add(lblTituloMarcas, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 60, 350, -1));

        txtNroComprobante.setBackground(new java.awt.Color(247, 248, 252));
        txtNroComprobante.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNroComprobante.setDisabledTextColor(new java.awt.Color(32, 40, 87));
        txtNroComprobante.setEnabled(false);
        txtNroComprobante.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        txtNroComprobante.setLabelText("");
        txtNroComprobante.setLineColor(new java.awt.Color(62, 101, 242));
        txtNroComprobante.setPreferredSize(new java.awt.Dimension(54, 50));
        add(txtNroComprobante, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 120, 110, 50));

        btnBuscarProductos.setBackground(new java.awt.Color(45, 83, 218));
        btnBuscarProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBuscarProductosMousePressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/busqueda_white.png"))); // NOI18N

        javax.swing.GroupLayout btnBuscarProductosLayout = new javax.swing.GroupLayout(btnBuscarProductos);
        btnBuscarProductos.setLayout(btnBuscarProductosLayout);
        btnBuscarProductosLayout.setHorizontalGroup(
            btnBuscarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnBuscarProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnBuscarProductosLayout.setVerticalGroup(
            btnBuscarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnBuscarProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(btnBuscarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, 50, -1));

        btnBuscarProveedor.setBackground(new java.awt.Color(45, 83, 218));
        btnBuscarProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBuscarProveedorMousePressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/busqueda_white.png"))); // NOI18N

        javax.swing.GroupLayout btnBuscarProveedorLayout = new javax.swing.GroupLayout(btnBuscarProveedor);
        btnBuscarProveedor.setLayout(btnBuscarProveedorLayout);
        btnBuscarProveedorLayout.setHorizontalGroup(
            btnBuscarProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnBuscarProveedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnBuscarProveedorLayout.setVerticalGroup(
            btnBuscarProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnBuscarProveedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(btnBuscarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, 50, -1));

        lblTituloMarcas8.setFont(new java.awt.Font("Century Gothic", 1, 30)); // NOI18N
        lblTituloMarcas8.setForeground(new java.awt.Color(13, 22, 81));
        lblTituloMarcas8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloMarcas8.setText("NRO:");
        add(lblTituloMarcas8, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 120, 80, 50));

        lblTituloMarcas9.setFont(new java.awt.Font("Century Gothic", 1, 30)); // NOI18N
        lblTituloMarcas9.setForeground(new java.awt.Color(13, 22, 81));
        lblTituloMarcas9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloMarcas9.setText("RUC 20231045856");
        add(lblTituloMarcas9, new org.netbeans.lib.awtextra.AbsoluteConstraints(714, 20, 340, -1));
    }// </editor-fold>//GEN-END:initComponents

    void fecha(){
        Funciones funciones = new Funciones();
        String fecha = funciones.getFechaActual();
        txtFecha.setText(fecha);
    }
    
    private void ocultarIds(){
        txtIdProveedor.setVisible(false);
        txtIdProducto.setVisible(false);
    }
    
    private void agregarProductos(){
        double importe, total;
        tableModelDetalleCompra = (DefaultTableModel) tblDetalleCompra.getModel();
        
        String id_producto = txtIdProducto.getText();
        String nombre_producto = txtTotal.getText();
        double cantidad = Double.parseDouble(txtCantidad.getText());
        double precio = Double.parseDouble(txtPrecio.getText());
        importe = precio * cantidad;
        
        ArrayList listDetalleVenta = new ArrayList();
        listDetalleVenta.add(txtIdProducto.getText());
        listDetalleVenta.add(txtProducto.getText());
        listDetalleVenta.add(txtPrecio.getText());
        listDetalleVenta.add(txtCantidad.getText());
        listDetalleVenta.add(importe);
        
        Object[] obj = new Object[5];
        obj[0] = listDetalleVenta.get(0);
        obj[1] = listDetalleVenta.get(1);
        obj[2] = listDetalleVenta.get(2);
        obj[3] = listDetalleVenta.get(3);
        obj[4] = listDetalleVenta.get(4);
        tableModelDetalleCompra.addRow(obj);
        tblDetalleCompra.setModel(tableModelDetalleCompra);
        calcularTotal();
        limpiarDetalleAgregado();
    }
    
    private void removerProductos(){
         DefaultTableModel compras = (DefaultTableModel) tblDetalleCompra.getModel();
         int item = tblDetalleCompra.getSelectedRow();
         if (item >= 0){
             compras.removeRow(item);
             calcularTotal();
         }
         else JOptionPane.showMessageDialog(null, "Seleccione el item que desea quitar");
    }
    
    private void calcularTotal(){
        double subtotal=0, total=0;
        
        for (int i = 0; i < tblDetalleCompra.getRowCount(); i++) {
            int cantidad = Integer.parseInt(tblDetalleCompra.getValueAt(i, 3).toString());
            double precio = Double.valueOf(tblDetalleCompra.getValueAt(i, 2).toString());
             double importe = Double.valueOf(tblDetalleCompra.getValueAt(i, 4).toString());
             
             subtotal = subtotal + (precio*cantidad);
             total = subtotal;
        }
        
        txtTotal.setText("" + total);
    }
    
    private void limpiarDetalleAgregado(){
        txtIdProducto.setText("");
        txtProducto.setText("");
        txtPrecio.setText("");
        txtCantidad.setText("");
        txtStock.setText("");
    }
    
    private void btnAgregarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMousePressed
        if (txtProducto.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Por favor agregue un producto");
            return;
        }

        else if (txtCantidad.getText().length() == 0){
            JOptionPane.showMessageDialog(null, "Ingresa una cantidad");
            return;
        }
        int stock = Integer.parseInt(txtStock.getText());
        int cantidad = Integer.parseInt(txtCantidad.getText());
        if (stock >= cantidad){
            agregarProductos();
            limpiarDetalleAgregado();
        }
        else {
            JOptionPane.showMessageDialog(null, "No hay el stock suficiente");
            return;
        }

        agregarProductos();
        limpiarDetalleAgregado();
    }//GEN-LAST:event_btnAgregarMousePressed

    private void btnRealizarCompraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRealizarCompraMousePressed
        if (txtRazonSocial.getText().length() == 0){
            JOptionPane.showMessageDialog(null, "Seleccione un proveedor");
            txtRazonSocial.requestFocus();
            return;
        }

        if (txtTotal.getText().length() == 0){
            JOptionPane.showMessageDialog(null, "Por favor agregue productos");
            return;
        }

        insertarCompra();
        limpiarFormulario();
        generarCorrelativoBoleta();
    }//GEN-LAST:event_btnRealizarCompraMousePressed

    private void insertarCompra(){
        Compra compra = new Compra();
        compra.setId_proveedor(Integer.parseInt(txtIdProveedor.getText()));
        compra.setId_usuario(1);
        compra.setTipo_comprobante(cboTipoComprobante.getSelectedItem().toString());
        compra.setNro_comprobante(txtNroComprobante.getText());
        compra.setTotal(Double.valueOf(txtTotal.getText()));
        compra.setEstado(0);
        
        if(compraDao.insertar(compra)){
            insertarDetalleCompra();   
        }
    }
    
    private void insertarDetalleCompra(){
        String id_compra = compraDao.getMaxIdCompra();
        DetalleCompra detalleCompra = new DetalleCompra();
        
        for (int i = 0; i < tblDetalleCompra.getRowCount(); i++) {
            detalleCompra.setId_compra(Integer.parseInt(id_compra));
            detalleCompra.setId_producto(Integer.parseInt(tblDetalleCompra.getValueAt(i, 0).toString()));
            detalleCompra.setCantidad(Integer.parseInt(tblDetalleCompra.getValueAt(i, 3).toString()));
            detalleCompra.setPrecio(Double.valueOf(tblDetalleCompra.getValueAt(i, 2).toString()));
            detalleCompra.setImporte(Double.valueOf(tblDetalleCompra.getValueAt(i, 4).toString()));
            detalleCompraDao.insertar(detalleCompra);
            productoDao.aumentarStock(Integer.parseInt(tblDetalleCompra.getValueAt(i, 0).toString()), Integer.parseInt(tblDetalleCompra.getValueAt(i, 3).toString()));
        }
    }
    
    private void limpiarDetalleCompra(){
        for (int i = 0; i < tblDetalleCompra.getRowCount(); i++) {
            tableModelDetalleCompra.removeRow(i);
            i = i-1;
        }
    }
    
    private void limpiarFormulario(){
        txtIdProveedor.setText("");
        txtRazonSocial.setText("");
        txtNroDocumento.setText("");

        txtCantidad.setText("");
        txtTotal.setText("");
        limpiarDetalleCompra();
    }
    
    void generarCorrelativoBoleta(){
        DecimalFormat df = new DecimalFormat("0000");
        txtNroComprobante.setText(df.format(compraDao.generarComprobanteBoleta()+1));
    }

    
    private void btnQuitarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuitarMousePressed
        removerProductos();
    }//GEN-LAST:event_btnQuitarMousePressed

    private void btnBuscarProductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarProductosMousePressed
        BusquedaProductosProv busquedaProductos = new BusquedaProductosProv(null, true);
        busquedaProductos.setVisible(true);
    }//GEN-LAST:event_btnBuscarProductosMousePressed

    private void btnBuscarProveedorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarProveedorMousePressed
        BusquedaProveedor busquedaProveedor = new BusquedaProveedor(null, true);
        busquedaProveedor.setVisible(true);
    }//GEN-LAST:event_btnBuscarProveedorMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnAgregar;
    private javax.swing.JPanel btnBuscarProductos;
    private javax.swing.JPanel btnBuscarProveedor;
    private javax.swing.JPanel btnQuitar;
    private javax.swing.JPanel btnRealizarCompra;
    private javax.swing.JComboBox<String> cboTipoComprobante;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTituloMarcas;
    private javax.swing.JLabel lblTituloMarcas1;
    private javax.swing.JLabel lblTituloMarcas2;
    private javax.swing.JLabel lblTituloMarcas3;
    private javax.swing.JLabel lblTituloMarcas4;
    private javax.swing.JLabel lblTituloMarcas5;
    private javax.swing.JLabel lblTituloMarcas8;
    private javax.swing.JLabel lblTituloMarcas9;
    private javax.swing.JTable tblDetalleCompra;
    public static Custom.TextField txtCantidad;
    private Custom.TextField txtFecha;
    public static javax.swing.JTextField txtIdProducto;
    public static javax.swing.JTextField txtIdProveedor;
    private Custom.TextField txtNroComprobante;
    public static Custom.TextField txtNroDocumento;
    public static Custom.TextField txtPrecio;
    public static Custom.TextField txtProducto;
    public static Custom.TextField txtRazonSocial;
    public static Custom.TextField txtStock;
    private Custom.TextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
