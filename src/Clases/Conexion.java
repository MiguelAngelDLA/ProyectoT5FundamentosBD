/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;


import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

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
            oConexion = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa","root","");
            JOptionPane.showMessageDialog(null, "Conexion exitosa");
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
    

}
