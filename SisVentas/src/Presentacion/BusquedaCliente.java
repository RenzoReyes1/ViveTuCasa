package Presentacion;

import DAO.ClienteDao;
import DAO.ClienteDaoImpl;
import Entidad.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class BusquedaCliente extends java.awt.Dialog {

    Cliente cliente;
    ClienteDao clienteDao = new ClienteDaoImpl();
    DefaultTableModel tableModel = new DefaultTableModel();
    
    public BusquedaCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        refrescar();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        txtBusqueda = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblClientesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 610, 260));
        jPanel1.add(txtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 310, -1));

        btnEnviar.setText("jButton1");
        jPanel1.add(btnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public final void refrescar(){
        cargarTable("");
        tblClientes.setModel(tableModel);
    }
    
    private DefaultTableModel cargarTable(String busqueda){
        List<Cliente> lista = new ArrayList<>();
        lista.addAll(clienteDao.listar(busqueda));
        String[] cabeceras = {"ID", "NOMBRES", "DNI/CE", "NRO DOCUMENTO"};
        tableModel = new DefaultTableModel(null, cabeceras);

        String[] registro = new String[7];
        
        for (Cliente item : lista){
            registro[0] = Integer.toString(item.getId_cliente());
            registro[1] = item.getNombres_apellidos();
            registro[2] = item.getTipo_documento();
            registro[3] = item.getNro_documento();
            tableModel.addRow(registro);
        }
        
        return tableModel;
    }
    
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void tblClientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMousePressed
        if (evt.getClickCount() == 2){
            String id_cliente = tblClientes.getValueAt(tblClientes.getSelectedRow(), 0).toString();
            String nombres = tblClientes.getValueAt(tblClientes.getSelectedRow(), 1).toString();
            String nro_documento = tblClientes.getValueAt(tblClientes.getSelectedRow(), 3).toString();
            NuevaVenta.txtIdCliente.setText(id_cliente);
            NuevaVenta.txtCliente.setText(nombres);
            NuevaVenta.txtNroDocumento.setText(nro_documento);
            this.dispose();
        }
    }//GEN-LAST:event_tblClientesMousePressed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BusquedaCliente dialog = new BusquedaCliente(new java.awt.Frame(), true);
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
    private javax.swing.JButton btnEnviar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
