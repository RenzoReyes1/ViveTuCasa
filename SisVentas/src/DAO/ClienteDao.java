package DAO;

import Entidad.Cliente;
import java.util.List;

public interface ClienteDao {
    public List<Cliente> listar(String busqueda);
    public abstract boolean insertar (Cliente cliente);
    public abstract boolean editar (Cliente cliente);
    public abstract boolean eliminar (int estado, int id_cliente);
}
