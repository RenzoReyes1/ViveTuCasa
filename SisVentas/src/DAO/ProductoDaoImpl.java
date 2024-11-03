package DAO;

import DB.Conexion;
import Entidad.Producto;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDaoImpl implements ProductoDao{

    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public List<Producto> listar(String busqueda) {
        List<Producto> productos = new ArrayList<>();
        
        try {
            String query = "SELECT productos.id_producto, productos.nombre_producto, categorias.nombre_categoria, marcas.nombre_marca, productos.precio_compra, productos.precio_venta, productos.stock, productos.fecha_ingreso FROM productos "
                    + "                                     JOIN categorias ON categorias.id_categoria = productos.id_categoria "
                    + "                                     JOIN marcas ON marcas.id_marca = productos.id_marca"
                    + "                                     WHERE productos.nombre_producto LIKE '%" + busqueda + "%' AND productos.estado=0 ORDER BY id_producto DESC";
            ps = Conexion.MySQL().prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                int id_producto = rs.getInt(1);
                String nombre_producto = rs.getString(2);
                String id_categoria = rs.getString(3);
                String id_marca = rs.getString(4);
                double precio_compra = rs.getDouble(5);
                double precio_venta = rs.getDouble(6);
                int stock = rs.getInt(7);
                Date fecha_ingreso = rs.getDate(8);
                
                productos.add(new Producto(id_producto, nombre_producto, id_marca, id_categoria, precio_compra, precio_venta, stock, fecha_ingreso, 0));
            }
            
            rs.close();
            ps.close();
            Conexion.closeConnection();
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return productos;
    }

    @Override
    public boolean insertar(Producto producto) {
        try {
            String sql = "INSERT INTO productos (nombre_producto, id_marca, id_categoria, precio_compra, precio_venta, stock, estado)"
                    + "                              VALUES (?,?,?,?,?,?,?)";
            ps = Conexion.MySQL().prepareStatement(sql);
            ps.setString(1, producto.getNombre_producto());
            ps.setString(2, producto.getId_categoria());
            ps.setString(3, producto.getId_marca());
            ps.setDouble(4, producto.getPrecio_compra());
            ps.setDouble(5, producto.getPrecio_venta());
            ps.setInt(6, producto.getStock());
            ps.setInt(7, producto.getEstado());
            
            int filasAfectadas = ps.executeUpdate();
            
            if (filasAfectadas > 0){
                Conexion.closeConnection();
                return true;
            }
            else {
                Conexion.closeConnection();
                return false;
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean editar(Producto producto) {
         try {
            String sql = "UPDATE productos SET nombre_producto=?, id_marca=?, id_categoria=?, precio_compra=?, precio_venta=?, stock=?"
                    + "                              WHERE id_producto=?";
            ps = Conexion.MySQL().prepareStatement(sql);
            ps.setString(1, producto.getNombre_producto());
            ps.setString(2, producto.getId_categoria());
            ps.setString(3, producto.getId_marca());
            ps.setDouble(4, producto.getPrecio_compra());
            ps.setDouble(5, producto.getPrecio_venta());
            ps.setInt(6, producto.getStock());
            ps.setInt(7, producto.getId_producto());
            
            int filasAfectadas = ps.executeUpdate();
            
            if (filasAfectadas > 0){
                Conexion.closeConnection();
                return true;
            }
            else {
                Conexion.closeConnection();
                return false;
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(int estado, int id_producto) {
        try {
            String sql = "UPDATE productos SET estado=? WHERE id_producto=?";
            ps = Conexion.MySQL().prepareStatement(sql);
            ps.setInt(1, estado);
            ps.setInt(2, id_producto);
            
            int filasAfectadas = ps.executeUpdate();
            
            if (filasAfectadas > 0){
                Conexion.closeConnection();
                return true;
            }
            else {
                Conexion.closeConnection();
                return false;
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean disminuirStock(int id_producto, int cantidad) {
        try {
            String sql = "UPDATE productos SET stock = stock - ? WHERE id_producto = ?";
            ps = Conexion.MySQL().prepareStatement(sql);
            ps.setInt(1, cantidad);
            ps.setInt(2, id_producto);
            
            int filasAfectadas = ps.executeUpdate();
            
            if (filasAfectadas > 0){
                Conexion.closeConnection();
                return true;
            }
            else {
                Conexion.closeConnection();
                return false;
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean aumentarStock(int id_producto, int cantidad) {
        try {
            String sql = "UPDATE productos SET stock=stock+?"+
                                        " WHERE id_producto=?";
            ps = Conexion.MySQL().prepareStatement(sql);
            ps.setInt(1, id_producto);
            ps.setInt(2, cantidad);
            
            int filasAfectadas = ps.executeUpdate();
            
            if (filasAfectadas > 0){
                Conexion.closeConnection();
                return true;
            }
            else {
                Conexion.closeConnection();
                return false;
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    
}
