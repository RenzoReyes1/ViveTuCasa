package DAO;

import DB.Conexion;
import Entidad.DetalleVenta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class DetalleVentaDaoImpl implements DetalleVentaDao{

    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public List<DetalleVenta> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertar(DetalleVenta detalleVenta) {
        try {
            String sql = "INSERT INTO detalle_ventas (id_venta, id_producto,"
                    + "                                 precio, cantidad, importe) VALUES "
                    + "                                 (?,?,?,?,?)";
            
            ps = Conexion.MySQL().prepareStatement(sql);
            ps.setInt(1, detalleVenta.getId_venta());
            ps.setInt(2, detalleVenta.getId_producto());
            ps.setDouble(3, detalleVenta.getPrecio());
            ps.setInt(4, detalleVenta.getCantidad());
            ps.setDouble(5, detalleVenta.getImporte());
            
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
