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
            fis = new FileInputStream("dbConection.properties");
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
 

    
}
