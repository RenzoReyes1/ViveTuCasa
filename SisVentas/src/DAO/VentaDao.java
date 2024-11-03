package DAO;

import Entidad.Venta;
import java.util.List;

public interface VentaDao {
    public List<Venta> listar();
    public abstract boolean insertar (Venta venta);
    public abstract boolean editar (Venta venta);
    public abstract boolean eliminar (Venta venta);
    public abstract String getMaxIdVenta();
    public abstract int generarComprobanteBoleta();
}
