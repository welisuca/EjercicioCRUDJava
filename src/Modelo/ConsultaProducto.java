/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author ASUS
 */
public class ConsultaProducto extends Conexion{
    //Metodo registrar
    public boolean registrar(Producto p){
        PreparedStatement ps = null; //prepara la base de datos para aplicar los métodos
        Connection con = getConnection();
        String sql ="insert into producto (codigo,nombre,precio)values (?,?,?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1,p.getCodigo());
            ps.setString(2,p.getNombre());
            ps.setInt(3,p.getPrecio());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.err.print(e);
            return false;
        }
    }
    //Metodo modificar
    public boolean modificar(Producto p){
        PreparedStatement ps = null;
        Connection con = getConnection();
        String sql = "update producto set codigo=?,nombre=?,precio=? where id=?"; //siempre que me actualice los datos comience por el id
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1,p.getCodigo());
            ps.setString(2,p.getNombre());
            ps.setInt(3,p.getPrecio());
            ps.setInt(4,p.getId());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.err.print(e);
            return false;
        }
    }
    //Metodo eliminar
    public boolean eliminar (Producto p){    
        PreparedStatement ps =null;
        Connection con = getConnection();
        String sql = "delete from producto where id=?"; //Siempre que se borren los datos comience por el id
        try{
                ps =con.prepareStatement(sql);
                ps.setInt(1,p.getId());
                ps.execute();
                return true;
        }catch(SQLException e){  
           System.err.print(e);
                return false;
        }        
    }
    //Metodo buscar
    public boolean buscar (Producto p){    
        PreparedStatement ps =null;
        Connection con = getConnection();
        ResultSet rs = null; //permite traer los datos
        String sql = "select *from producto where id=?";
        try{
            ps =con.prepareStatement(sql);
            ps.setInt(1,p.getId());
            rs = ps.executeQuery();
            if(rs.next())
            {
                p.setId(Integer.parseInt(rs.getString("id")));
                p.setCodigo(rs.getString("codigo"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(Integer.parseInt(rs.getString("precio")));
                return true;
            }
                return false;
        }catch(SQLException e){  
            System.err.print(e);
            return false;          
        }
    }
    //Metodo limpiar opcional
}
