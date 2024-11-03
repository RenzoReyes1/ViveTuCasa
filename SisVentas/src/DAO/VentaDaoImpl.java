package DAO;

import DB.Conexion;
import Entidad.Venta;
import Util.Funciones;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class VentaDaoImpl implements VentaDao{

    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public List<Venta> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertar(Venta venta) {
        String fecha, hora;
        fecha = Funciones.getFechaActual();
        hora = Funciones.getHoraActual();
        
        try {
            String sql = "INSERT INTO ventas (id_usuario, id_cliente,"
                    + "                         tipo_comprobante, nro_comprobante,"
                    + "                         fecha, hora, total, estado) VALUES "
                    + "                         (?,?,?,?,?,?,?,?)";
            
            ps = Conexion.MySQL().prepareStatement(sql);
            ps.setInt(1, venta.getId_usuario());
            ps.setInt(2, venta.getId_cliente());
            ps.setString(3, venta.getTipo_comprobante());
            ps.setString(4, venta.getNro_comprobante());
            ps.setDate(5, Date.valueOf(fecha));
            ps.setString(6, hora);
            ps.setDouble(7, venta.getTotal());
            ps.setInt(8, venta.getEstado());
            
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
    public boolean editar(Venta venta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Venta venta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getMaxIdVenta() {
        String id = "";
        
        try {
            String sql = "SELECT MAX(id_venta) FROM ventas";
            ps = Conexion.MySQL().prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()){
                id = rs.getString(1);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return id;
    }

    @Override
    public int generarComprobanteBoleta() {
        int codigo = 0;
        
        try {
            String sql = "SELECT MAX(nro_comprobante) AS codigo FROM ventas WHERE tipo_comprobante='Boleta'";
            ps = Conexion.MySQL().prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()){
                codigo = rs.getInt(1);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return codigo;
    }
}
