
package DAO;

import DB.Conexion;
import Entidad.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoImpl implements UsuarioDao{
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public List<Usuario> listar(String busqueda) {
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            String query = "SELECT usuarios.id_usuario, roles.rol, usuarios.nombres, usuarios.apellidos, usuarios.tipo_documento, usuarios.nro_documento, usuarios.telefono, usuarios.email, usuarios.username, usuarios.password FROM usuarios JOIN roles ON roles.id_rol = usuarios.id_rol WHERE usuarios.nro_documento LIKE '%" + busqueda + "%' AND estado=0 ORDER BY usuarios.id_usuario DESC";
            
            ps = Conexion.MySQL().prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                int id_usuario = rs.getInt(1);
                String id_rol = rs.getString(2);
                String nombres = rs.getString(3);
                String apellidos = rs.getString(4);
                String tipo_documento = rs.getString(5);
                String nro_documento = rs.getString(6);
                String telefono = rs.getString(7);
                String email = rs.getString(8);
                String username = rs.getString(9);
                String password = rs.getString(10);
                
                usuarios.add(new Usuario(id_usuario, id_rol, nombres, apellidos, tipo_documento, nro_documento, telefono, email, username, password, 0));
            }
            
            rs.close();
            ps.close();
            Conexion.closeConnection();
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return usuarios;
    }

    @Override
    public boolean insertar(Usuario usuario) {
        try {
            String sql = "INSERT INTO usuarios  (id_rol, nombres, apellidos,"
                    + "                         tipo_documento,"
                    + "                         nro_documento, telefono,"
                    + "                         email, username, password, estado) VALUES"
                    + "                         (?,?,?,?,?,?, ?, ?,?, ?)";
            
            ps = Conexion.MySQL().prepareStatement(sql);
            ps.setString(1, usuario.getId_rol());
            ps.setString(2, usuario.getNombres());
            ps.setString(3, usuario.getApellidos());
            ps.setString(4, usuario.getTipo_documento());
            ps.setString(5, usuario.getNro_documento());
            ps.setString(6, usuario.getTelefono());
            ps.setString(7, usuario.getEmail());
            ps.setString(8, usuario.getUsername());
            ps.setString(9, usuario.getPassword());
             ps.setInt(10, usuario.getEstado());
            
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
    public boolean editar(Usuario usuario) {
        try {
            String sql = "UPDATE usuarios SET id_rol=?, nombres=?, apellidos=?,"
                    + "                         tipo_documento=?,"
                    + "                         nro_documento=?, telefono=?,"
                    + "                         email=?, username=?, password=? "
                    + "                         WHERE id_usuario=?";
            
            ps = Conexion.MySQL().prepareStatement(sql);
            ps.setString(1, usuario.getId_rol());
            ps.setString(2, usuario.getNombres());
            ps.setString(3, usuario.getApellidos());
            ps.setString(4, usuario.getTipo_documento());
            ps.setString(5, usuario.getNro_documento());
            ps.setString(6, usuario.getTelefono());
            ps.setString(7, usuario.getEmail());
            ps.setString(8, usuario.getUsername());
            ps.setString(9, usuario.getPassword());
            ps.setInt(10, usuario.getId_usuario());
            
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
    public  boolean eliminar(int estado, int id_usuario) {
        try {
            String sql = "UPDATE usuarios SET estado=? WHERE id_usuario=?";
            
            ps = Conexion.MySQL().prepareStatement(sql);
            ps.setInt(1, estado);
            ps.setInt(2, id_usuario);
            
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
    public boolean login(String username, String password) {       
        try {
            String query = "SELECT id_usuario, id_rol, nombres FROM usuarios WHERE estado=0 AND username=? AND password=?";
            ps = Conexion.MySQL().prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            
            while(rs.next()){
                return true;                    
            }
            
            rs.close();
            ps.close();
            Conexion.closeConnection();
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        
        return false;
    }
}
