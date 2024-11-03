package Presentacion;

import DAO.DetalleVentaDao;
import DAO.DetalleVentaDaoImpl;
import DAO.ProductoDao;
import DAO.ProductoDaoImpl;
import DAO.VentaDao;
import DAO.VentaDaoImpl;
import DB.Conexion;
import Entidad.DetalleVenta;
import Entidad.Producto;
import Entidad.Venta;
import Util.Funciones;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class NuevaVenta extends javax.swing.JPanel {

    Producto producto;
    ProductoDao productoDao = new ProductoDaoImpl();
    DefaultTableModel tableModelDetalleVenta = new DefaultTableModel();
    
    VentaDao ventaDao = new VentaDaoImpl();
    DetalleVentaDao detalleVentaDao = new DetalleVentaDaoImpl();
    
    public NuevaVenta() {
        initComponents();
        fecha();
        ocultarIds();
        generarCorrelativoBoleta();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl = new javax.swing.JPanel();
        lblTituloMarcas = new javax.swing.JLabel();
        lblTituloMarcas1 = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalleVenta = new javax.swing.JTable();
        txtIdProducto = new javax.swing.JTextField();
        cboTipoComprobante = new javax.swing.JComboBox<>();
        txtTotal = new Custom.TextField();
        txtFecha = new Custom.TextField();
        txtNroDocumento = new Custom.TextField();
        lblTituloMarcas2 = new javax.swing.JLabel();
        lblTituloMarcas3 = new javax.swing.JLabel();
        lblTituloMarcas4 = new javax.swing.JLabel();
        txtCliente = new Custom.TextField();
        lblTituloMarcas5 = new javax.swing.JLabel();
        txtProducto = new Custom.TextField();
        txtPrecio = new Custom.TextField();
        txtStock = new Custom.TextField();
        txtCantidad = new Custom.TextField();
        btnAgregar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnBuscarCliente = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnBuscarProductos = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnRealizarVenta = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnQuitar = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblTituloMarcas7 = new javax.swing.JLabel();
        txtNroComprobante = new Custom.TextField();
        txtSerie = new Custom.TextField();
        lblTituloMarcas8 = new javax.swing.JLabel();

        pnl.setBackground(new java.awt.Color(255, 255, 255));
        pnl.setForeground(new java.awt.Color(32, 40, 87));
        pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTituloMarcas.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        lblTituloMarcas.setForeground(new java.awt.Color(13, 22, 81));
        lblTituloMarcas.setText("BOLETA DE VENTA");
        pnl.add(lblTituloMarcas, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 60, -1, -1));

        lblTituloMarcas1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblTituloMarcas1.setForeground(new java.awt.Color(13, 22, 81));
        lblTituloMarcas1.setText("Agrega productos");
        pnl.add(lblTituloMarcas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));
        pnl.add(txtIdCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 50, -1));

        tblDetalleVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PRODUCTO", "PRECIO", "CANTIDAD", "IMPORTE"
            }
        ));
        jScrollPane1.setViewportView(tblDetalleVenta);

        pnl.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 840, 150));
        pnl.add(txtIdProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 50, -1));

        cboTipoComprobante.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        cboTipoComprobante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Boleta" }));
        pnl.add(cboTipoComprobante, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 270, 50));

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtTotal.setLabelText("");
        txtTotal.setLineColor(new java.awt.Color(62, 101, 242));
        txtTotal.setPreferredSize(new java.awt.Dimension(54, 50));
        pnl.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 630, 120, 50));

        txtFecha.setBackground(new java.awt.Color(247, 248, 252));
        txtFecha.setForeground(new java.awt.Color(32, 40, 87));
        txtFecha.setEnabled(false);
        txtFecha.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtFecha.setLabelText("");
        txtFecha.setLineColor(new java.awt.Color(62, 101, 242));
        txtFecha.setPreferredSize(new java.awt.Dimension(54, 50));
        pnl.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 160, 50));

        txtNroDocumento.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtNroDocumento.setLabelText("Número de documento");
        txtNroDocumento.setLineColor(new java.awt.Color(62, 101, 242));
        txtNroDocumento.setPreferredSize(new java.awt.Dimension(54, 50));
        pnl.add(txtNroDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 170, 50));

        lblTituloMarcas2.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        lblTituloMarcas2.setForeground(new java.awt.Color(13, 22, 81));
        lblTituloMarcas2.setText("Nueva Venta");
        pnl.add(lblTituloMarcas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        lblTituloMarcas3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblTituloMarcas3.setForeground(new java.awt.Color(13, 22, 81));
        lblTituloMarcas3.setText("Datos del cliente");
        pnl.add(lblTituloMarcas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        lblTituloMarcas4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblTituloMarcas4.setForeground(new java.awt.Color(13, 22, 81));
        lblTituloMarcas4.setText("TOTAL:");
        pnl.add(lblTituloMarcas4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 633, -1, 40));

        txtCliente.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtCliente.setLabelText("Cliente");
        txtCliente.setLineColor(new java.awt.Color(62, 101, 242));
        txtCliente.setPreferredSize(new java.awt.Dimension(54, 50));
        pnl.add(txtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 330, 50));

        lblTituloMarcas5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblTituloMarcas5.setForeground(new java.awt.Color(13, 22, 81));
        lblTituloMarcas5.setText("Detalle de la orden");
        pnl.add(lblTituloMarcas5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, -1));

        txtProducto.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtProducto.setLabelText("Descripción del producto");
        txtProducto.setLineColor(new java.awt.Color(62, 101, 242));
        txtProducto.setPreferredSize(new java.awt.Dimension(54, 50));
        pnl.add(txtProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 510, 50));

        txtPrecio.setEditable(false);
        txtPrecio.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtPrecio.setLabelText("Precio");
        txtPrecio.setLineColor(new java.awt.Color(62, 101, 242));
        txtPrecio.setPreferredSize(new java.awt.Dimension(54, 50));
        pnl.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 170, 50));

        txtStock.setEditable(false);
        txtStock.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtStock.setLabelText("Stock");
        txtStock.setLineColor(new java.awt.Color(62, 101, 242));
        txtStock.setPreferredSize(new java.awt.Dimension(54, 50));
        pnl.add(txtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, 120, 50));

        txtCantidad.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtCantidad.setLabelText("Cantidad");
        txtCantidad.setLineColor(new java.awt.Color(62, 101, 242));
        txtCantidad.setPreferredSize(new java.awt.Dimension(54, 50));
        pnl.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, 120, 50));

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

        pnl.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 340, 170, -1));

        btnBuscarCliente.setBackground(new java.awt.Color(45, 83, 218));
        btnBuscarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBuscarClienteMousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/busqueda_white.png"))); // NOI18N

        javax.swing.GroupLayout btnBuscarClienteLayout = new javax.swing.GroupLayout(btnBuscarCliente);
        btnBuscarCliente.setLayout(btnBuscarClienteLayout);
        btnBuscarClienteLayout.setHorizontalGroup(
            btnBuscarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnBuscarClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnBuscarClienteLayout.setVerticalGroup(
            btnBuscarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnBuscarClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnl.add(btnBuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, 50, -1));

        btnBuscarProductos.setBackground(new java.awt.Color(45, 83, 218));
        btnBuscarProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBuscarProductosMousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/busqueda_white.png"))); // NOI18N

        javax.swing.GroupLayout btnBuscarProductosLayout = new javax.swing.GroupLayout(btnBuscarProductos);
        btnBuscarProductos.setLayout(btnBuscarProductosLayout);
        btnBuscarProductosLayout.setHorizontalGroup(
            btnBuscarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnBuscarProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnBuscarProductosLayout.setVerticalGroup(
            btnBuscarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnBuscarProductosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnl.add(btnBuscarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, 50, -1));

        btnRealizarVenta.setBackground(new java.awt.Color(45, 83, 218));
        btnRealizarVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnRealizarVentaMousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/realizar_venta.png"))); // NOI18N
        jLabel5.setText("  Realizar venta");

        javax.swing.GroupLayout btnRealizarVentaLayout = new javax.swing.GroupLayout(btnRealizarVenta);
        btnRealizarVenta.setLayout(btnRealizarVentaLayout);
        btnRealizarVentaLayout.setHorizontalGroup(
            btnRealizarVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnRealizarVentaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnRealizarVentaLayout.setVerticalGroup(
            btnRealizarVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnRealizarVentaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnl.add(btnRealizarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 550, 170, -1));

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

        pnl.add(btnQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 480, 170, -1));

        lblTituloMarcas7.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        lblTituloMarcas7.setForeground(new java.awt.Color(13, 22, 81));
        lblTituloMarcas7.setText("-");
        pnl.add(lblTituloMarcas7, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 120, 10, 50));

        txtNroComprobante.setBackground(new java.awt.Color(247, 248, 252));
        txtNroComprobante.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNroComprobante.setDisabledTextColor(new java.awt.Color(32, 40, 87));
        txtNroComprobante.setEnabled(false);
        txtNroComprobante.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        txtNroComprobante.setLabelText("");
        txtNroComprobante.setLineColor(new java.awt.Color(62, 101, 242));
        txtNroComprobante.setPreferredSize(new java.awt.Dimension(54, 50));
        pnl.add(txtNroComprobante, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 120, 110, 50));

        txtSerie.setBackground(new java.awt.Color(247, 248, 252));
        txtSerie.setForeground(new java.awt.Color(32, 40, 87));
        txtSerie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSerie.setDisabledTextColor(new java.awt.Color(32, 40, 87));
        txtSerie.setEnabled(false);
        txtSerie.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        txtSerie.setLabelText("");
        txtSerie.setLineColor(new java.awt.Color(62, 101, 242));
        txtSerie.setPreferredSize(new java.awt.Dimension(54, 50));
        pnl.add(txtSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 120, 110, 50));

        lblTituloMarcas8.setFont(new java.awt.Font("Century Gothic", 1, 30)); // NOI18N
        lblTituloMarcas8.setForeground(new java.awt.Color(13, 22, 81));
        lblTituloMarcas8.setText("RUC 20231045856");
        pnl.add(lblTituloMarcas8, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarClienteMousePressed
        BusquedaCliente busquedaCliente = new BusquedaCliente(null, true);
        busquedaCliente.setVisible(true);
    }//GEN-LAST:event_btnBuscarClienteMousePressed

    private void btnBuscarProductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarProductosMousePressed
        BusquedaProductos busquedaProductos = new BusquedaProductos(null, true);
        busquedaProductos.setVisible(true);
    }//GEN-LAST:event_btnBuscarProductosMousePressed

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

    private void btnQuitarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuitarMousePressed
        removerProductos();
    }//GEN-LAST:event_btnQuitarMousePressed

    private void btnRealizarVentaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRealizarVentaMousePressed
        if (txtCliente.getText().length() == 0){
            JOptionPane.showMessageDialog(null, "Seleccione un cliente");
            txtCliente.requestFocus();
            return;
        }
        
        if (txtTotal.getText().length() == 0){
            JOptionPane.showMessageDialog(null, "Por favor agregue productos");
            return;
        }
        
        insertarVenta();
        limpiarFormulario();
        generarCorrelativoBoleta();
    }//GEN-LAST:event_btnRealizarVentaMousePressed

    
    void fecha(){
        Funciones funciones = new Funciones();
        String fecha = funciones.getFechaActual();
        txtFecha.setText(fecha);
    }
    
    private void ocultarIds(){
        txtIdCliente.setVisible(false);
        txtIdProducto.setVisible(false);
    }
    
    private void agregarProductos(){
        double importe, total;
        tableModelDetalleVenta = (DefaultTableModel) tblDetalleVenta.getModel();
        
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
        tableModelDetalleVenta.addRow(obj);
        tblDetalleVenta.setModel(tableModelDetalleVenta);
        calcularTotal();
        limpiarDetalleAgregado();
    }
    
    private void removerProductos(){
         DefaultTableModel compras = (DefaultTableModel) tblDetalleVenta.getModel();
         int item = tblDetalleVenta.getSelectedRow();
         if (item >= 0){
             compras.removeRow(item);
             calcularTotal();
         }
         else JOptionPane.showMessageDialog(null, "Seleccione el item que desea quitar");
    }
    
    private void calcularTotal(){
        double subtotal=0, total=0;
        
        for (int i = 0; i < tblDetalleVenta.getRowCount(); i++) {
            int cantidad = Integer.parseInt(tblDetalleVenta.getValueAt(i, 3).toString());
            double precio = Double.valueOf(tblDetalleVenta.getValueAt(i, 2).toString());
             double importe = Double.valueOf(tblDetalleVenta.getValueAt(i, 4).toString());
             
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
    
    private void insertarVenta(){
        Venta venta = new Venta();
        venta.setId_cliente(Integer.parseInt(txtIdCliente.getText()));
        venta.setId_usuario(1);
        venta.setTipo_comprobante(cboTipoComprobante.getSelectedItem().toString());
        venta.setNro_comprobante(txtNroComprobante.getText());
        venta.setTotal(Double.valueOf(txtTotal.getText()));
        venta.setEstado(0);
        
        if(ventaDao.insertar(venta)){
            insertarDetalleVenta();   
        }
    }
    
    private void insertarDetalleVenta(){
        String id_venta = ventaDao.getMaxIdVenta();
        DetalleVenta detalleVenta = new DetalleVenta();
        
        for (int i = 0; i < tblDetalleVenta.getRowCount(); i++) {
            detalleVenta.setId_venta(Integer.parseInt(id_venta));
            detalleVenta.setId_producto(Integer.parseInt(tblDetalleVenta.getValueAt(i, 0).toString()));
            detalleVenta.setCantidad(Integer.parseInt(tblDetalleVenta.getValueAt(i, 3).toString()));
            detalleVenta.setPrecio(Double.valueOf(tblDetalleVenta.getValueAt(i, 2).toString()));
            detalleVenta.setImporte(Double.valueOf(tblDetalleVenta.getValueAt(i, 4).toString()));
            detalleVentaDao.insertar(detalleVenta);
            productoDao.disminuirStock(Integer.parseInt(tblDetalleVenta.getValueAt(i, 0).toString()), Integer.parseInt(tblDetalleVenta.getValueAt(i, 3).toString()));
            imprimirBoleta(Integer.valueOf(id_venta));
        }
    }
    
    private void imprimirBoleta(int id_venta){
            Map p = new HashMap();
            p.put("id_venta", id_venta);
            
            JasperReport report;
            JasperPrint print;
            
            try {
                report=JasperCompileManager.compileReport(new File("").getAbsolutePath() + "/src/Reportes/ComprobanteVenta.jrxml");
                print = JasperFillManager.fillReport(report, p, Conexion.MySQL());
                JasperViewer view = new JasperViewer(print,false);
                view.setTitle("Comprobante Venta");
                view.setVisible(true);
            } catch (JRException e) {
                e.printStackTrace();
            }
    }
    
    private void limpiarDetalleVenta(){
        for (int i = 0; i < tblDetalleVenta.getRowCount(); i++) {
            tableModelDetalleVenta.removeRow(i);
            i = i-1;
        }
    }
    
    private void limpiarFormulario(){
        txtIdCliente.setText("");
        txtCliente.setText("");
        txtNroDocumento.setText("");

        txtCantidad.setText("");
        txtTotal.setText("");
        limpiarDetalleVenta();
    }
    
    void generarCorrelativoBoleta(){
        DecimalFormat df = new DecimalFormat("0000");
        txtSerie.setText("B001");
        txtNroComprobante.setText(df.format(ventaDao.generarComprobanteBoleta()+1));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnAgregar;
    private javax.swing.JPanel btnBuscarCliente;
    private javax.swing.JPanel btnBuscarProductos;
    private javax.swing.JPanel btnQuitar;
    private javax.swing.JPanel btnRealizarVenta;
    private javax.swing.JComboBox<String> cboTipoComprobante;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTituloMarcas;
    private javax.swing.JLabel lblTituloMarcas1;
    private javax.swing.JLabel lblTituloMarcas2;
    private javax.swing.JLabel lblTituloMarcas3;
    private javax.swing.JLabel lblTituloMarcas4;
    private javax.swing.JLabel lblTituloMarcas5;
    private javax.swing.JLabel lblTituloMarcas7;
    private javax.swing.JLabel lblTituloMarcas8;
    private javax.swing.JPanel pnl;
    private javax.swing.JTable tblDetalleVenta;
    public static Custom.TextField txtCantidad;
    public static Custom.TextField txtCliente;
    private Custom.TextField txtFecha;
    public static javax.swing.JTextField txtIdCliente;
    public static javax.swing.JTextField txtIdProducto;
    private Custom.TextField txtNroComprobante;
    public static Custom.TextField txtNroDocumento;
    public static Custom.TextField txtPrecio;
    public static Custom.TextField txtProducto;
    private Custom.TextField txtSerie;
    public static Custom.TextField txtStock;
    private Custom.TextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
