/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.Random;

/**
 *
 * @author Melanie
 */
public class Rand {
    
    private String[] nombres = {"Angel", "Elias", "Jose", "Eduardo", "Maria", "Luisa", "Carmen", "Isaac", "Alexis", "Salvador", "Victor", "Rodrigo", "Martin", "Manuel", "Luna", "Mariana"};
    private String[] apellidos = {"Arias", "Alanis", "Bocanegra", "Casa0s", "Casillas", "Dorantes","Flores", "Frias", "Gómez", "Gallardo", "Juarez", "Macias", "Nuñez", "Perez", "Turcios"};
    private String[] calles = {"Calle 1", "Calle 2", "Calle 3", "Calle 4", "Calle 5", "Calle 6", "Calle 7"};
    private String[] colonias = {"Álamos", "Benito Juarez", "Los Cerros", "Las glorias", "La Fuente", "La rosita", "Centro", "El fresno", "El campestre", "Las Dalias"};
    private String[] ciudades = {"Saltillo", "Durango", "Coahuila", "Mexico", "Monterrey", "Sonora", "Lerdo", "Tijuana", "Matamoros", "Piedras Negras"};
    private String[] cadenas = {"0","1","2","3","4","5","6","7","8","9","10","A","B","C","D","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    private String[] fechas = {"2021-01-01","2022-04-05","2019-11-21","2017-07-22","2016-03-30","2021-08-24","2018-07-27","2019-12-25","2018-02-29","2018-09-31",
    "2015-04-19","2020-09-19","2022-02-29","2022-06-24","2020-09-23","2022-09-26","2018-07-29","2019-05-28","2019-01-11"};
    private String[] cafes = {"Capuccino","Americano","Moca","Frappe","Espresso","Macchiato","Ristretto"};
    
     public String nombre(){
     String nomb;
     Random rnd = new Random();
     nomb = nombres[rnd.nextInt(15)];
     return nomb;
     }
      public String cafe(){
     String caf;
     Random rnd = new Random();
     caf = cafes[rnd.nextInt(6)];
     return caf;
     }
      
       public String apellido(){
     String Ap;
     Random rnd = new Random();
     Ap = apellidos[rnd.nextInt(14)];
     return Ap;
     }
       
     public String calle(){
     String ca;
     Random rnd = new Random();
     ca = calles[rnd.nextInt(6)];
     return ca;
     }  
       
      public String colonia(){
     String col;
     Random rnd = new Random();
     col = colonias[rnd.nextInt(9)];
     return col;
     }  
      
      public String ciudad(){
     String cd;
    Random rnd = new Random();
     cd = ciudades[rnd.nextInt(9)];
     return cd;
     }  
      public String fecha(){
     String fc;
    Random rnd = new Random();
     fc = fechas[rnd.nextInt(16)];
     return fc;
     } 
      
      public int numero(){
     Random rnd = new Random();
     int num = rnd.nextInt(100);
     return num;
     }  
      public double costo(){
     Random rnd = new Random();
     double num = rnd.nextInt(1000)+rnd.nextDouble();
     return num;
     }  
      
      public int telefono(){
     Random rnd = new Random();
     int num =871000000+ rnd.nextInt(100000);
     return num;
     }
      
      public String rfc(){
          String rf ="";
     Random rnd = new Random(); 
          for (int i = 0; i < 11; i++) {
              rf = rf+cadenas[rnd.nextInt(36)];
          }
     return rf;
     } 
      
      public String curp(){
          String cr ="";
     Random rnd = new Random(); 
          for (int i = 0; i < 18; i++) {
              cr = cr+cadenas[rnd.nextInt(36)];
          }
     return cr;
     } 
      
}
