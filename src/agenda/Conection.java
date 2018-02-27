import agenda.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;  

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package sqlliteempleados;


/**
 *
 * @author diego
 */
public class Conection {
    private DataSource ds;
    private Connection conn;
    
    public Conection() {
        ds = Conexion.getMySQLDataSource();
        conn = null;
    }
    
    private Connection connectDB(){
        try {
            conn = this.ds.getConnection();
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error en la conexion");
        }
        return conn;
    }
    
    private void disconnectDB(Connection conn){
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error en la desconexion");
        }
    }
    // https://pastebin.com/9nQGtAWN
    
    public String getSueldosTablaEmpleados(int email){
        
        conn = connectDB();
        String query = " select * from usuarios where email = ?";
        PreparedStatement consulta = null;
        ResultSet resultadotabla = null;
        String w = "";
        StringBuilder tabla = new StringBuilder(w);
        
        try{
            consulta = conn.prepareStatement(query);
            consulta.setDouble(1, email);
            resultadotabla = consulta.executeQuery();
            tabla.append("IdUser|\tNombre|\tCorreo\n");
            while (resultadotabla.next()){
                tabla.append(resultadotabla.getInt(1)).append("\t");
                tabla.append(resultadotabla.getString(2)).append("\t");
                tabla.append(resultadotabla.getString(3)).append("\t");
            }
            return tabla.toString();
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error en la desconexion");
        }
        return tabla.toString();
    }
   /* 
    public String getInformacionTablaEmpleados(){
        conn = connectDB();
        String query = " select * from Empleados";
        PreparedStatement consulta = null;
        ResultSet resultadotabla = null;
        String w = "";
        StringBuilder tabla = new StringBuilder(w);
        
        try{
            consulta = conn.prepareStatement(query);
            resultadotabla = consulta.executeQuery();
            tabla.append("Codigo|\tNombre|\tEstado|\tSueldo\n");
            while (resultadotabla.next()){
                tabla.append(resultadotabla.getInt(1)).append("\t");
                tabla.append(resultadotabla.getString(2)).append("\t");
                tabla.append(resultadotabla.getString(3)).append("\t");
                tabla.append(resultadotabla.getDouble(4)).append("\n");
            }
            return tabla.toString();
        } catch (SQLException ex) {
            Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tabla.toString();
    }
    
    public int insertEmpleado(int codigo, String nombre, String estadocivil, double sueldo){
        conn = connectDB();
        String query = " insert into Empleados +"
                + "(codigo, nombre, estadocivil, sueldo)" + 
                " values (?,?,?,?) ";
        PreparedStatement preStmt =null;
        try {
            preStmt = conn.prepareStatement(query);
            preStmt.setInt(1, codigo);
            preStmt.setString(2, nombre);
            preStmt.setString(3, estadocivil);
            preStmt.setDouble(4, sueldo);
            boolean result = preStmt.execute();
            if(result){
                return 0;
            }
            else{
                return 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                if (preStmt != null) {
                    preStmt.close();
                }
                if (conn != null) {
                    disconnectDB(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
    */
    
}
