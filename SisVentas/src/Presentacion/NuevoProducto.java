package Presentacion;

import DAO.ProductoDao;
import DAO.ProductoDaoImpl;
import DB.Conexion;
import Entidad.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class NuevoProducto extends java.awt.Dialog {

    Producto producto;
    ProductoDao productoDao = new ProductoDaoImpl();
    
    Connection cnn;
    ResultSet rs;
    PreparedStatement ps;
    
    int id_producto;
    int id_marca;
    int id_categoria;
    
    int x = 0; //0 INSERTAR - 1 EDITAR
    
    public NuevoProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        comboCategoria();
        comboMarca();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel1.add(btnRgistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 320, -1));

        cboCategorias.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPanel1.add(cboCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 318, 50));

        cboMarcas.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPanel1.add(cboMarcas, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 318, 50));

        txtStock.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtStock.setLabelText("Stock");
        jPanel1.add(txtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 320, -1));

        txtNombreProducto.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtNombreProducto.setLabelText("Nombre del producto");
        jPanel1.add(txtNombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 320, -1));

        lblTitulo.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lblTitulo.setText("Nuevo producto");
        lblTitulo.setToolTipText("");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 224, -1));

        txtPrecioCompra.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtPrecioCompra.setLabelText("Precio de compra");
        jPanel1.add(txtPrecioCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 320, -1));

        txtPrecioVenta.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtPrecioVenta.setLabelText("Precio de venta");
        jPanel1.add(txtPrecioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 320, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void comboMarca()
    {				
        try
        {
            cnn = Conexion.MySQL();
            ps = cnn.prepareStatement("SELECT nombre_marca FROM marcas");
            rs = ps.executeQuery();

            while (rs.next())
            {
                cboMarcas.addItem(rs.getString(1));
            }
        }
        catch(Exception e) {}
    }
    
    private void comboCategoria()
    {				
        try
        {
            cnn = Conexion.MySQL();
            ps = cnn.prepareStatement("SELECT nombre_categoria FROM categorias");
            rs = ps.executeQuery();

            while (rs.next())
            {
                cboCategorias.addItem(rs.getString(1));
            }
        }
        catch(Exception e) {}
    }
    
    private void getIdMarca(String nombre_marca)
    {		
        try
        {
            cnn = Conexion.MySQL();
            ps = cnn.prepareStatement("SELECT id_marca FROM marcas WHERE nombre_marca LIKE '" + nombre_marca + "'");
            rs = ps.executeQuery();

            rs.next();
            id_marca = rs.getInt(1);
            System.out.println(id_marca);
        }
        catch(Exception e) {}
    }
    
    private void getIdCategoria(String nombre_categoria)
    {		
        try
        {
            cnn = Conexion.MySQL();
            ps = cnn.prepareStatement("SELECT id_categoria FROM categorias WHERE nombre_categoria LIKE '" + nombre_categoria + "'");
            rs = ps.executeQuery();

            rs.next();
            id_categoria = rs.getInt(1);
            System.out.println(id_categoria);
        }
        catch(Exception e) {}
    }
    
    private void btnRgistrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRgistrarMousePressed
        String nombre_producto = txtNombreProducto.getText();
        getIdCategoria(cboCategorias.getSelectedItem().toString());
        getIdMarca(cboMarcas.getSelectedItem().toString());
        double precio_compra = Double.valueOf(txtPrecioCompra.getText());
        double precio_venta = Double.valueOf(txtPrecioVenta.getText());
        int stock = Integer.parseInt(txtStock.getText());
        
        if (x == 0){
            producto = new Producto(0, nombre_producto, String.valueOf(id_categoria), String.valueOf(id_marca), precio_compra, precio_venta, stock, null, 0);

            if(productoDao.insertar(producto)){
                JOptionPane.showMessageDialog(null, "Registro exitoso");
                this.dispose();
            }
            else JOptionPane.showMessageDialog(null, "Error");
        }
        else if (x == 1){
            producto = new Producto(id_producto, nombre_producto, String.valueOf(id_categoria), String.valueOf(id_marca), precio_compra, precio_venta, stock, null, 0);

            if(productoDao.editar(producto)){
                x = 0;
                JOptionPane.showMessageDialog(null, "Registro modificado");
                this.dispose();
            }
            else JOptionPane.showMessageDialog(null, "Error");
        }
    }//GEN-LAST:event_btnRgistrarMousePressed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NuevoProducto dialog = new NuevoProducto(new java.awt.Frame(), true);
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
    public final javax.swing.JComboBox<String> cboCategorias = new javax.swing.JComboBox<>();
    public final javax.swing.JComboBox<String> cboMarcas = new javax.swing.JComboBox<>();
    private javax.swing.JPanel jPanel1;
    public final javax.swing.JLabel lblRegistrarEditar = new javax.swing.JLabel();
    public final javax.swing.JLabel lblTitulo = new javax.swing.JLabel();
    public final Custom.TextField txtNombreProducto = new Custom.TextField();
    public final Custom.TextField txtPrecioCompra = new Custom.TextField();
    public final Custom.TextField txtPrecioVenta = new Custom.TextField();
    public final Custom.TextField txtStock = new Custom.TextField();
    // End of variables declaration//GEN-END:variables
}
