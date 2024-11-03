package DAO;

import Entidad.Producto;
import java.util.List;

    public interface ProductoDao {
        public List<Producto> listar(String busqueda);
        public abstract boolean insertar (Producto producto);
        public abstract boolean editar (Producto producto);
        public abstract boolean eliminar (int estado, int id_producto);
        public abstract boolean disminuirStock (int id_producto, int cantidad);
        public abstract boolean aumentarStock (int id_producto, int cantidad);
}
