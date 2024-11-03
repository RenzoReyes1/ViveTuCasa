package Entidad;

public class DetalleCompra {
    private int id_detalle_compra;
    private int id_compra;
    private int id_producto;
    private double precio;
    private int cantidad;
    private double importe;  

    public DetalleCompra() {
    }

    public DetalleCompra(int id_detalle_compra, int id_compra, int id_producto, double precio, int cantidad, double importe) {
        this.id_detalle_compra = id_detalle_compra;
        this.id_compra = id_compra;
        this.id_producto = id_producto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.importe = importe;
    }

    public int getId_detalle_compra() {
        return id_detalle_compra;
    }

    public void setId_detalle_compra(int id_detalle_compra) {
        this.id_detalle_compra = id_detalle_compra;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
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
