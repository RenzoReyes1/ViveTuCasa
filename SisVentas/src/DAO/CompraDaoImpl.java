package DAO;

import DB.Conexion;
import Entidad.Compra;
import Util.Funciones;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class CompraDaoImpl implements CompraDao{

    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public List<Compra> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertar(Compra compra) {
        String fecha, hora;
        fecha = Funciones.getFechaActual();
        hora = Funciones.getHoraActual();
        
        try {
            String sql = "INSERT INTO compras (id_usuario, id_proveedor,"
                    + "                         tipo_comprobante, nro_comprobante,"
                    + "                         fecha, hora, total, estado) VALUES "
                    + "                         (?,?,?,?,?,?,?,?)";
            
            ps = Conexion.MySQL().prepareStatement(sql);
            ps.setInt(1, compra.getId_usuario());
            ps.setInt(2, compra.getId_proveedor());
            ps.setString(3, compra.getTipo_comprobante());
            ps.setString(4, compra.getNro_comprobante());
            ps.setDate(5, Date.valueOf(fecha));
            ps.setString(6, hora);
            ps.setDouble(7, compra.getTotal());
            ps.setInt(8, compra.getEstado());
            
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
    public boolean editar(Compra compra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Compra compra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getMaxIdCompra() {
        String id = "";
        
        try {
            String sql = "SELECT MAX(id_compra) FROM compras";
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
            String sql = "SELECT MAX(nro_comprobante) AS codigo FROM compras WHERE tipo_comprobante='Boleta'";
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
