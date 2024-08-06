/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.programa2024;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author Tenza
 */
public class ConexionDB {
    Connection conectar = null;
    String usuario = "root";
    String contraseña = "1234";
    String bd = "registro";
    String ip = "localhost";
    String puerto = "3306";
    
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
    public Connection establecerconexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conectar=DriverManager.getConnection(cadena, usuario, contraseña);
           
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Base de datos inaccesible" + e.toString());
        }
        return conectar;
    }
    
}
