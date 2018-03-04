/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

/**
 *
 * @author JSarmiento
 */
public class Querys {
    //Clase para Consultar el correo electronico.
    public static void queryEmail(String email){
        DataSource ds = null;
        ds = Conexion.getMySQLDataSource();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        //Consultar info de la base de datos.
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from usuarios");
           
            while (rs.next()) {         
                if(rs.getString("email").equals(email)){
                  System.out.println("-----------------------------correo encontrado Satisfactoriamente---------------------------");
                  System.out.println("____________________________________________________________________________________________");
                  Perfil callPerfil =new Perfil();
                  callPerfil.ShowPerfilUser(email);
                  break;
                }else if (rs.isLast()){
                   System.out.println("Usted no se encuentra registrado en nuestra Base de Datos."); 
                }  
            }
        } catch (SQLException e) {
            System.out.println("Ha sucedido un error al insertar la informacion... " + e); 
        } finally {
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
               System.out.println("Ha sucedido un error en cerrar la conexiones de la db... " + e); 
            }
        }
    }
    //Clase para insertar los datos de registro en la BD.
    public static void IsertRegistro(String email, String nombre){
        DataSource ds = null;
        ds = Conexion.getMySQLDataSource();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        //Consultar info de la base de datos.
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from usuarios");
            int IdUser=0;
            while (rs.next()) {
                IdUser= rs.getInt("IdUser");
            }
            String query = " insert into usuarios (IdUser, nombre, email)" + " values (?,?,?) ";
            PreparedStatement preStmt  = con.prepareStatement(query);
            IdUser++;
            preStmt.setInt(1, IdUser );
            preStmt.setString(2, nombre);
            preStmt.setString(3, email);
            preStmt.execute();
            System.out.println("------------------------------\n"
                    + "Te has registrado Correctamente...\n"
                    + "Ya puedes INICIAR SESION con tu Correo Electronico.\n"
                    + "------------------------------\n");
            Agenda callAgenda =new Agenda();
            callAgenda.Login();
                   
            
        } catch (SQLException e) {
            System.out.println("Ha sucedido un error al insertar la informacion... " + e); 
        } finally {
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
               System.out.println("Ha sucedido un error en cerrar la conexiones de la db... " + e); 
            }
        }
    }
    
    
    
    
    //Clase sacar de la base de datos Nombre y Email.
    public static String callPerfil(String email){
        DataSource ds = null;
        ds = Conexion.getMySQLDataSource();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String w = "";
        StringBuilder tabla = new StringBuilder(w);
        //Consultar info de la base de datos.
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            String query = "select * from usuarios where email=?";
            PreparedStatement preStmt  = con.prepareStatement(query);
            preStmt.setString(1, email);
            rs = preStmt.executeQuery();
            tabla.append("-------------------------------\n");
            tabla.append("IdUser|\tNombre|\tCorreo\n");
            String idUser="";
            while (rs.next()){
                tabla.append(rs.getInt(1)).append("\t");
                tabla.append(rs.getString(2)).append("\t");
                tabla.append(rs.getString(3)).append("\n");
                tabla.append("-------------------------------");
                idUser=rs.getString(1);
            }
            System.out.println(tabla.toString());
            Perfil callPerfil=new Perfil();
            callPerfil.mainPerfil(idUser, email);
            return tabla.toString();   
            
        } catch (SQLException e) {
            System.out.println("Ha sucedido un error al insertar la informacion... " + e); 
        } finally {
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
               System.out.println("Ha sucedido un error en cerrar la conexiones de la db... " + e); 
            }
        }
       return tabla.toString();
    }
    
     //Clase para insertar los datos del evento.
    public static void IsertEvento(String IdUser,String email, String fecha, String tEvento,String dEvento,String Ubicacion,String inicio,String Fin){
        int IdUse = Integer.parseInt(IdUser);
        DataSource ds = null;
        ds = Conexion.getMySQLDataSource();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        //Consultar info de la base de datos.
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from eventos");
            int IdEvent=0;
            while (rs.next()) {
                IdEvent= rs.getInt("IdEvent");
            }
            String query = " insert into eventos (IdEvent,IdUser, fecha, Titulo,Detalles,Ubicacion,Inicio,Fin)"
                    + "" + " values (?,?,?,?,?,?,?,?) ";
            PreparedStatement preStmt  = con.prepareStatement(query);
            IdEvent++;
            preStmt.setInt(1, IdEvent);
            preStmt.setInt(2, IdUse);
            preStmt.setString(3, fecha);
            preStmt.setString(4, tEvento);
            preStmt.setInt(5, IdEvent );
            preStmt.setString(6, Ubicacion);
            preStmt.setString(7, inicio);
            preStmt.setString(8, Fin);
            preStmt.execute();
            System.out.println("____________________________________________________________________________________________"); 
            System.out.println("\n--------------------------Tu Evento se ha registrado Correctamente--------------------------");
            System.out.println("\t\t\tDesea Notificar este evento a tus contactos (S/N)");
            System.out.println("____________________________________________________________________________________________");
            
           //String IdUsers= Integer.toString(IdUse);
            InsertEvent callInsertEvent=new InsertEvent();
            callInsertEvent.NotificarContact(email);
            Agenda callAgenda =new Agenda();
            callAgenda.Login();
                   
            
        } catch (SQLException e) {
            System.out.println("Ha sucedido un error al insertar la informacion... " + e); 
        } finally {
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
               System.out.println("Ha sucedido un error en cerrar la conexiones de la db... " + e); 
            }
        }
    }
    
    //Clase para consultar los eventos.
    public static String callFirsTreeEvents(String IdUser, String email){
        DataSource ds = null;
        ds = Conexion.getMySQLDataSource();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String w = "";
        StringBuilder tabla = new StringBuilder(w);
        //Consultar info de la base de datos.
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            String query = "select * from eventos where IdUser=? ORDER BY fecha DESC LIMIT 0,3";
            PreparedStatement preStmt  = con.prepareStatement(query);
            preStmt.setString(1, IdUser);
            rs = preStmt.executeQuery();
            System.out.println("____________________________________________________________________________________________");
            tabla.append("Fecha|\t\tInicio|\t\tFin|\t\tNombre del Evento|\n");
            String idUser="";
            while (rs.next()){
                tabla.append(rs.getString(3)).append("\t");
                tabla.append(rs.getString(7)).append("\t");
                tabla.append(rs.getString(8)).append("\t");
                tabla.append(rs.getString(4)).append("\n");
            }
            System.out.print(tabla.toString());
            System.out.println("____________________________________________________________________________________________");
            Perfil callPerfil=new Perfil();
            callPerfil.ShowPerfilUser(email);
            return tabla.toString();   
            
        } catch (SQLException e) {
            System.out.println("Ha sucedido un error al insertar la informacion... " + e); 
        } finally {
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
               System.out.println("Ha sucedido un error en cerrar la conexiones de la db... " + e); 
            }
        }
       return tabla.toString();
    }

   
}
