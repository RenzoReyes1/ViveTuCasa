package Presentacion;

import DB.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class DetalleVenta extends java.awt.Dialog {

    DefaultTableModel tableModel = new DefaultTableModel();   

    private Connection cnn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public static int id_venta = 0;

    public DetalleVenta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.setLocationRelativeTo(null);

        configurarTabla();
        cargarTable(id_venta);
    }

    private void configurarTabla() {
        tblDetalleVentas.setModel(tableModel);
        tableModel.addColumn("ID");
        tableModel.addColumn("CANTIDAD");
        tableModel.addColumn("DESCRIPCIÓN");
        tableModel.addColumn("PRECIO");
        tableModel.addColumn("IMPORTE");
    }

    private void cargarTable(int id_venta) {
        String query = "SELECT detalle_ventas.id_detalle_venta, detalle_ventas.cantidad, productos.nombre_producto, "
                     + "detalle_ventas.precio, detalle_ventas.importe "
                     + "FROM detalle_ventas "
                     + "JOIN ventas ON ventas.id_venta = detalle_ventas.id_venta "
                     + "JOIN productos ON productos.id_producto = detalle_ventas.id_producto "
                     + "WHERE detalle_ventas.id_venta = ?";

        try {
            cnn = Conexion.MySQL();
            ps = cnn.prepareStatement(query);
            ps.setInt(1, id_venta);
            rs = ps.executeQuery();

            tableModel.setRowCount(0); // Limpiar la tabla antes de llenarla

            while (rs.next()) {
                Object[] datosFila = {
                    rs.getInt("id_detalle_venta"),
                    rs.getInt("cantidad"),
                    rs.getString("nombre_producto"),
                    rs.getDouble("precio"),
                    rs.getDouble("importe")
                };
                tableModel.addRow(datosFila);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar detalles de la venta: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Cerrar recursos para evitar fugas de memoria
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (cnn != null) cnn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void closeDialog(java.awt.event.WindowEvent evt) {
        setVisible(false);
        dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            DetalleVenta dialog = new DetalleVenta(new java.awt.Frame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDetalleVentas;
    // End of variables declaration
}
