package DAO;

import DB.Conexion;
import Entidad.Proveedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDaoImpl implements ProveedorDao{

    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public List<Proveedor> listar(String busqueda) {
        List<Proveedor> proveedores = new ArrayList<>();
        
        try {
            String query = "SELECT * FROM proveedores WHERE razon_social LIKE '%" + busqueda + "%' AND estado=0 ORDER BY id_proveedor DESC";
            ps = Conexion.MySQL().prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                int id_proveedor = rs.getInt(1);
                String razon_social = rs.getString(2);
                String ruc = rs.getString(3);
                String direccion = rs.getString(4);
                String telefono = rs.getString(5);
                String email = rs.getString(6);
                
                proveedores.add(new Proveedor(id_proveedor, razon_social, ruc, direccion, telefono, email, 0));
            }
            
            rs.close();
            ps.close();
            Conexion.closeConnection();
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return proveedores;
    }

    @Override
    public boolean insertar(Proveedor proveedor) {
        try {
            String sql = "INSERT INTO proveedores (razon_social, ruc, direccion, telefono, email, estado) "
                    + "                             VALUES (?,?,?,?,?, ?)";
            ps = Conexion.MySQL().prepareStatement(sql);
            ps.setString(1, proveedor.getRazon_social());
            ps.setString(2, proveedor.getRuc());
            ps.setString(3, proveedor.getDireccion());
            ps.setString(4, proveedor.getTelefono());
            ps.setString(5, proveedor.getEmail());
            ps.setInt(6, proveedor.getEstado());
            
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
    public boolean editar(Proveedor proveedor) {
        try {
            String sql = "UPDATE proveedores SET razon_social=?, ruc=?, direccion=?, telefono=?, email=? "
                    + "                             WHERE id_proveedor=?";
            ps = Conexion.MySQL().prepareStatement(sql);
            ps.setString(1, proveedor.getRazon_social());
            ps.setString(2, proveedor.getRuc());
            ps.setString(3, proveedor.getDireccion());
            ps.setString(4, proveedor.getTelefono());
            ps.setString(5, proveedor.getEmail());
            ps.setInt(6, proveedor.getId_proveedor());
            
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
    public boolean eliminar(int estado, int id_proveedor) {
        try {
            String sql = "UPDATE proveedores SET estado=? WHERE id_proveedor=?";
            ps = Conexion.MySQL().prepareStatement(sql);
            ps.setInt(1, estado);
            ps.setInt(2, id_proveedor);
            
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
