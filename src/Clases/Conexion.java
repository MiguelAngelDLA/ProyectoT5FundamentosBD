/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;


import com.mysql.jdbc.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aa702
 */
public class Conexion {
    // ATRIBUTOS

    private Connection oConexion;

    // Constructor
    public Conexion() {
        this.oConexion = null;
    }

    // Método para conectarse a la base de datos
    public Connection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            oConexion = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa?autoReconnect=true&useSSL=false","root","1234");
          
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se realizo la conexión." + ex.getMessage());
        }
        return oConexion;
    }

    // Método para descinectarse de la base de datos
    public void desconectarse() {
        try {
            oConexion.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede cerrar la base de datos debido a un error.");
        }
    }
    
    public void AltaCliente(String RFC,String primNombC,String seguNombC,String apPatC,
           String apMatC,Date fechaDeCompra,int numeroDeB,String tipoDeB,double totalPago){
        
         conectar();
          String cadena = "INSERT INTO cliente(RFC, primNombC, seguNombC,apPatC,apMatC,fechaDeCompra,numeroDeB,tipoDeB,totalPago)values(?,?,?,?,?,?,?,?,?)";
        try{
        PreparedStatement pSt = oConexion.prepareStatement(cadena);
            pSt.setString(1, RFC);
            pSt.setString(2, primNombC);
            pSt.setString(3, seguNombC);
            pSt.setString(4, apPatC);
            pSt.setString(5, apMatC);
            pSt.setDate(6, fechaDeCompra);
            pSt.setInt(7, numeroDeB);
            pSt.setString(8,tipoDeB);
            pSt.setDouble(9, totalPago);
            pSt.executeUpdate();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error de alta" + ex.getMessage());
        }
    }
public void eliminarCliente(String rf) {
        conectar();
        String cad = "DELETE FROM cliente WHERE RFC = '" + rf + "'";
        try {
            PreparedStatement pS = oConexion.prepareStatement(cad);
            pS.executeUpdate();
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null,"error "+ex);
        }
        desconectarse();
    }
public void mostrarDCliente(JTable tabla){
        conectar();
        try {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            Statement sT = (Statement) oConexion.createStatement();
            ResultSet rS = sT.executeQuery("Select * from cliente");
            Object [] arreglo = new Object[9];
            while(rS.next()){ 
                arreglo[0] = rS.getString(1);
                arreglo[1] = rS.getString(2);
                arreglo[2] = rS.getString(3);
                arreglo[3] = rS.getString(4);
                arreglo[4] = rS.getString(5);
                arreglo[5] = rS.getDate(6);
                arreglo[6] = rS.getInt(7);
                arreglo[7] = rS.getString(8);
                arreglo[8] = rS.getDouble(9);
                modelo.addRow(arreglo);
            }
            tabla.setModel(modelo);
        
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos.");
        } desconectarse();
    }
 public void modificarCliente(String RFC,String primNombC,String seguNombC,String apPatC,
        String apMatC,Date fechaDeCompra,int numeroDeB,String tipoDeB,double totalPago) {
        conectar();
        
        String cad = "Update cliente Set primNombC='" + primNombC + "',seguNombC='" + seguNombC + "',apPatC='" + apPatC+ "',apMatC='" + apMatC 
         + "',fechaDeCompra='" + fechaDeCompra  + "',numeroDeB='" + numeroDeB +  "',tipoDeB='" + tipoDeB +  "',totalPago='" + totalPago 
                + "'WHERE RFC='" + RFC + "'";

        try {
            PreparedStatement pS = oConexion.prepareStatement(cad);
            pS.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        desconectarse();

    }
 public void consultaRFCcliente(JComboBox combo){
        conectar();
        try{
            PreparedStatement pSt = oConexion.prepareStatement("Select RFC from cliente");
            ResultSet rS = pSt.executeQuery();
            while(rS.next()){
                combo.addItem(rS.getString(1));
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
        desconectarse();
    }
    
 public void datosparacambio(JTextField nom1,JTextField nom2,JTextField ape1,JTextField ape2,
         JTextField fecha,JTextField numero,JTextField tipo,JTextField total,String RFC){
        conectar();
                String cad =  "Select primNombC,seguNombC,apPatC,apMatC,fechaDeCompra,numeroDeB,tipoDeB,totalPago from cliente "+ "where RFC="+"'" + RFC + "'";
        try{
            PreparedStatement pSt = oConexion.prepareStatement(cad);
            ResultSet rS = pSt.executeQuery();
            while(rS.next()){
                nom1.setText(rS.getString(1));
                nom2.setText(rS.getString(2));
                ape1.setText(rS.getString(3));
                ape2.setText(rS.getString(4));
                fecha.setText(String.valueOf(rS.getDate(5)));
                numero.setText(String.valueOf(rS.getInt(6)));
                tipo.setText(rS.getString(7));
                total.setText(String.valueOf(rS.getDouble(8)));
                
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
        desconectarse();
    }

}
