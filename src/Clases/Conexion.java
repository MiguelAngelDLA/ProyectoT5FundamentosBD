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
            oConexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", "");

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

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //conexiones de cliente
    public void AltaCliente(String RFC, String primNombC, String seguNombC, String apPatC,
            String apMatC, Date fechaDeCompra, int numeroDeB, String tipoDeB, double totalPago) {

        conectar();
        String cadena = "INSERT INTO cliente(RFC, primNombC, seguNombC,apPatC,apMatC,fechaDeCompra,numeroDeB,tipoDeB,totalPago)values(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pSt = oConexion.prepareStatement(cadena);
            pSt.setString(1, RFC);
            pSt.setString(2, primNombC);
            pSt.setString(3, seguNombC);
            pSt.setString(4, apPatC);
            pSt.setString(5, apMatC);
            pSt.setDate(6, fechaDeCompra);
            pSt.setInt(7, numeroDeB);
            pSt.setString(8, tipoDeB);
            pSt.setDouble(9, totalPago);
            pSt.executeUpdate();

        } catch (SQLException ex) {
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
            JOptionPane.showMessageDialog(null, "error " + ex);
        }
        desconectarse();
    }

    public void mostrarDCliente(JTable tabla) {
        conectar();
        try {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            Statement sT = (Statement) oConexion.createStatement();
            ResultSet rS = sT.executeQuery("Select * from cliente");
            Object[] arreglo = new Object[9];
            while (rS.next()) {
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

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos.");
        }
        desconectarse();
    }

    public void modificarCliente(String RFC, String primNombC, String seguNombC, String apPatC,
            String apMatC, Date fechaDeCompra, int numeroDeB, String tipoDeB, double totalPago) {
        conectar();

        String cad = "Update cliente Set primNombC='" + primNombC + "',seguNombC='" + seguNombC + "',apPatC='" + apPatC + "',apMatC='" + apMatC
                + "',fechaDeCompra='" + fechaDeCompra + "',numeroDeB='" + numeroDeB + "',tipoDeB='" + tipoDeB + "',totalPago='" + totalPago
                + "'WHERE RFC='" + RFC + "'";

        try {
            PreparedStatement pS = oConexion.prepareStatement(cad);
            pS.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        desconectarse();

    }

    public void consultaRFCcliente(JComboBox combo) {
        conectar();
        try {
            PreparedStatement pSt = oConexion.prepareStatement("Select RFC from cliente");
            ResultSet rS = pSt.executeQuery();
            while (rS.next()) {
                combo.addItem(rS.getString(1));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
        desconectarse();
    }

    public void datosparacambio(JTextField nom1, JTextField nom2, JTextField ape1, JTextField ape2,
            JTextField fecha, JTextField numero, JTextField tipo, JTextField total, String RFC) {
        conectar();
        String cad = "Select primNombC,seguNombC,apPatC,apMatC,fechaDeCompra,numeroDeB,tipoDeB,totalPago from cliente " + "where RFC=" + "'" + RFC + "'";
        try {
            PreparedStatement pSt = oConexion.prepareStatement(cad);
            ResultSet rS = pSt.executeQuery();
            while (rS.next()) {
                nom1.setText(rS.getString(1));
                nom2.setText(rS.getString(2));
                ape1.setText(rS.getString(3));
                ape2.setText(rS.getString(4));
                fecha.setText(String.valueOf(rS.getDate(5)));
                numero.setText(String.valueOf(rS.getInt(6)));
                tipo.setText(rS.getString(7));
                total.setText(String.valueOf(rS.getDouble(8)));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
        desconectarse();
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Conexiones de bebida

// public void AltaBebida(int claveB,String primNombC,String seguNombC,String apPatC,
//           String apMatC,Date fechaDeCompra,int numeroDeB,String tipoDeB,double totalPago){
//        
//         conectar();
//          String cadena = "INSERT INTO bebida(claveB,nombreB,tamaño,tipoDeLeche,tipoDeAzúcar,Ingredientes,formPreparacion,rfcCliente))values(?,?,?,?,?,?,?,?)";
//        try{
//        PreparedStatement pSt = oConexion.prepareStatement(cadena);
//            pSt.setString(1, RFC);
//            pSt.setString(2, primNombC);
//            pSt.setString(3, seguNombC);
//            pSt.setString(4, apPatC);
//            pSt.setString(5, apMatC);
//            pSt.setDate(6, fechaDeCompra);
//            pSt.setInt(7, numeroDeB);
//            pSt.setString(8,tipoDeB);
//            pSt.setDouble(9, totalPago);
//            pSt.executeUpdate();
//            
//        }catch(SQLException ex){
//            JOptionPane.showMessageDialog(null, "Error de alta" + ex.getMessage());
//        }
//    }
    ////////////////////////////////////////////////////////////////////////////
    //empleado
    public void AltaEmpleado(String CURPE, String primNombE, String seguNombE, String apPatE, String apMatE, int celular, String ocupacion, int hrsTrab) {
        conectar();
        String cadena = "INSERT INTO empleado(CURPE,primNombE,seguNombE,apPatE,apMatE,celular,ocupacion,hrsTrab)values(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pSt = oConexion.prepareStatement(cadena);
            pSt.setString(1, CURPE);
            pSt.setString(2, primNombE);
            pSt.setString(3, seguNombE);
            pSt.setString(4, apPatE);
            pSt.setString(5, apMatE);
            pSt.setInt(6, celular);
            pSt.setString(7, ocupacion);
            pSt.setInt(8, hrsTrab);
            pSt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de alta" + ex.getMessage());
        }
    }

    public void eliminarEmpleado(String Curp) {
        conectar();
        String cad = "DELETE FROM empleado WHERE CURPE = '" + Curp + "'";
        try {
            PreparedStatement pS = oConexion.prepareStatement(cad);
            pS.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error " + ex);
        }
        desconectarse();
    }

    public void mostrarEmpleado(JTable tabla) {
        conectar();
        try {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            Statement sT = (Statement) oConexion.createStatement();
            ResultSet rS = sT.executeQuery("Select * from empleado");
            Object[] arreglo = new Object[8];
            while (rS.next()) {
                arreglo[0] = rS.getString(1);
                arreglo[1] = rS.getString(2);
                arreglo[2] = rS.getString(3);
                arreglo[3] = rS.getString(4);
                arreglo[4] = rS.getString(5);
                arreglo[5] = rS.getLong(6);
                arreglo[6] = rS.getString(7);
                arreglo[7] = rS.getInt(8);
                modelo.addRow(arreglo);
            }
            tabla.setModel(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        desconectarse();
    }

    public void consultaEmpleado(JComboBox combo) {
        conectar();
        try {
            PreparedStatement pSt = oConexion.prepareStatement("Select CURPE from empleado");
            ResultSet rS = pSt.executeQuery();
            while (rS.next()) {
                combo.addItem(rS.getString(1));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
        desconectarse();
    }

    public void modificarEmpleado(String CURPE, String primNombE, String seguNombE, String apPatE,
            String apMatE, int celular, String ocupacion, int hrsTrab) {
        conectar();

        String cad = "Update empleado Set primNombE='" + primNombE + "',seguNombE='" + seguNombE + "',apPatE='" + apPatE + "',apMatE='" + apMatE
                + "',celular='" + celular + "',ocupacion='" + ocupacion + "',hrsTrab='" + hrsTrab
                + "'WHERE CURPE='" + CURPE + "'";
        try {
            PreparedStatement pS = oConexion.prepareStatement(cad);
            pS.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        desconectarse();

    }

    public void datosEmp(JTextField nom1, JTextField nom2, JTextField ape1, JTextField ape2,
            JTextField celular, JTextField ocupacion, JTextField horas, String curp) {
        conectar();
        String cad = "Select primNombE,seguNombE,apPatE,apMatE,celular,ocupacion,hrsTrab from empleado " + "where CURPE=" + "'" + curp + "'";
        try {
            PreparedStatement pSt = oConexion.prepareStatement(cad);
            ResultSet rS = pSt.executeQuery();
            while (rS.next()) {
                nom1.setText(rS.getString(1));
                nom2.setText(rS.getString(2));
                ape1.setText(rS.getString(3));
                ape2.setText(rS.getString(4));
                celular.setText(String.valueOf(rS.getInt(5)));
                ocupacion.setText(rS.getString(6));
                horas.setText(String.valueOf(rS.getInt(7)));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
        desconectarse();
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////7777777
    //////////////////////////////////////////////parte de provedores
    public void AltaProvedorAprobado(String RFCPA, String primNombPA, String seguNombPA, String apPatPA, String apMatPA) {
        conectar();
        String cadena = "INSERT INTO proveedorAprobado(RFCPA,primNombPA,seguNombPA,apPatPA,apMatPA)values(?,?,?,?,?)";
        try {
            PreparedStatement pSt = oConexion.prepareStatement(cadena);
            pSt.setString(1, RFCPA);
            pSt.setString(2, primNombPA);
            pSt.setString(3, seguNombPA);
            pSt.setString(4, apPatPA);
            pSt.setString(5, apMatPA);
            pSt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de alta" + ex.getMessage());
        }
    }

    public void eliminarProvAprobado(String RFCPA) {
        conectar();
        String cad = "DELETE FROM proveedorAprobado WHERE RFCPA = '" + RFCPA + "'";
        try {
            PreparedStatement pS = oConexion.prepareStatement(cad);
            pS.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error " + ex);
        }
        desconectarse();
    }

    public void mostrarProvAprovado(JTable tabla) {
        conectar();
        try {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            Statement sT = (Statement) oConexion.createStatement();
            ResultSet rS = sT.executeQuery("Select * from proveedorAprobado");
            Object[] arreglo = new Object[5];
            while (rS.next()) {
                arreglo[0] = rS.getString(1);
                arreglo[1] = rS.getString(2);
                arreglo[2] = rS.getString(3);
                arreglo[3] = rS.getString(4);
                arreglo[4] = rS.getString(5);

                modelo.addRow(arreglo);
            }
            tabla.setModel(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos.");
        }
        desconectarse();
    }

    public void consultaProvAprobado(JComboBox combo) {
        conectar();
        try {
            PreparedStatement pSt = oConexion.prepareStatement("Select RFCPA from proveedorAprobado");
            ResultSet rS = pSt.executeQuery();
            while (rS.next()) {
                combo.addItem(rS.getString(1));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
        desconectarse();
        
    }

     public void datosPA(JTextField nom1, JTextField nom2, JTextField ape1, JTextField ape2,
    String rfc) {
        conectar();
        String cad = "Select primNombPA,seguNombPA,apPatPA,apMatPA from proveedorAprobado " + "where RFCPA=" + "'" + rfc + "'";
        try {
            PreparedStatement pSt = oConexion.prepareStatement(cad);
            ResultSet rS = pSt.executeQuery();
            while (rS.next()) {
                nom1.setText(rS.getString(1));
                nom2.setText(rS.getString(2));
                ape1.setText(rS.getString(3));
                ape2.setText(rS.getString(4));
             
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
        desconectarse();
    }
     
     public void modificarPA(String RFCPA, String primNombPA, String seguNombPA, String apPatPA, String apMatPA) {
        conectar();

        String cad = "Update proveedorAprobado Set primNombPA='" + primNombPA + "',seguNombPA='" + seguNombPA + "',apPatPA='" + apPatPA + "',apMatPA='" + apMatPA
             + "'WHERE RFCPA='" + RFCPA + "'";
        try {
            PreparedStatement pS = oConexion.prepareStatement(cad);
            pS.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        desconectarse();

    }
 
     //Bebidas
     public void AltaBebida(int claveB, String nombreB, String tamaño, String tipoDeLeche, String tipoDeAzucar,
                                String ingredientes, String formPreparacion, String rfcCliente, String curpEmp) {
        conectar();
        String cadena = "INSERT INTO bebida(claveB, nombreB, tamaño, tipoDeLeche, tipoDeAzucar, ingredientes, formPreparacion, rfcCliente, curpEmp)values(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pSt = oConexion.prepareStatement(cadena);
            pSt.setInt(1, claveB);
            pSt.setString(2, nombreB);
            pSt.setString(3, tamaño);
            pSt.setString(4, tipoDeLeche);
            pSt.setString(5, tipoDeAzucar);
            pSt.setString(6, ingredientes);
            pSt.setString(7, formPreparacion);
            pSt.setString(8, rfcCliente);
            pSt.setString(9, curpEmp);
            pSt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de alta " + ex.toString());
        }
    }
     
     public void bajaBebida(int claveB){
         conectar();
        String cad = "DELETE FROM bebida WHERE claveB = " + claveB;
        try {
            PreparedStatement pS = oConexion.prepareStatement(cad);
            pS.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error " + ex);
        }
        desconectarse();

     }
     
     public void consultaBebida(JComboBox combo) {
        conectar();
        try {
            PreparedStatement pSt = oConexion.prepareStatement("Select claveB from bebida");
            ResultSet rS = pSt.executeQuery();
            while (rS.next()) {
                combo.addItem(rS.getString(1));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
        desconectarse();
        
    }

     public void mostrarBebida(JTable tabla){
         conectar();
        try {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            Statement sT = (Statement) oConexion.createStatement();
            ResultSet rS = sT.executeQuery("Select * from bebida");
            Object[] arreglo = new Object[9];
            while (rS.next()) {
                arreglo[0] = rS.getInt(1);
                arreglo[1] = rS.getString(2);
                arreglo[2] = rS.getString(3);
                arreglo[3] = rS.getString(4);
                arreglo[4] = rS.getString(5);
                arreglo[5] = rS.getString(6);
                arreglo[6] = rS.getString(7);
                arreglo[7] = rS.getString(8);
                arreglo[8] = rS.getString(9);

                modelo.addRow(arreglo);
            }
            tabla.setModel(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos.");
        }
        desconectarse();
     }

     
}
