package Presentacion;

import DAO.RolDao;
import DAO.RolDaoImpl;
import Entidad.Rol;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Roles extends javax.swing.JPanel {

    Rol rol;
    RolDao rolDao = new RolDaoImpl();
    DefaultTableModel tableModel = new DefaultTableModel();
    
    public Roles() {
        initComponents();
        personalizarTable();
        refrescar();
    }
    
    private DefaultTableModel cargarTable(){
        List<Rol> lista = new ArrayList<>();
        lista.addAll(rolDao.listar());
        String[] cabeceras = {"ID", "ROL"};
        tableModel = new DefaultTableModel(null, cabeceras);

        String[] registro = new String[2];
        
        for (Rol item : lista){
            registro[0] = Integer.toString(item.getId_rol());
            registro[1] = item.getRol();
            tableModel.addRow(registro);
        }
        
        return tableModel;
    }
    
    private void refrescar(){
        cargarTable();
        tblRoles.setModel(tableModel);
        tblRoles.removeColumn(tblRoles.getColumnModel().getColumn(0));
    }
    
    private void personalizarTable(){
        tblRoles.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 14));
        tblRoles.getTableHeader().setBackground(Color.WHITE);
        tblRoles.getTableHeader().setForeground(new Color(188, 198, 209));
        tblRoles.getTableHeader().setOpaque(false); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jspMarcas = new javax.swing.JScrollPane();
        tblRoles = new javax.swing.JTable();
        lblTituloMarcas = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jspMarcas.setBackground(new java.awt.Color(255, 255, 255));
        jspMarcas.setBorder(null);

        tblRoles.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tblRoles.setForeground(new java.awt.Color(32, 40, 87));
        tblRoles.setModel(new javax.swing.table.DefaultTableModel(
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
        tblRoles.setFocusable(false);
        tblRoles.setGridColor(new java.awt.Color(247, 248, 252));
        tblRoles.setOpaque(false);
        tblRoles.setRowHeight(40);
        tblRoles.setSelectionBackground(new java.awt.Color(247, 248, 252));
        tblRoles.setSelectionForeground(new java.awt.Color(32, 40, 87));
        tblRoles.setShowVerticalLines(false);
        tblRoles.getTableHeader().setReorderingAllowed(false);
        jspMarcas.setViewportView(tblRoles);

        jPanel1.add(jspMarcas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 1030, 340));

        lblTituloMarcas.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        lblTituloMarcas.setForeground(new java.awt.Color(13, 22, 81));
        lblTituloMarcas.setText("Administrar Roles");
        jPanel1.add(lblTituloMarcas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jspMarcas;
    private javax.swing.JLabel lblTituloMarcas;
    private javax.swing.JTable tblRoles;
    // End of variables declaration//GEN-END:variables
}
