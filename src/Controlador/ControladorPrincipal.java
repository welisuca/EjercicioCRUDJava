/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.Consulta;
import Vista.Diseño;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ASUS
 */
public class ControladorPrincipal implements ActionListener{
    private Diseño frmPri;
    private Consulta frmPro;

    public ControladorPrincipal(Diseño frmPri, Consulta frmPro) {
        this.frmPri = frmPri;
        this.frmPro = frmPro;
        this.frmPri.menu_producto.addActionListener(this);//¿?por qué en controlador producto colocó adicional actionListener
        this.frmPri.menu_salir.addActionListener(this);
    }
    
    public void iniciar(){
        frmPro.setTitle("Producto");
        frmPri.setTitle("Principal");
        frmPri.setLocationRelativeTo(null);//quede centrado
        frmPro.setLocationRelativeTo(null);//quede centrado
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==frmPri.menu_producto){
            frmPro.setVisible(true);
        }
        if(e.getSource()==frmPri.menu_salir){
            System.exit(0);
        }
        }
    
    
}
