package DAO;

import Entidad.Categoria;
import java.util.List;

public interface CategoriaDao {
    public List<Categoria> listar(String busqueda);
    public abstract boolean insertar (Categoria categoria);
    public abstract boolean editar (Categoria categoria);
    public abstract boolean eliminar (int estado, int id_categoria);
}
