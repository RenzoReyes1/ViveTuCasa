package DAO;

import Entidad.Marca;
import java.util.List;

public interface MarcaDao {
    public List<Marca> listar(String busqueda);
    public abstract boolean insertar (Marca marca);
    public abstract boolean editar (Marca marca);
    public abstract boolean eliminar (int estado, int id_marca);
}
