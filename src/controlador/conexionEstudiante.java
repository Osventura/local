/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author roger
 */
public class conexionEstudiante{
    
    Connection conect = null;
    public boolean conexionInsert(){
        return true;
        
    }
    
   
   public boolean insertarEstudiante(String nombre,String apellidos,String ci ,String celular, String email ) {
        Connection coneccion=null;
        Statement sentencia=null;      
    String url="jdbc:postgresql://localhost:5432/evento";
    String password="postgres";
    boolean respuesta =false;
    try {
            Class.forName("org.postgresql.Driver");
            coneccion=DriverManager.getConnection(url,"postgres", password);
            sentencia=coneccion.createStatement();
            if(coneccion!=null){
                int z = 0;
                if(nombre!=null&&apellidos!=null){
                    if(!EstudianteValido(nombre))   
                   z=sentencia.executeUpdate("INSERT INTO estudiante(id_inscripcion,nombre_estu,apellido_estu,ci_estu, celu_estu,email_estu) "
                           + "                  VALUES("+1+",'"+nombre+"','"+apellidos+"','"+ci+"','"+celular+"','"+email+"')");
                }
                if(z==1){ respuesta=true;  }
            }
        } 
        catch (ClassNotFoundException | SQLException e) {
                System.out.println("problema de conexion");
            }
            return respuesta;
    }
   
   boolean EstudianteValido(String nombre){
        boolean resultado =false;
        Connection conected = null;
      Statement stmt = null;    
      try {
         Class.forName("org.postgresql.Driver");
         conected = DriverManager.getConnection("jdbc:postgresql://localhost:5432/evento", "postgres", "postgres");
         conected.setAutoCommit(false);
         stmt = conected.createStatement();
         ResultSet respBD = stmt.executeQuery( "SELECT nombre_estu FROM public.estudiante WHERE nombre_estu='"+nombre+"' ;" );
         if(respBD.next()){
             resultado=true;
         }
         respBD.close();
         stmt.close();
         conected.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
        return resultado;
    }
   
   
   
   public Connection conexionn()
    {
      try {
             
           //Cargamos el Driver MySQL
           //Class.forName("com.mysql.jdbc.Driver");
           //conect = DriverManager.getConnection("jdbc:mysql://localhost/tienda","root","root");
           //JOptionPane.showMessageDialog(null, "conectado");
           //Cargamos el Driver Access
           //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           //Conectar en red base 
           //String strConect = "jdbc:odbc:Driver=Microsoft Access Driver (*.mdb);DBQ=//servidor/bd_cw/cw.mdb";
           //Conectar Localmente
           //String strConect = "jdbc:odbc:Driver=Microsoft Access Driver (*.mdb);DBQ=D:/cwnetbeans/cw.mdb";
          //conect = DriverManager.getConnection(strConect,"",""); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error "+e);
        }
        return conect;
}
}
