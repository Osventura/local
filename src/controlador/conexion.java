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
/**
 *
 * @author roger
 */
public class conexion {
    
    
    public boolean conexionInsert(){
        return true;
        
    }
    public boolean insertarPostre(String nombre, String valor ) {
        Connection conexion=null;
        Statement sentencia=null;      
    String url="jdbc:postgresql://localhost:5432/postre";
    String password="postgres";
    boolean respuesta =false;
    try {
            Class.forName("org.postgresql.Driver");
            conexion=DriverManager.getConnection(url,"postgres", password);
            sentencia=conexion.createStatement();
            if(conexion!=null){
                int z = 0;
                if(nombre!=null&&valor!=null){
                    if(!postreValido(nombre))   
                   z=sentencia.executeUpdate("INSERT INTO postre (nombrep,valor) VALUES('"+nombre+"',"+valor+")");
                }
                if(z==1){ respuesta=true;  }
            }
        } 
        catch (ClassNotFoundException | SQLException e) {
                System.out.println("problema de conexion");
            }
            return respuesta;
    }
   
   boolean postreValido(String nombre){
        boolean resultado =false;
        Connection conected = null;
      Statement stmt = null;    
      try {
         Class.forName("org.postgresql.Driver");
         conected = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postre", "postgres", "postgres");
         conected.setAutoCommit(false);
         stmt = conected.createStatement();
         ResultSet respBD = stmt.executeQuery( "SELECT nombrep FROM public.postre WHERE nombrep='"+nombre+"' ;" );
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
}
