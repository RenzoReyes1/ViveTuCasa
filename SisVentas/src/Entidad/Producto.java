package Entidad;

import java.sql.Date;

public class Producto {
    private int id_producto;
    private String nombre_producto;
    private String id_marca;
    private String id_categoria;
    private double precio_compra;
    private double precio_venta;
    private int stock;
    private Date fecha_ingreso;
    private int estado;

    public Producto() {
    }

    public Producto(int id_producto, String nombre_producto, String id_marca, String id_categoria, double precio_compra, double precio_venta, int stock, Date fecha_ingreso, int estado) {
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.id_marca = id_marca;
        this.id_categoria = id_categoria;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.stock = stock;
        this.fecha_ingreso = fecha_ingreso;
        this.estado = estado;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getId_marca() {
        return id_marca;
    }

    public void setId_marca(String id_marca) {
        this.id_marca = id_marca;
    }

    public String getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(String id_categoria) {
        this.id_categoria = id_categoria;
    }

    public double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
