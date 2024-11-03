package DAO;

import DB.Conexion;
import Entidad.Rol;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RolDaoImpl implements RolDao{

    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public List<Rol> listar() {
        List<Rol> roles = new ArrayList<>();
        
        try {
            String query = "SELECT * FROM roles ";
            ps = Conexion.MySQL().prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                int id_rol = rs.getInt(1);
                String rol = rs.getString(2);
                
                roles.add(new Rol(id_rol, rol));
            }
            
            rs.close();
            ps.close();
            Conexion.closeConnection();
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return roles;
    }
    
}
