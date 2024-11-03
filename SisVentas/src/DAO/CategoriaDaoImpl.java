package DAO;

import DB.Conexion;
import Entidad.Categoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDaoImpl implements CategoriaDao{

    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public List<Categoria> listar(String busqueda) {
        List<Categoria> categorias = new ArrayList<>();
        
        try {
            String query = "SELECT * FROM categorias WHERE nombre_categoria LIKE '%" + busqueda + "%' AND estado=0 ORDER BY id_categoria DESC";
            ps = Conexion.MySQL().prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                int id_categoria = rs.getInt(1);
                String nombre_categoria = rs.getString(2);
                int estado = rs.getInt(3);
                
                categorias.add(new Categoria(id_categoria, nombre_categoria, estado));
            }
            
            rs.close();
            ps.close();
            Conexion.closeConnection();
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return categorias;
    }

    @Override
    public boolean insertar(Categoria categoria) {
        try {
            String sql = "INSERT INTO categorias (nombre_categoria, estado) VALUES (?,?)";
            ps = Conexion.MySQL().prepareStatement(sql);
            ps.setString(1, categoria.getNombre_categoria());
            ps.setInt(2, categoria.getEstado());
            
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
    public boolean editar(Categoria categoria) {
        try {
            String sql = "UPDATE categorias SET nombre_categoria=? WHERE id_categoria=?";
            ps = Conexion.MySQL().prepareStatement(sql);
            ps.setString(1, categoria.getNombre_categoria());
            ps.setInt(2, categoria.getId_categoria());
            
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
    public boolean eliminar(int estado, int id_categoria) {
        try {
            String sql = "UPDATE categorias SET estado=? WHERE id_categoria=?";
            ps = Conexion.MySQL().prepareStatement(sql);
            ps.setInt(1, estado);
            ps.setInt(2, id_categoria);
            
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
