package entidad;

public class DetalleVenta {
    private int detalleVentaId;
    private int ventaId;
    private int productoId;
    private double precioUnitario;
    private int cantidadProducto;
    private double totalImporte;

    public DetalleVenta() {}

    public DetalleVenta(int detalleVentaId, int ventaId, int productoId, double precioUnitario, int cantidadProducto, double totalImporte) {
        this.detalleVentaId = detalleVentaId;
        this.ventaId = ventaId;
        this.productoId = productoId;
        this.precioUnitario = precioUnitario;
        this.cantidadProducto = cantidadProducto;
        this.totalImporte = totalImporte;
    }

    public int getDetalleVentaId() {
        return detalleVentaId;
    }

    public void setDetalleVentaId(int detalleVentaId) {
        this.detalleVentaId = detalleVentaId;
    }

    public int getVentaId() {
        return ventaId;
    }

    public void setVentaId(int ventaId) {
        this.ventaId = ventaId;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public double getTotalImporte() {
        return totalImporte;
    }

    public void setTotalImporte(double totalImporte) {
        this.totalImporte = totalImporte;
    }
}

