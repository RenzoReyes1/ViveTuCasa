package DAO;

import Entidad.Compra;
import java.util.List;

public interface CompraDao {
    public List<Compra> listar();
    public abstract boolean insertar (Compra compra);
    public abstract boolean editar (Compra compra);
    public abstract boolean eliminar (Compra compra);
    public abstract String getMaxIdCompra();
    public abstract int generarComprobanteBoleta();
}
