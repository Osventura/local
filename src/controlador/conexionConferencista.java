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
public class conexionConferencista{
    
    Connection conect = null;
    public boolean conexionInsert(){
        return true;
        
    }
    
   
   public boolean insertarConferencista(String nombre,String apellidos,String celular ,String email, String profesion, String ci ) {
        Connection coneccion=null;
        Statement sentencia=null;      
    String url="jdbc:postgresql://localhost:5432/evento";
    String password="ventura";
    boolean respuesta =false;
    try {
            Class.forName("org.postgresql.Driver");
            coneccion=DriverManager.getConnection(url,"postgres", password);
            sentencia=coneccion.createStatement();
            if(coneccion!=null){
                int z = 0;
                if(nombre!=null&&apellidos!=null){
                    if(!ConferencistaValido(nombre))   
                   z=sentencia.executeUpdate("INSERT INTO conferencista(nombre_confe,apellido_confe,celular_confe, email_confe,profesion_confe,ci_confe) "
                           + "                  VALUES('"+nombre+"','"+apellidos+"','"+celular+"','"+email+"','"+profesion+"','"+ci+"')");
                }
                if(z==1){ respuesta=true;  }
            }
        } 
        catch (ClassNotFoundException | SQLException e) {
                System.out.println("problema de conexion");
            }
            return respuesta;
    }
   
   boolean ConferencistaValido(String nombre){
        boolean resultado =false;
        Connection conected = null;
      Statement stmt = null;    
      try {
         Class.forName("org.postgresql.Driver");
         conected = DriverManager.getConnection("jdbc:postgresql://localhost:5432/evento", "postgres", "ventura");
         conected.setAutoCommit(false);
         stmt = conected.createStatement();
         ResultSet respBD = stmt.executeQuery( "SELECT nombre_confe FROM public.conferencista WHERE nombre_confe='"+nombre+"' ;" );
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

   // public conexionConferencista() {
     //       Connection conect = null;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    //}

//}