package DAO;

import DB.Conexion;
import Entidad.DetalleCompra;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class DetalleCompraDaoImpl implements DetalleCompraDao{

    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public List<DetalleCompra> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertar(DetalleCompra detalleCompra) {
        try {
            String sql = "INSERT INTO detalle_compras (id_compra, id_producto,"
                    + "                                 precio, cantidad, importe) VALUES "
                    + "                                 (?,?,?,?,?)";
            
            ps = Conexion.MySQL().prepareStatement(sql);
            ps.setInt(1, detalleCompra.getId_compra());
            ps.setInt(2, detalleCompra.getId_producto());
            ps.setDouble(3, detalleCompra.getPrecio());
            ps.setInt(4, detalleCompra.getCantidad());
            ps.setDouble(5, detalleCompra.getImporte());
            
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
