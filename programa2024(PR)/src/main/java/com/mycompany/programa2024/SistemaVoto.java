/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.programa2024;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
/**
 *
 * @author Tenza
 */
public class SistemaVoto extends MenuPrincipal{
    

    
    
    
    public void GuardarVoto(String candidate) {
        String url = "jdbc:mysql://localhost:3306/registro"; 
        String user = "root";
        String password = "ledesma2109";

        try (java.sql.Connection conn = java.sql.DriverManager.getConnection(url, user, password)) {
            String sql = "UPDATE candidates SET votes = votes + 1 WHERE nombre = ?";
            try (java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, candidate);
                pstmt.executeUpdate();
                javax.swing.JOptionPane.showMessageDialog(null, "Voto guardado con éxito para " + candidate);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null, "Error al guardar el voto: " + ex.getMessage());
        }
    }
    
}
