package DAO;

import Entidad.DetalleVenta;
import java.util.List;

public interface DetalleVentaDao {
    public List<DetalleVenta> listar();
    public abstract boolean insertar (DetalleVenta detalleVenta);
}