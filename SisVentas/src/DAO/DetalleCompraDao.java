package DAO;

import Entidad.DetalleCompra;
import java.util.List;

public interface DetalleCompraDao {
    public List<DetalleCompra> listar();
    public abstract boolean insertar (DetalleCompra detalleCompra);
}
