/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ConsultaProducto;
import Modelo.Producto;
import Vista.Consulta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class ControladorProducto implements ActionListener{
    private Producto pro;
    private Consulta frmpro;
    private ConsultaProducto proC;

    public ControladorProducto(Producto pro, Consulta frmpro, ConsultaProducto proC) {
        this.pro = pro;
        this.frmpro = frmpro;
        this.proC = proC;
        this.frmpro.btn_agregar.addActionListener((ActionListener)this);
        this.frmpro.btn_buscar.addActionListener((ActionListener)this);
        this.frmpro.btn_eliminar.addActionListener((ActionListener)this);
        this.frmpro.btn_modificar.addActionListener((ActionListener)this);
        this.frmpro.btn_limpiar.addActionListener((ActionListener)this);
        this.frmpro.txt_panelPrincipal.addActionListener((ActionListener)this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Boton agregar
        if(e.getSource()==frmpro.btn_agregar){
            pro.setCodigo(frmpro.txt_Codigo.getText());
            pro.setNombre(frmpro.txt_Nombre.getText());
            pro.setPrecio(Integer.parseInt(frmpro.txt_Precio.getText()));
            if(proC.registrar(pro)){
                JOptionPane.showMessageDialog(null,"Producto agregado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null,"Error al agregar");
                limpiar();
            }
        
        }
        
        // boton modificar
        if(e.getSource()==frmpro.btn_modificar){
            pro.setId(Integer.parseInt(frmpro.txt_Id.getText()));
            pro.setCodigo(frmpro.txt_Codigo.getText());
            pro.setNombre(frmpro.txt_Nombre.getText());
            pro.setPrecio(Integer.parseInt(frmpro.txt_Precio.getText()));
            if(proC.modificar(pro)){
                JOptionPane.showMessageDialog(null,"Producto modificado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null,"Error al modificar");
                limpiar();
            }
        }
        
        //boton eliminar
        if(e.getSource()==frmpro.btn_eliminar){
            pro.setId(Integer.parseInt(frmpro.txt_Id.getText()));
            if(proC.eliminar(pro)){
                JOptionPane.showMessageDialog(null,"Producto eliminado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null,"Error al eliminar");
                limpiar();
            }
        }
        // boton buscar
        if(e.getSource()==frmpro.btn_buscar){
            pro.setId(Integer.parseInt(frmpro.txt_Id.getText()));
            if(proC.buscar(pro)){
                frmpro.txt_Id.setText(String.valueOf(pro.getId()));//me apague el tipo de dato para no tener conflicto con el tipo de la base php
                frmpro.txt_Codigo.setText(pro.getCodigo());
                frmpro.txt_Nombre.setText(pro.getNombre());
                frmpro.txt_Precio.setText(String.valueOf(pro.getPrecio()));
            }else{
                JOptionPane.showMessageDialog(null,"Error al buscar");
                limpiar();
            }
        }
        
       //boton limpiar
       if(e.getSource()==frmpro.btn_limpiar){
        limpiar();
        }
    }
    private void limpiar(){
        frmpro.txt_Codigo.setText(null);
        frmpro.txt_Id.setText(null);
        frmpro.txt_Nombre.setText(null);
        frmpro.txt_Precio.setText(null);
        
    }
}
