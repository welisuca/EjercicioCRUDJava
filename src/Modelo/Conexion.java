/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class Conexion {
    private String base = "tienda1";//nombre base en PHP
    private String user = "root";//usuario en PHP
    private String password = "";//clave usuario en PHP, en este caso no tenemos
    private String url = "jdbc:mysql://localhost:3306/"+base;//desde jdbc...hasts host: suelen llamarse igual siempre, cambia el # puerto
    private Connection con = null;

public Connection getConnection(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        con = (Connection)DriverManager.getConnection(this.url,this.user,this.password);
        JOptionPane.showMessageDialog(null,"Hay conexion");//JOptionPane permite mostrar un mensaje cuando se establece conexión
    }catch (SQLException e){//cuando me genere un error me muestre
                System.err.println(e);//muestre el error
                JOptionPane.showMessageDialog(null, "Error");
    }catch (ClassNotFoundException ex){//buscar el error y me diga qué es
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
    }
    return con;
}
}