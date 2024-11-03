package Presentacion;

import DAO.MarcaDao;
import DAO.MarcaDaoImpl;
import Entidad.Marca;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class NuevaMarca extends java.awt.Dialog {

    Marca marca;
    MarcaDao marcaDao = new MarcaDaoImpl();
    
    int id_marca;
    
    int x = 0; //0 INSERTAR - 1 EDITAR
    
    public NuevaMarca(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
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

        lblTitulo.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lblTitulo.setText("Nueva marca");
        lblTitulo.setToolTipText("");

        txtNombreMarca.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtNombreMarca.setLabelText("Nombre de la marca");

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
                .addComponent(lblRegistrarEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnRgistrarLayout.setVerticalGroup(
            btnRgistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnRgistrarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRegistrarEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(btnRgistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNombreMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(25, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(btnRgistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblTitulo)
                    .addGap(29, 29, 29)
                    .addComponent(txtNombreMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(130, Short.MAX_VALUE)))
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

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void btnRgistrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRgistrarMousePressed
        String nombre_marca = txtNombreMarca.getText();

        if (x == 0){
            marca = new Marca(0, nombre_marca, 0);
            if(marcaDao.insertar(marca)){
                JOptionPane.showMessageDialog(null, "Registro exitoso");
                this.dispose();
            }
            else JOptionPane.showMessageDialog(null, "Error");
        }
        else if (x == 1){
            marca = new Marca(id_marca, nombre_marca, 0);

            if(marcaDao.editar(marca)){
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
                NuevaMarca dialog = new NuevaMarca(new java.awt.Frame(), true);
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
    private javax.swing.JPanel jPanel1;
    public final javax.swing.JLabel lblRegistrarEditar = new javax.swing.JLabel();
    public final javax.swing.JLabel lblTitulo = new javax.swing.JLabel();
    public final Custom.TextField txtNombreMarca = new Custom.TextField();
    // End of variables declaration//GEN-END:variables
}
