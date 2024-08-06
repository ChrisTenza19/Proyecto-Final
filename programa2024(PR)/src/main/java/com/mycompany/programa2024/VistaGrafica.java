/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.programa2024;

import com.mysql.cj.protocol.Resultset;
import java.awt.BorderLayout;
import java.awt.Component;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Tenza
 */
public class VistaGrafica extends javax.swing.JFrame {
    JFreeChart Grafico;
    DefaultCategoryDataset datos = new DefaultCategoryDataset();
    JFreeChart Grafico2;
    DefaultCategoryDataset datos2 = new DefaultCategoryDataset();
    JFreeChart Grafico3;
    DefaultCategoryDataset datos3 = new DefaultCategoryDataset();
    
    /**
     * Creates new form VistaGrafica
     */
    public VistaGrafica() {
        initComponents();
        tablacargar();
        tablacargar2();
        tablacargar3();
        graficame();
        graficame2();
        graficame3();
        setIconImage(new ImageIcon(getClass().getResource("/images/icono.png")).getImage());
        

    }
    
    
    public void tablacargar() {
     try {
         
       DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
       
       dt.setRowCount(0);
       
         ConexionDB conectar = new ConexionDB();
            Connection conexion = conectar.establecerconexion();
            
              Statement s = conexion.createStatement();
              ResultSet rs = s.executeQuery("SELECT * FROM candidates");
              
              while (rs.next()){
                  
                   Vector v = new Vector();
              
              v.add(rs.getInt(1)); //id
              v.add(rs.getString(2)); //nombre
              v.add(rs.getInt(3)); //votos
              
              dt.addRow(v);
              
              }
              
             
        
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public void tablacargar2() {
     try {
         
       DefaultTableModel dt = (DefaultTableModel) jTable2.getModel();
       
       dt.setRowCount(0);
       
         ConexionDB conectar = new ConexionDB();
            Connection conexion = conectar.establecerconexion();
            
              Statement s = conexion.createStatement();
              ResultSet rs = s.executeQuery("SELECT * FROM regidores");
              
              while (rs.next()){
                  
                   Vector v = new Vector();
              
              v.add(rs.getInt(1)); //id
              v.add(rs.getString(2)); //nombre
              v.add(rs.getInt(3)); //votos
              
              dt.addRow(v);
              
              }
              
             
        
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    public void tablacargar3() {
     try {
         
       DefaultTableModel dt = (DefaultTableModel) jTable3.getModel();
       
       dt.setRowCount(0);
       
         ConexionDB conectar = new ConexionDB();
            Connection conexion = conectar.establecerconexion();
            
              Statement s = conexion.createStatement();
              ResultSet rs = s.executeQuery("SELECT * FROM presidentes");
              
              while (rs.next()){
                  
                   Vector v = new Vector();
              
              v.add(rs.getInt(1)); //id
              v.add(rs.getString(2)); //nombre
              v.add(rs.getInt(3)); //votos
              
              dt.addRow(v);
              
              }
              
             
        
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    public void graficame(){
        try{
            
            for (int i = 0;i < jTable1.getRowCount(); i++){
                datos.addValue(Integer.parseInt(jTable1.getValueAt(i, 2).toString()), jTable1.getValueAt(i, 1).toString(), jTable1.getValueAt(i, 0).toString());
        }
            Grafico = ChartFactory.createBarChart("Votos Diputados", "Numero de partido", "Votos", datos, PlotOrientation.VERTICAL, true, true, false);
            ChartPanel panel = new ChartPanel(Grafico);
            add(panel);
            panel.setBounds(0, 0, 300, 350);
                    
           }  catch (NumberFormatException e){
            System.out.println(e);
        
    }
        
}
    public void graficame2(){
        try{
            
            for (int i = 0;i < jTable2.getRowCount(); i++){
                datos2.addValue(Integer.parseInt(jTable2.getValueAt(i, 2).toString()), jTable2.getValueAt(i, 1).toString(), jTable2.getValueAt(i, 0).toString());
        }
            Grafico2 = ChartFactory.createBarChart("Votos Regidores", "Numero de partido", "Votos", datos2, PlotOrientation.VERTICAL, true, true, false);
            ChartPanel panel = new ChartPanel(Grafico2);
            add(panel);
            panel.setBounds(300, 0, 300, 350);
                    
           }  catch (NumberFormatException e){
            System.out.println(e);
        
    }
        
}
    public void graficame3(){
        try{
            
            for (int i = 0;i < jTable3.getRowCount(); i++){
                datos3.addValue(Integer.parseInt(jTable3.getValueAt(i, 2).toString()), jTable3.getValueAt(i, 1).toString(), jTable3.getValueAt(i, 0).toString());
        }
            Grafico3 = ChartFactory.createBarChart("Votos Presidentes", "Numero de partido", "Votos", datos3, PlotOrientation.VERTICAL, true, true, false);
            ChartPanel panel = new ChartPanel(Grafico3);
            add(panel);
            panel.setBounds(600, 0, 300, 350);
                    
           }  catch (NumberFormatException e){
            System.out.println(e);
        
    }
        
}
        /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("VOTACIONES EN VIVO");
        setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Partido", "Nombres", "Votos"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("FINALIZAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Partido", "Nombres", "Votos"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Partido", "Nombres", "Votos"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(378, 378, 378))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(408, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}
