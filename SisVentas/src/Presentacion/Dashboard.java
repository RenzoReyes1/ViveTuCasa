package Presentacion;

import DAO.VentaDao;
import DAO.VentaDaoImpl;
import DB.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Dashboard extends javax.swing.JPanel {

    java.util.Calendar calendario;
    int hora, minutos, segundos;
    
    VentaDao ventaDao = new VentaDaoImpl();
    
    private ResultSet rs;
    private PreparedStatement ps;
    private Connection cnn;
    
    public Dashboard() {
        initComponents();
        fecha();
        hora();
        totalClientes();
        totalProductos();
        totalProveedores();
        ventasDia();
        gananciasDia();
        gananciasMes();
        comprasDia();
        egresosMes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gradientPanel1 = new Custom.GradientPanel();
        iconClientes = new javax.swing.JLabel();
        lblTotalProductos = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        gradientPanel2 = new Custom.GradientPanel();
        lblGananciasMes = new javax.swing.JLabel();
        iconClientes2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        gradientPanel3 = new Custom.GradientPanel();
        lblVentasDia = new javax.swing.JLabel();
        iconClientes3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        gradientPanel4 = new Custom.GradientPanel();
        jLabel4 = new javax.swing.JLabel();
        lblTotalClientes = new javax.swing.JLabel();
        iconClientes1 = new javax.swing.JLabel();
        pnlReloj = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        gradientPanel5 = new Custom.GradientPanel();
        lblGananciasDia = new javax.swing.JLabel();
        iconClientes4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        gradientPanel6 = new Custom.GradientPanel();
        lblTotalProveedores = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        iconClientes6 = new javax.swing.JLabel();
        gradientPanel7 = new Custom.GradientPanel();
        lblComprasDia = new javax.swing.JLabel();
        iconClientes5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        gradientPanel8 = new Custom.GradientPanel();
        jLabel6 = new javax.swing.JLabel();
        lblEgresosMes = new javax.swing.JLabel();
        iconClientes7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1100, 746));
        setMinimumSize(new java.awt.Dimension(1100, 746));
        setName(""); // NOI18N
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gradientPanel1.setkEndColor(new java.awt.Color(255, 130, 157));
        gradientPanel1.setkStartColor(new java.awt.Color(247, 91, 112));
        gradientPanel1.setMaximumSize(new java.awt.Dimension(220, 150));
        gradientPanel1.setPreferredSize(new java.awt.Dimension(220, 120));

        iconClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/total_productos.png"))); // NOI18N

        lblTotalProductos.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        lblTotalProductos.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalProductos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalProductos.setText("208");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Total productos");

        javax.swing.GroupLayout gradientPanel1Layout = new javax.swing.GroupLayout(gradientPanel1);
        gradientPanel1.setLayout(gradientPanel1Layout);
        gradientPanel1Layout.setHorizontalGroup(
            gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTotalProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iconClientes)
                .addGap(31, 31, 31))
            .addGroup(gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(gradientPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(70, Short.MAX_VALUE)))
        );
        gradientPanel1Layout.setVerticalGroup(
            gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(iconClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotalProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradientPanel1Layout.createSequentialGroup()
                    .addContainerGap(85, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addGap(12, 12, 12)))
        );

        add(gradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 70, 240, -1));

        gradientPanel2.setkEndColor(new java.awt.Color(76, 230, 194));
        gradientPanel2.setkStartColor(new java.awt.Color(44, 216, 176));
        gradientPanel2.setMaximumSize(new java.awt.Dimension(220, 150));
        gradientPanel2.setPreferredSize(new java.awt.Dimension(240, 120));

        lblGananciasMes.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        lblGananciasMes.setForeground(new java.awt.Color(255, 255, 255));
        lblGananciasMes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGananciasMes.setText("S/1450");

        iconClientes2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/ganancias_dia.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Ganancias del mes");

        javax.swing.GroupLayout gradientPanel2Layout = new javax.swing.GroupLayout(gradientPanel2);
        gradientPanel2.setLayout(gradientPanel2Layout);
        gradientPanel2Layout.setHorizontalGroup(
            gradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gradientPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap(58, Short.MAX_VALUE))
                    .addGroup(gradientPanel2Layout.createSequentialGroup()
                        .addComponent(lblGananciasMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iconClientes2)
                        .addGap(22, 22, 22))))
        );
        gradientPanel2Layout.setVerticalGroup(
            gradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradientPanel2Layout.createSequentialGroup()
                .addGroup(gradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gradientPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(iconClientes2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gradientPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblGananciasMes, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(gradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 240, -1));

        gradientPanel3.setkEndColor(new java.awt.Color(117, 177, 249));
        gradientPanel3.setkStartColor(new java.awt.Color(59, 156, 255));
        gradientPanel3.setMaximumSize(new java.awt.Dimension(220, 150));
        gradientPanel3.setPreferredSize(new java.awt.Dimension(240, 120));

        lblVentasDia.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        lblVentasDia.setForeground(new java.awt.Color(255, 255, 255));
        lblVentasDia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVentasDia.setText("17");

        iconClientes3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/ventas_dia.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Ventas del día");

        javax.swing.GroupLayout gradientPanel3Layout = new javax.swing.GroupLayout(gradientPanel3);
        gradientPanel3.setLayout(gradientPanel3Layout);
        gradientPanel3Layout.setHorizontalGroup(
            gradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gradientPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(gradientPanel3Layout.createSequentialGroup()
                        .addComponent(lblVentasDia, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iconClientes3)
                        .addGap(34, 34, 34))))
        );
        gradientPanel3Layout.setVerticalGroup(
            gradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradientPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gradientPanel3Layout.createSequentialGroup()
                        .addGap(0, 14, Short.MAX_VALUE)
                        .addComponent(iconClientes3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblVentasDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap())
        );

        add(gradientPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 240, -1));

        gradientPanel4.setkEndColor(new java.awt.Color(254, 201, 123));
        gradientPanel4.setkStartColor(new java.awt.Color(244, 186, 78));
        gradientPanel4.setMaximumSize(new java.awt.Dimension(220, 120));
        gradientPanel4.setPreferredSize(new java.awt.Dimension(240, 120));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Total clientes");

        lblTotalClientes.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        lblTotalClientes.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalClientes.setText("146");

        iconClientes1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/total_clientes.png"))); // NOI18N

        javax.swing.GroupLayout gradientPanel4Layout = new javax.swing.GroupLayout(gradientPanel4);
        gradientPanel4.setLayout(gradientPanel4Layout);
        gradientPanel4Layout.setHorizontalGroup(
            gradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gradientPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(gradientPanel4Layout.createSequentialGroup()
                        .addComponent(lblTotalClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iconClientes1)
                        .addGap(34, 34, 34))))
        );
        gradientPanel4Layout.setVerticalGroup(
            gradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradientPanel4Layout.createSequentialGroup()
                .addGroup(gradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(gradientPanel4Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(iconClientes1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gradientPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTotalClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        add(gradientPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, 240, -1));

        pnlReloj.setBackground(new java.awt.Color(255, 255, 255));
        pnlReloj.setForeground(new java.awt.Color(45, 50, 90));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/calendario-reloj.png"))); // NOI18N

        lblHora.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblHora.setForeground(new java.awt.Color(32, 40, 87));
        lblHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHora.setText("05:42:36");

        lblFecha.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(32, 40, 87));
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFecha.setText("VIERNES 01 DICIEMBRE 2023");

        javax.swing.GroupLayout pnlRelojLayout = new javax.swing.GroupLayout(pnlReloj);
        pnlReloj.setLayout(pnlRelojLayout);
        pnlRelojLayout.setHorizontalGroup(
            pnlRelojLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRelojLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRelojLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHora, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlRelojLayout.setVerticalGroup(
            pnlRelojLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRelojLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(pnlReloj, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 460, 250, 180));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel12.setText("Dashboard");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        gradientPanel5.setkEndColor(new java.awt.Color(76, 230, 194));
        gradientPanel5.setkStartColor(new java.awt.Color(44, 216, 176));
        gradientPanel5.setMaximumSize(new java.awt.Dimension(220, 150));
        gradientPanel5.setPreferredSize(new java.awt.Dimension(240, 120));

        lblGananciasDia.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        lblGananciasDia.setForeground(new java.awt.Color(255, 255, 255));
        lblGananciasDia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGananciasDia.setText("S/1450");

        iconClientes4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/ganancias_dia.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Ganancias del día");

        javax.swing.GroupLayout gradientPanel5Layout = new javax.swing.GroupLayout(gradientPanel5);
        gradientPanel5.setLayout(gradientPanel5Layout);
        gradientPanel5Layout.setHorizontalGroup(
            gradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gradientPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addContainerGap(67, Short.MAX_VALUE))
                    .addGroup(gradientPanel5Layout.createSequentialGroup()
                        .addComponent(lblGananciasDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iconClientes4)
                        .addGap(22, 22, 22))))
        );
        gradientPanel5Layout.setVerticalGroup(
            gradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradientPanel5Layout.createSequentialGroup()
                .addGroup(gradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gradientPanel5Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(iconClientes4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gradientPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblGananciasDia, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap())
        );

        add(gradientPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 240, -1));

        gradientPanel6.setkEndColor(new java.awt.Color(255, 130, 157));
        gradientPanel6.setkStartColor(new java.awt.Color(247, 91, 112));
        gradientPanel6.setMaximumSize(new java.awt.Dimension(220, 150));
        gradientPanel6.setPreferredSize(new java.awt.Dimension(220, 120));

        lblTotalProveedores.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        lblTotalProveedores.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalProveedores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalProveedores.setText("208");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Total proveedores");

        iconClientes6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/total_clientes.png"))); // NOI18N

        javax.swing.GroupLayout gradientPanel6Layout = new javax.swing.GroupLayout(gradientPanel6);
        gradientPanel6.setLayout(gradientPanel6Layout);
        gradientPanel6Layout.setHorizontalGroup(
            gradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradientPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTotalProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(iconClientes6)
                .addGap(27, 27, 27))
            .addGroup(gradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(gradientPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(70, Short.MAX_VALUE)))
        );
        gradientPanel6Layout.setVerticalGroup(
            gradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(iconClientes6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotalProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(gradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradientPanel6Layout.createSequentialGroup()
                    .addContainerGap(85, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addGap(12, 12, 12)))
        );

        add(gradientPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 240, -1));

        gradientPanel7.setkEndColor(new java.awt.Color(117, 177, 249));
        gradientPanel7.setkStartColor(new java.awt.Color(59, 156, 255));
        gradientPanel7.setMaximumSize(new java.awt.Dimension(220, 150));
        gradientPanel7.setPreferredSize(new java.awt.Dimension(240, 120));

        lblComprasDia.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        lblComprasDia.setForeground(new java.awt.Color(255, 255, 255));
        lblComprasDia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblComprasDia.setText("17");

        iconClientes5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/ventas_dia.png"))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Compras del día");

        javax.swing.GroupLayout gradientPanel7Layout = new javax.swing.GroupLayout(gradientPanel7);
        gradientPanel7.setLayout(gradientPanel7Layout);
        gradientPanel7Layout.setHorizontalGroup(
            gradientPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gradientPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gradientPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(gradientPanel7Layout.createSequentialGroup()
                        .addComponent(lblComprasDia, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iconClientes5)
                        .addGap(34, 34, 34))))
        );
        gradientPanel7Layout.setVerticalGroup(
            gradientPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradientPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gradientPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gradientPanel7Layout.createSequentialGroup()
                        .addGap(0, 14, Short.MAX_VALUE)
                        .addComponent(iconClientes5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblComprasDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addContainerGap())
        );

        add(gradientPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 210, 240, -1));

        gradientPanel8.setkEndColor(new java.awt.Color(254, 201, 123));
        gradientPanel8.setkStartColor(new java.awt.Color(244, 186, 78));
        gradientPanel8.setMaximumSize(new java.awt.Dimension(220, 120));
        gradientPanel8.setPreferredSize(new java.awt.Dimension(240, 120));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Egresos del mes");

        lblEgresosMes.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        lblEgresosMes.setForeground(new java.awt.Color(255, 255, 255));
        lblEgresosMes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEgresosMes.setText("146");

        iconClientes7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/total_clientes.png"))); // NOI18N

        javax.swing.GroupLayout gradientPanel8Layout = new javax.swing.GroupLayout(gradientPanel8);
        gradientPanel8.setLayout(gradientPanel8Layout);
        gradientPanel8Layout.setHorizontalGroup(
            gradientPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gradientPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gradientPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(70, Short.MAX_VALUE))
                    .addGroup(gradientPanel8Layout.createSequentialGroup()
                        .addComponent(lblEgresosMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iconClientes7)
                        .addGap(34, 34, 34))))
        );
        gradientPanel8Layout.setVerticalGroup(
            gradientPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradientPanel8Layout.createSequentialGroup()
                .addGroup(gradientPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(gradientPanel8Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(iconClientes7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gradientPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblEgresosMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        add(gradientPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 210, 240, -1));
    }// </editor-fold>//GEN-END:initComponents

    public void totalClientes()
    {
        try
        {
            cnn = Conexion.MySQL();
            ps = cnn.prepareStatement("SELECT COUNT(*) AS total_clientes FROM clientes WHERE estado =0");
            rs = ps.executeQuery();
            
            
            while (rs.next())
            {
                lblTotalClientes.setText(rs.getString(1));
            }
        }
        
        catch (Exception ex) {}
    }
    
    public void totalProductos()
    {
        try
        {
            cnn = Conexion.MySQL();
            ps = cnn.prepareStatement("SELECT COUNT(*) AS total_productos FROM productos WHERE estado =0");
            rs = ps.executeQuery();
            
            
            while (rs.next())
            {
                lblTotalProductos.setText(rs.getString(1));
            }
        }
        
        catch (Exception ex) {}
    }
    
    public void totalProveedores()
    {
        try
        {
            cnn = Conexion.MySQL();
            ps = cnn.prepareStatement("SELECT COUNT(*) AS total_proveedores FROM proveedores WHERE estado =0");
            rs = ps.executeQuery();
            
            
            while (rs.next())
            {
                lblTotalProveedores.setText(rs.getString(1));
            }
        }
        
        catch (Exception ex) {}
    }
    
    public void ventasDia()
    {
        try
        {
            cnn = Conexion.MySQL();
            ps = cnn.prepareStatement("SELECT count(*) ventas_dia FROM ventas WHERE DATE(fecha) = CURDATE()");
            rs = ps.executeQuery();
            
            
            while (rs.next())
            {
                lblVentasDia.setText(rs.getString(1));
            }
        }
        
        catch (Exception ex) {}
    }
    
    public void comprasDia()
    {
        try
        {
            cnn = Conexion.MySQL();
            ps = cnn.prepareStatement("SELECT count(*) compras_dia FROM compras WHERE DATE(fecha) = CURDATE()");
            rs = ps.executeQuery();
            
            
            while (rs.next())
            {
                lblComprasDia.setText(rs.getString(1));
            }
        }
        
        catch (Exception ex) {}
    }
    
    public void gananciasMes()
    {
        try
        {
            cnn = Conexion.MySQL();
            ps = cnn.prepareStatement("SELECT SUM(total) AS total_ventas FROM ventas WHERE YEAR(fecha) = YEAR(CURDATE()) AND MONTH(fecha) = MONTH(CURDATE())");
            rs = ps.executeQuery();
            
            
            while (rs.next())
            {
                lblGananciasMes.setText(rs.getString(1));
            }
        }
        
        catch (Exception ex) {}
    }
    
    public void egresosMes()
    {
        try
        {
            cnn = Conexion.MySQL();
            ps = cnn.prepareStatement("SELECT SUM(total) AS total_compras FROM compras WHERE YEAR(fecha) = YEAR(CURDATE()) AND MONTH(fecha) = MONTH(CURDATE())");
            rs = ps.executeQuery();
            
            
            while (rs.next())
            {
                lblEgresosMes.setText(rs.getString(1));
            }
        }
        
        catch (Exception ex) {}
    }
    
    public void gananciasDia()
    {
        try
        {
            cnn = Conexion.MySQL();
            ps = cnn.prepareStatement("SELECT SUM(total) AS total_ventas FROM ventas WHERE DATE(fecha) = CURDATE()");
            rs = ps.executeQuery();
            
            
            while (rs.next())
            {
                lblGananciasDia.setText(rs.getString(1));
            }
        }
        
        catch (Exception ex) {}
    }
    
    public void hora() {
        calendario = new java.util.GregorianCalendar();
        segundos = calendario.get(Calendar.SECOND);
        
        javax.swing.Timer timer = new javax.swing.Timer(100, new java.awt.event.ActionListener() 
        {
            @ Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
            java.util.Date actual = new java.util.Date();
            calendario.setTime(actual);
            
            hora = calendario.get(Calendar.HOUR_OF_DAY);
            minutos = calendario.get(Calendar.MINUTE);
            segundos = calendario.get(Calendar.SECOND);
            
            String hour = String.format("%02d : %02d : %02d", hora, minutos, segundos);
            lblHora.setText(hour);
            }
        });
        
    timer.start();    
    }
    
    public void fecha(){
        Date date = new Date(); 
        String strDateFormat = "EEEE dd MMMM yyyy"; // FORMATO DE FECHA ESPECIFICADO 
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat); // LA CADENA DE FORMATO DE FECHA SE PASA COMO ARGUMENTO AL OBJETO 
        lblFecha.setText(sdf.format(date).toUpperCase()); // EL FORMATO DE FECHA SE APLICA A LA FECHA ACTUAL
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Custom.GradientPanel gradientPanel1;
    private Custom.GradientPanel gradientPanel2;
    private Custom.GradientPanel gradientPanel3;
    private Custom.GradientPanel gradientPanel4;
    private Custom.GradientPanel gradientPanel5;
    private Custom.GradientPanel gradientPanel6;
    private Custom.GradientPanel gradientPanel7;
    private Custom.GradientPanel gradientPanel8;
    private javax.swing.JLabel iconClientes;
    private javax.swing.JLabel iconClientes1;
    private javax.swing.JLabel iconClientes2;
    private javax.swing.JLabel iconClientes3;
    private javax.swing.JLabel iconClientes4;
    private javax.swing.JLabel iconClientes5;
    private javax.swing.JLabel iconClientes6;
    private javax.swing.JLabel iconClientes7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblComprasDia;
    private javax.swing.JLabel lblEgresosMes;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblGananciasDia;
    private javax.swing.JLabel lblGananciasMes;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblTotalClientes;
    private javax.swing.JLabel lblTotalProductos;
    private javax.swing.JLabel lblTotalProveedores;
    private javax.swing.JLabel lblVentasDia;
    private javax.swing.JPanel pnlReloj;
    // End of variables declaration//GEN-END:variables
}
