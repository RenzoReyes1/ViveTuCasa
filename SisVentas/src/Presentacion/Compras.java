package Presentacion;

import DB.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class Compras extends javax.swing.JPanel {

    DefaultTableModel tableModel = new DefaultTableModel();   
    
    private ResultSet rs;
    private PreparedStatement ps;
    private Connection cnn;
    
    public Compras() {
        initComponents();
        
        tblCompras.setModel(tableModel);
        tableModel.addColumn("ID");
        tableModel.addColumn("RAZON SOCIAL");
        tableModel.addColumn("TIPO COMPROBANTE");
        tableModel.addColumn("NRO COMPROBANTE");
        tableModel.addColumn("FECHA");
        tableModel.addColumn("TOTAL");
        
        cargarTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTituloMarcas = new javax.swing.JLabel();
        txtBusqueda = new Custom.TextField();
        lblBusqueda = new javax.swing.JLabel();
        jspMarcas = new javax.swing.JScrollPane();
        tblCompras = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTituloMarcas.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        lblTituloMarcas.setForeground(new java.awt.Color(13, 22, 81));
        lblTituloMarcas.setText("Administrar Compras");
        add(lblTituloMarcas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

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

        jspMarcas.setBackground(new java.awt.Color(255, 255, 255));
        jspMarcas.setBorder(null);

        tblCompras.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tblCompras.setForeground(new java.awt.Color(32, 40, 87));
        tblCompras.setModel(new javax.swing.table.DefaultTableModel(
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
        tblCompras.setFocusable(false);
        tblCompras.setGridColor(new java.awt.Color(247, 248, 252));
        tblCompras.setOpaque(false);
        tblCompras.setRowHeight(40);
        tblCompras.setSelectionBackground(new java.awt.Color(247, 248, 252));
        tblCompras.setSelectionForeground(new java.awt.Color(32, 40, 87));
        tblCompras.setShowVerticalLines(false);
        tblCompras.getTableHeader().setReorderingAllowed(false);
        tblCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblComprasMousePressed(evt);
            }
        });
        jspMarcas.setViewportView(tblCompras);

        add(jspMarcas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 1030, 450));
    }// </editor-fold>//GEN-END:initComponents

    public void cargarTable()
    {
        try
        {
            cnn = Conexion.MySQL();
            ps = cnn.prepareStatement("SELECT compras.id_compra, proveedores.razon_social, compras.tipo_comprobante, compras.nro_comprobante, compras.fecha, compras.total FROM compras JOIN usuarios ON usuarios.id_usuario = compras.id_usuario JOIN proveedores ON proveedores.id_proveedor = compras.id_proveedor WHERE compras.id_compra LIKE '%%' ORDER BY id_compra DESC");
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
                    rs.getDate(5),
                    rs.getDouble(6),
                };    
                
                tableModel.addRow(Datos);
            }
        }
        
        catch (Exception ex) {}
    }
    
    
    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        //String busqueda = txtBusqueda.getText();
        //cargarTable(busqueda);
        //tblVentas.setModel(tableModel);
    }//GEN-LAST:event_txtBusquedaKeyReleased

    private void tblComprasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblComprasMousePressed
        if (evt.getClickCount() == 2){
            int id_venta = Integer.parseInt(tblCompras.getValueAt(tblCompras.getSelectedRow(), 0).toString());
            DetalleVenta detalleVenta = new DetalleVenta(null, true);
            detalleVenta.id_venta = id_venta;
            detalleVenta.cargarTable(id_venta);
            detalleVenta.setVisible(true);
        }
    }//GEN-LAST:event_tblComprasMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jspMarcas;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JLabel lblTituloMarcas;
    private javax.swing.JTable tblCompras;
    private Custom.TextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
