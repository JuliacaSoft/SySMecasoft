/*
 * Clase de conexión a SQLlite
 * Desarrollado por: Ing. Angel R. Condori Coaquira
 * www.juliacasoft.com - Diciembre 2013
 */

package angeldx.common;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author AngelDX
 */
public class ConectarDB {
  public Connection cn=null;
  public Statement st=null;
  public ResultSet rs=null;  
 
  public Connection conectar() throws Exception{
        try{   
            Class.forName("org.sqlite.JDBC");
            cn = DriverManager.getConnection("jdbc:sqlite:taller.db");
            System.out.println("Opened database successfully");

        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null,"Error 1:"+ex.getMessage());
            cn=null;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error 2:"+ex.getMessage());
            cn=null;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error 3:"+ex.getMessage());
            cn=null;
        }finally{
            return cn;
        }
    }
     
    public ResultSet ejecutarConsulta(String sql) throws Exception{
         st=cn.createStatement();
         rs=st.executeQuery(sql);
         return rs;
     }

     public void ejecutarActualizacion(String sql) throws Exception{
         st=cn.createStatement();
         st.executeUpdate(sql);
     }

     public void desconectar() throws Exception{
         cn.close();
     }
}
