package DAO;

import Entidad.Usuario;
import java.util.List;

public interface UsuarioDao {
    public List<Usuario> listar(String busqueda);
    public abstract boolean login(String username, String password);
    public abstract boolean insertar (Usuario usuario);
    public abstract boolean editar (Usuario usuario);
    public abstract boolean eliminar (int estado, int id_usuario);
}
