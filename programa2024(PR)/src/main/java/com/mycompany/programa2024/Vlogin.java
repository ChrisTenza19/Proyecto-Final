/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.programa2024;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Tenza
 */
public class Vlogin {
    
    public void ValidarUsario(JTextField usuario, JPasswordField contraseña){
        try{
            ResultSet rs=null;
            PreparedStatement ps=null;
            
            com.mycompany.programa2024.ConexionDB objetoconexion =
                    new com.mycompany.programa2024.ConexionDB();
            
            String Consulta="select * from registro where registro.cedula =(?) and registro.clave_acceso =(?);";
            ps=objetoconexion.establecerconexion().prepareStatement(Consulta);
            
            
            String contra =String.valueOf(contraseña.getPassword());
                    
            ps.setString(1, usuario.getText());
             ps.setString(2, contra);
             
             rs = ps.executeQuery();
             
             if (rs.next()){
            JOptionPane.showMessageDialog(null, "Datos correctos, bienvenido/a.");
            MenuPrincipal objetomenu = new MenuPrincipal();
            objetomenu.setVisible(true);
            objetomenu.setLocationRelativeTo(null);
            
            
        }
             
             else {
                 JOptionPane.showMessageDialog(null, "La cedula o contraseña son incorrectas");
             }
        }
        catch (Exception e){
                             JOptionPane.showMessageDialog(null, "Ha ocurrido un error:"+e.toString());

        }
    }
}