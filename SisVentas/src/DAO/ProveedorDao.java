package DAO;

import Entidad.Proveedor;
import java.util.List;

public interface ProveedorDao {
    public List<Proveedor> listar(String busqueda);
    public abstract boolean insertar (Proveedor proveedor);
    public abstract boolean editar (Proveedor proveedor);
    public abstract boolean eliminar (int estado, int id_proveedor);
}
