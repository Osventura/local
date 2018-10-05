

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
public class conexionHorario{
    
    Connection conect = null;

   public ResultSet cronograma(){
       
      ResultSet respBD = null;
        Connection conected = null;
      Statement stmt = null;    
      try {
         Class.forName("org.postgresql.Driver");
         conected = DriverManager.getConnection("jdbc:postgresql://localhost:5432/evento", "postgres", "postgres");
         conected.setAutoCommit(false);
         stmt = conected.createStatement();
         respBD = stmt.executeQuery( "select hora, nombre_confe,apellido_confe,tema\n" +
                                        "from conferencia,conferencista\n" +
                                    "where conferencista.ci_confe=conferencia.ci_confe;" );

      } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
        return respBD;
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
