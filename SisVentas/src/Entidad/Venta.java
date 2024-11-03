
package Entidad;

import java.sql.Date;

public class Venta {
    private int id_venta;
    private int id_usuario;
    private int id_cliente;
    private String tipo_comprobante;
    private String nro_comprobante;
    private Date fecha;
    private String hora;
    private double total; 
    private int estado;

    public Venta() {
    }

    public Venta(int id_venta, int id_usuario, int id_cliente, String tipo_comprobante, String nro_comprobante, Date fecha, String hora, double total, int estado) {
        this.id_venta = id_venta;
        this.id_usuario = id_usuario;
        this.id_cliente = id_cliente;
        this.tipo_comprobante = tipo_comprobante;
        this.nro_comprobante = nro_comprobante;
        this.fecha = fecha;
        this.hora = hora;
        this.total = total;
        this.estado = estado;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getTipo_comprobante() {
        return tipo_comprobante;
    }

    public void setTipo_comprobante(String tipo_comprobante) {
        this.tipo_comprobante = tipo_comprobante;
    }

    public String getNro_comprobante() {
        return nro_comprobante;
    }

    public void setNro_comprobante(String nro_comprobante) {
        this.nro_comprobante = nro_comprobante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
