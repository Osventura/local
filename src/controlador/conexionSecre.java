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
 * @author RICHARD VENTURA
 */
public class conexionSecre{
    
    Connection conect = null;

    
   
   public boolean insertarSecretaria(String nombre,String apellidos,String ci ,String celular, String direccion, String email ) {
        Connection coneccion=null;
        Statement sentencia=null;      
    String url="jdbc:postgresql://localhost:5433/evento";
    String password="richard";
    boolean respuesta =false;
    try {
            Class.forName("org.postgresql.Driver");
            coneccion=DriverManager.getConnection(url,"postgres", password);
            sentencia=coneccion.createStatement();
            if(coneccion!=null){
                int z = 0;
                if(nombre!=null&&apellidos!=null){
                    if(!SecretariaValido(nombre))   
                   z=sentencia.executeUpdate("INSERT INTO secretaria(id_admin,nombre_secre,apellido_secre,ci_secre, celular_secre,direccion_secre,email_secre) "
                           + "                  VALUES("+1+",'"+nombre+"','"+apellidos+"','"+ci+"','"+celular+"','"+direccion+"','"+email+"')");
                }
                if(z==1){ respuesta=true;  }
            }
        } 
        catch (ClassNotFoundException | SQLException e) {
                System.out.println("problema de conexion");
            }
            return respuesta;
    }
   
   boolean SecretariaValido(String nombre){
        boolean resultado =false;
        Connection conected = null;
      Statement stmt = null;    
      try {
         Class.forName("org.postgresql.Driver");
         conected = DriverManager.getConnection("jdbc:postgresql://localhost:5433/evento", "postgres", "richard");
         conected.setAutoCommit(false);
         stmt = conected.createStatement();
         ResultSet respBD = stmt.executeQuery( "SELECT nombre_secre FROM public.secretaria WHERE nombre_secre='"+nombre+"' ;" );
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
   
   public ResultSet eliminarconferencista(String ci){
       
      ResultSet respuesta = null;
        Connection conectado = null;
      Statement estado = null;    
      try {
         Class.forName("org.postgresql.Driver");
         conectado = DriverManager.getConnection("jdbc:postgresql://localhost:5432/evento", "postgres", "postgres");
         conectado.setAutoCommit(false);
         estado = conectado.createStatement();
         respuesta = estado.executeQuery( "select nombre_confe, apellido_confe, profesion_confe,ci_confe\n" +
                                        "from conferencista\n" +
                                    "where ci_confe='"+ci+"';" );
      
 
         
         
         
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
        return respuesta;
    }
   
   
   
     public Connection connectados() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost/evento", "postgres", "postgres");
    }
    public int eliminarConfere(String ci) {
        String SQL = "DELETE FROM conferencia WHERE ci_confe = '"+ci+"'; DELETE FROM conferencista WHERE ci_confe = '"+ci+"';";
 
        int z = 0;
 
        try (Connection conn = connectados(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            z = pstmt.executeUpdate();
 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return z;
    }
   
   
   
   public Connection conexionn()
    {
      try {
             
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error "+e);
        }
        return conect;
}
}
