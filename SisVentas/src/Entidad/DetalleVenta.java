package Entidad;

public class DetalleVenta {
    private int id_detalle_venta;
    private int id_venta;
    private int id_producto;
    private double precio;
    private int cantidad;
    private double importe;

    public DetalleVenta() {
    }

    public DetalleVenta(int id_detalle_venta, int id_venta, int id_producto, double precio, int cantidad, double importe) {
        this.id_detalle_venta = id_detalle_venta;
        this.id_venta = id_venta;
        this.id_producto = id_producto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.importe = importe;
    }

    public int getId_detalle_venta() {
        return id_detalle_venta;
    }

    public void setId_detalle_venta(int id_detalle_venta) {
        this.id_detalle_venta = id_detalle_venta;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
    
    
}
