package Presentacion;

import DB.Conexion;
import static Presentacion.DetalleVenta.id_venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class BusquedaProductosProv extends java.awt.Dialog {

    DefaultTableModel tableModel = new DefaultTableModel();   
    
    private ResultSet rs;
    private PreparedStatement ps;
    private Connection cnn;
    
    public BusquedaProductosProv(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        
        tblProductos.setModel(tableModel);
        tableModel.addColumn("ID");
        tableModel.addColumn("PRODUCTO");
        tableModel.addColumn("CATEGORIA");
        tableModel.addColumn("MARCA");
        tableModel.addColumn("PRECIO COMPRA");
        tableModel.addColumn("STOCK");
        
        cargarTable();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblProductosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblProductos);

        lblTitulo.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lblTitulo.setText("Selecciona un producto");
        lblTitulo.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 983, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void cargarTable(){
        try
        {
            cnn = Conexion.MySQL();
            ps = cnn.prepareStatement("SELECT productos.id_producto, productos.nombre_producto, categorias.nombre_categoria, marcas.nombre_marca, productos.precio_compra, productos.stock FROM productos "
                    + "                     JOIN categorias ON categorias.id_categoria = productos.id_categoria "
                    + "                     JOIN marcas ON marcas.id_marca = productos.id_marca "
                    + "                     WHERE productos.nombre_producto LIKE '%%' "
                    + "                     AND productos.estado=0 "
                    + "                     AND productos.stock > 0 "
                    + "                     ORDER BY id_producto DESC");
            rs = ps.executeQuery();
            
            tableModel.setRowCount(0);
            
            while (rs.next())
            {
                Object Datos[] =
                {
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getDouble(5),
                    rs.getInt(6)
                };    
                
                tableModel.addRow(Datos);
            }
        }
        
        catch (Exception ex) {System.out.println(""+ex);}
    }
    
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void tblProductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMousePressed
        if (evt.getClickCount() == 2){
            String id_producto = tblProductos.getValueAt(tblProductos.getSelectedRow(), 0).toString();
            String producto = tblProductos.getValueAt(tblProductos.getSelectedRow(), 1).toString();
            String precio = tblProductos.getValueAt(tblProductos.getSelectedRow(), 4).toString();
            String stock = tblProductos.getValueAt(tblProductos.getSelectedRow(), 5).toString();
            NuevaCompra.txtIdProducto.setText(id_producto);
            NuevaCompra.txtProducto.setText(producto);
            NuevaCompra.txtPrecio.setText(precio);
            NuevaCompra.txtStock.setText(stock);
            this.dispose();
        }
    }//GEN-LAST:event_tblProductosMousePressed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BusquedaProductosProv dialog = new BusquedaProductosProv(new java.awt.Frame(), true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public final javax.swing.JLabel lblTitulo = new javax.swing.JLabel();
    private javax.swing.JTable tblProductos;
    // End of variables declaration//GEN-END:variables
}
