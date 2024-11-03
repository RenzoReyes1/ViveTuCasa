package Presentacion;

import DB.Conexion;
import static Presentacion.DetalleVenta.id_venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class BusquedaProveedor extends java.awt.Dialog {

    DefaultTableModel tableModel = new DefaultTableModel();   
    
    private ResultSet rs;
    private PreparedStatement ps;
    private Connection cnn;
    
    public BusquedaProveedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        tblProveedor.setModel(tableModel);
        tableModel.addColumn("ID");
        tableModel.addColumn("RAZÓN SOCIAL");
        tableModel.addColumn("RUC");
        
        cargarTable();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProveedor = new javax.swing.JTable();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblProveedor.setModel(new javax.swing.table.DefaultTableModel(
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
        tblProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblProveedorMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblProveedor);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 983, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void cargarTable(){
        try
        {
            cnn = Conexion.MySQL();
            ps = cnn.prepareStatement("SELECT * FROM proveedores WHERE razon_social LIKE '%%' AND estado=0 ORDER BY id_proveedor DESC");
            rs = ps.executeQuery();
            
            tableModel.setRowCount(0);
            
            while (rs.next())
            {
                Object Datos[] =
                {
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3)
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

    private void tblProveedorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProveedorMousePressed
        if (evt.getClickCount() == 2){
            String id_proveedor = tblProveedor.getValueAt(tblProveedor.getSelectedRow(), 0).toString();
            String razon_social = tblProveedor.getValueAt(tblProveedor.getSelectedRow(), 1).toString();
            String ruc = tblProveedor.getValueAt(tblProveedor.getSelectedRow(), 2).toString();
            NuevaCompra.txtIdProveedor.setText(id_proveedor);
            NuevaCompra.txtRazonSocial.setText(razon_social);
            NuevaCompra.txtNroDocumento.setText(ruc);
            this.dispose();
        }
    }//GEN-LAST:event_tblProveedorMousePressed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BusquedaProveedor dialog = new BusquedaProveedor(new java.awt.Frame(), true);
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
    private javax.swing.JTable tblProveedor;
    // End of variables declaration//GEN-END:variables
}
