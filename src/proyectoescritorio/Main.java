/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoescritorio;

import Controlador.ControladorPrincipal;
import Controlador.ControladorProducto;
import Modelo.ConsultaProducto;
import Modelo.Producto;
import Vista.Consulta;
import Vista.Diseño;
import Modelo.Conexion;

/**
 *
 * @author ASUS
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Producto pro = new Producto(); //instanciando la clase producto
        Consulta frmpro = new Consulta();
        ConsultaProducto proC = new ConsultaProducto();
        Diseño frmpri = new Diseño();
        ControladorProducto crtlPro = new ControladorProducto(pro,frmpro,proC);
        ControladorPrincipal crtlPri = new ControladorPrincipal(frmpri,frmpro);
        crtlPri.iniciar();
        frmpri.setVisible(true);
    }
    
}
