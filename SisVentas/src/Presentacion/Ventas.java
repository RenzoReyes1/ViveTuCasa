package Presentacion;

import DB.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class Ventas extends javax.swing.JPanel {
    
    DefaultTableModel tableModel = new DefaultTableModel();   
    
    private ResultSet rs;
    private PreparedStatement ps;
    private Connection cnn;
    
    public Ventas() {
        initComponents();
        
        tblVentas.setModel(tableModel);
        tableModel.addColumn("ID");
        tableModel.addColumn("USUARIO");
        tableModel.addColumn("CLIENTE");
        tableModel.addColumn("TIPO COMPROBANTE");
        tableModel.addColumn("NRO COMPROBANTE");
        tableModel.addColumn("FECHA");
        tableModel.addColumn("TOTAL");
        
        cargarTable();
    }
    
    public void cargarTable()
    {
        try
        {
            cnn = Conexion.MySQL();
            ps = cnn.prepareStatement("SELECT ventas.id_venta, CONCAT(usuarios.nombres, ' ', usuarios.apellidos) as usuario, "
                    + "                         clientes.nombres_apellidos, ventas.tipo_comprobante, ventas.nro_comprobante, ventas.fecha, ventas.total FROM ventas "
                    + "                         JOIN usuarios ON usuarios.id_usuario = ventas.id_usuario JOIN clientes ON clientes.id_cliente = ventas.id_cliente "
                    + "                         WHERE ventas.id_venta LIKE '%%' ORDER BY id_venta DESC");
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
                    rs.getString(5),
                    rs.getDate(6),
                    rs.getDouble(7),
                };    
                
                tableModel.addRow(Datos);
            }
        }
        
        catch (Exception ex) {}
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTituloMarcas = new javax.swing.JLabel();
        txtBusqueda = new Custom.TextField();
        lblBusqueda = new javax.swing.JLabel();
        jspMarcas = new javax.swing.JScrollPane();
        tblVentas = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTituloMarcas.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        lblTituloMarcas.setForeground(new java.awt.Color(13, 22, 81));
        lblTituloMarcas.setText("Administrar Ventas");
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

        tblVentas.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tblVentas.setForeground(new java.awt.Color(32, 40, 87));
        tblVentas.setModel(new javax.swing.table.DefaultTableModel(
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
        tblVentas.setFocusable(false);
        tblVentas.setGridColor(new java.awt.Color(247, 248, 252));
        tblVentas.setOpaque(false);
        tblVentas.setRowHeight(40);
        tblVentas.setSelectionBackground(new java.awt.Color(247, 248, 252));
        tblVentas.setSelectionForeground(new java.awt.Color(32, 40, 87));
        tblVentas.setShowVerticalLines(false);
        tblVentas.getTableHeader().setReorderingAllowed(false);
        tblVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblVentasMousePressed(evt);
            }
        });
        jspMarcas.setViewportView(tblVentas);

        add(jspMarcas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 1030, 450));
    }// </editor-fold>//GEN-END:initComponents

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        //String busqueda = txtBusqueda.getText();
        //cargarTable(busqueda);
        //tblVentas.setModel(tableModel);
    }//GEN-LAST:event_txtBusquedaKeyReleased

    private void tblVentasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVentasMousePressed
        if (evt.getClickCount() == 2){
            int id_venta = Integer.parseInt(tblVentas.getValueAt(tblVentas.getSelectedRow(), 0).toString());
            DetalleVenta detalleVenta = new DetalleVenta(null, true);
            detalleVenta.id_venta = id_venta;
            detalleVenta.cargarTable(id_venta);
            detalleVenta.setVisible(true);
        }
    }//GEN-LAST:event_tblVentasMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jspMarcas;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JLabel lblTituloMarcas;
    private javax.swing.JTable tblVentas;
    private Custom.TextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
