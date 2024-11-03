package DAO;

import DB.Conexion;
import Entidad.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoImpl implements ClienteDao{

    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public List<Cliente> listar(String busqueda) {
         List<Cliente> clientes = new ArrayList<>();
        
        try {
            String query = "SELECT * FROM clientes WHERE numero_documento LIKE '%" + busqueda + "%' AND estado=0 ORDER BY id_cliente DESC";
            
            ps = Conexion.MySQL().prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                int id_cliente = rs.getInt(1);
                String nombres_apellidos = rs.getString(2);
                String tipo_documento = rs.getString(3);
                String nro_documento = rs.getString(4);
                String direccion = rs.getString(5);
                String telefono = rs.getString(6);
                String email = rs.getString(7);
                
                clientes.add(new Cliente(id_cliente, nombres_apellidos, tipo_documento, nro_documento, direccion,telefono, email, 0));
            }
            
            rs.close();
            ps.close();
            Conexion.closeConnection();
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return clientes;
    }

    @Override
    public boolean insertar(Cliente cliente) {
        try {
            String sql = "INSERT INTO clientes  (nombres_apellidos,"
                    + "                         tipo_documento,"
                    + "                         numero_documento, direccion, telefono,"
                    + "                         email, estado) VALUES"
                    + "                         (?,?,?,?,?,?,?)";
            
            ps = Conexion.MySQL().prepareStatement(sql);
            ps.setString(1, cliente.getNombres_apellidos());
            ps.setString(2, cliente.getTipo_documento());
            ps.setString(3, cliente.getNro_documento());
            ps.setString(4, cliente.getDireccion());
            ps.setString(5, cliente.getTelefono());
            ps.setString(6, cliente.getEmail());
            ps.setInt(7, cliente.getEstado());
            
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
    public boolean editar(Cliente cliente) {
        try {
            String sql = "UPDATE clientes SET nombres_apellidos=?,"
                    + "                         tipo_documento=?,"
                    + "                         numero_documento=?, direccion=?,telefono=?,"
                    + "                         email=? WHERE id_cliente=?";
            
            ps = Conexion.MySQL().prepareStatement(sql);
            ps.setString(1, cliente.getNombres_apellidos());
            ps.setString(2, cliente.getTipo_documento());
            ps.setString(3, cliente.getNro_documento());
            ps.setString(4, cliente.getDireccion());
            ps.setString(5, cliente.getTelefono());
            ps.setString(6, cliente.getEmail());
            ps.setInt(7, cliente.getId_cliente());
            
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
    public boolean eliminar(int estado, int id_cliente) {
        try {
            String sql = "UPDATE clientes SET estado=? WHERE id_cliente=?";
            
            ps = Conexion.MySQL().prepareStatement(sql);
            ps.setInt(1, estado);
            ps.setInt(2, id_cliente);
            
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
