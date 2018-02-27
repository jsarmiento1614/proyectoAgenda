    /*
 * Esta es la clase que me permitira llamar la conexion que se encuentra en el archivo db.conecction.
 */
package agenda;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.sql.DataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

/**
 *
 * @author JSarmiento
 */
public class Conexion {
    public static DataSource getMySQLDataSource() {
        Properties DConec = new Properties();
        FileInputStream fis = null;
        MysqlDataSource mysqlDS = null;
        try {
            fis = new FileInputStream("db.properties");
            DConec.load(fis);
            mysqlDS = new MysqlDataSource();
            mysqlDS.setURL(DConec.getProperty("MYSQL_DB_URL"));
            mysqlDS.setUser(DConec.getProperty("MYSQL_DB_USERNAME"));
            mysqlDS.setPassword(DConec.getProperty("MYSQL_DB_PASSWORD"));
        } catch (IOException e) {
            System.out.println("Error al conectar... " + e); 
        }
        return mysqlDS;
    }
    ////////////////////
    
    ////////////////////////////////
   /* DataSource ds = null;
    Connection con = null;
    public  void testDataSource () {//le quite lo publico y lo estatuco.
        
        ds = Conexion.getMySQLDataSource();
        
        try {
            con = ds.getConnection();      
        } catch (SQLException e) {
            System.out.println("Ha sucedido un error... " + e); 
        } 
    }
    /////////////////////////////////////
    private void queryEmail(){
        testDataSource();
        Statement stmt = null;
        ResultSet rs = null; 
        try{
        stmt = con.createStatement();         
            rs = stmt.executeQuery("select * from usuarios");
            int IdUser=0;
            while (rs.next()) {
                System.out.println("IdUser =" + rs.getInt("IdUser") + ", Nombre=" + rs.getString("nombre") + " email= " +rs.getString("email"));
                IdUser= rs.getInt("IdUser");
            }
           
            String query = " insert into usuarios (IdUser, nombre, email)" + " values (?,?,?) ";
            PreparedStatement preStmt  = con.prepareStatement(query);
            IdUser++;
            preStmt.setInt(1, IdUser );
            preStmt.setString(2, "jesus sarmiento");
            preStmt.setString(3, "jesus@gmail.com");
            preStmt.execute();
        }catch(SQLException e){
            
        }finally {
            try {
                 if (rs != null) {
                rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Ha sucedido un error... " + e); 
            }
        }
        
    }*/
    
}
