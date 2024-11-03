package DAO;

import DB.Conexion;
import Entidad.Marca;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MarcaDaoImpl implements MarcaDao{

    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public List<Marca> listar(String busqueda) {
        List<Marca> marcas = new ArrayList<>();
        
        try {
            String query = "SELECT * FROM marcas WHERE nombre_marca LIKE '%" + busqueda + "%' AND estado=0 ORDER BY id_marca DESC";
            ps = Conexion.MySQL().prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                int id_marca = rs.getInt(1);
                String nombre_marca = rs.getString(2);
                int estado = rs.getInt(3);
                
                marcas.add(new Marca(id_marca, nombre_marca, estado));
            }
            
            rs.close();
            ps.close();
            Conexion.closeConnection();
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return marcas;
    }

    @Override
    public boolean insertar(Marca marca) {
        try {
            String sql = "INSERT INTO marcas (nombre_marca, estado) VALUES (?, ?)";
            ps = Conexion.MySQL().prepareStatement(sql);
            ps.setString(1, marca.getNombre_marca());
            ps.setInt(2, marca.getEstado());
            
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
    public boolean editar(Marca marca) {
        try {
            String sql = "UPDATE marcas SET nombre_marca=? WHERE id_marca=?";
            ps = Conexion.MySQL().prepareStatement(sql);
            ps.setString(1, marca.getNombre_marca());
            ps.setInt(2, marca.getId_marca());
            
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
    public boolean eliminar(int estado, int id_marca) {
        try {
            String sql = "UPDATE marcas SET estado=? WHERE id_marca=?";
            ps = Conexion.MySQL().prepareStatement(sql);
            ps.setInt(1, estado);
            ps.setInt(2, id_marca);
            
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
