/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author JSarmiento
 */
public class Menu {
   
   public void header(){
       Calendar calendario = new GregorianCalendar();
       int hora, minutos, segundos;
       hora =calendario.get(Calendar.HOUR_OF_DAY);
       minutos = calendario.get(Calendar.MINUTE);
       segundos = calendario.get(Calendar.SECOND);
       
       System.out.println("********************************************************************************************");
       System.out.println("*                               AGENDA ELECTRÓNICA JSARMIENTO©                             *");    
       System.out.println("*******************************                             ********************************");
       System.out.println("_______________________________________"+ hora + ":" + minutos + ":" + segundos + ""
               + "_____________________________________________");
       System.out.println();
       }
   public void headerIniciarSesion(){
       System.out.println("\t**************");
       System.out.println("\tINICIAR SESIÓN");    
       System.out.println("\t**************");    
   }
    
   public void headerRegistro(){
       System.out.println("\t**************");
       System.out.println("\tCREAR TU CUENTA");    
       System.out.println("\t**************");   
   }
   public void headerPerfil(){
       System.out.println("\t**************");
       System.out.println("\tPERFIL USUARIO");    
       System.out.println("\t**************");  
   }
}
