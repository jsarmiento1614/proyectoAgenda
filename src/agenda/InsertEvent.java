/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author JSarmiento
 */
public class InsertEvent{
    Calendar calendario = new GregorianCalendar();
    Scanner teclado=new Scanner(System.in);
    String fecha, tEvento,dEvento,Ubicacion,inicio,Fin;
    public void InsertEvent(String IdUser, String email) {
        InsertEvent callInsertEvent =new InsertEvent();
        int exitDo=0;
        do{
         System.out.println("Fecha del Evento:\t\t\t\t\tFormato> ---AÑO-MES-DIA---1999-12-31");
         System.out.print(" ");
         fecha=teclado.nextLine();
         if(callInsertEvent.validateFormatDate(fecha)==false){
             System.out.println("La fecha ingresada no cumple el formato o  es una fecha pasada");
         }else{
             break;
         }
        }while(exitDo!=1);
         System.out.println("Titulo del evento:");
         System.out.print(" ");
         tEvento=teclado.nextLine();
         System.out.println("Detalles del evento:");
         System.out.print(" ");
         dEvento=teclado.nextLine();
         System.out.println("Ubicación del Evento:");
         System.out.print(" ");
         Ubicacion=teclado.nextLine();
         do{
         System.out.println("Hora Inicio del Evento:\t\t\t\t\t\t\tFormato>      00:00");
         System.out.print(" ");
         inicio=teclado.nextLine();
         if(callInsertEvent.validateFormatTime(inicio)==false){
             System.out.println("La Hora ingresada no cumple el formato");
         }else{
             break;
         }
         }while(exitDo!=1);
         do{
         System.out.println("Hora Fin del Evento:\t\t\t\t\t\t\tFormato>      00:00");
         System.out.print(" ");
         Fin=teclado.nextLine();
         if(callInsertEvent.validateFormatTime(Fin)==false){
             System.out.println("La Hora ingresada no cumple el formato");
         }else{
             break;
         } 
         }while(exitDo!=1);
         System.out.println();
         System.out.println("\n-----------------------------------INFORMACÓN INTRODUCIDA-----------------------------------");
         System.out.print("|----Fecha del Evento: ");
         System.out.println("\t"+"\t"+fecha);
         System.out.print("|----Titulo del evento: ");
         System.out.println("\t"+tEvento);
         System.out.print("|----Detalles del evento: ");
         System.out.println("\t"+dEvento);
         System.out.print("|----Ubicación del Evento: ");
         System.out.println("\t"+Ubicacion);
         System.out.print("|----Inicio del Evento: ");
         System.out.println("\t"+inicio);
         System.out.print("|----Fin del Evento: ");
         System.out.println("\t"+"\t"+Fin);
         System.out.println("____________________________________________________________________________________________");
         System.out.println("\n--------------------¿Su información es correcta?, Desea Registrarla.(S/N)-------------------");
         System.out.println("____________________________________________________________________________________________");
         System.out.print(" ");
         String correctInfo=teclado.nextLine();
         if("S".equalsIgnoreCase(correctInfo)){
            Querys.IsertEvento(IdUser,email,fecha, tEvento, dEvento, Ubicacion, inicio, Fin);
            }else{
                System.out.println("____________________________________________________________________________________________");
                System.out.println("\n-------------------------------CANCELANDO REGISTRO DE EVENTOS-------------------------------");
                System.out.println("____________________________________________________________________________________________");
                Perfil callPerfil=new Perfil();
                callPerfil.mainPerfil(IdUser, email);
         } 
    }
    public void NotificarContact(String email){
     int salir=0;
     do{
       System.out.print(" ");
       String resp=teclado.nextLine();
       if("S".equalsIgnoreCase(resp)){
          SelectContact callSelectContact = new SelectContact();
          callSelectContact.Contactos(email);
       }else if("N".equalsIgnoreCase(resp)){
          //Regreso a la clase perfil.
          System.out.println();
          Perfil callPerfil=new Perfil();
          callPerfil.ShowPerfilUser(email);
       }else{
           System.out.println("Verifica tu respuesta");
           System.out.println("*****Vuelve a Introducir******");
       }
     }while(salir!=1);
    }
    public boolean validateFormatDate(String fecha){
         boolean inputValidate=true;
         inputValidate=fecha.matches("^\\d{4}-\\d{2}-\\d{2}$");
         if(inputValidate){
            int anio =calendario.get(Calendar.YEAR);
            int mes = calendario.get(Calendar.MONTH);
            int dias = calendario.get(Calendar.DAY_OF_MONTH); 
            CharSequence csYear= fecha.subSequence(0, 4);
            CharSequence csMes= fecha.subSequence(5,7);
            CharSequence csDia= fecha.subSequence(8,10);
            int Cyear=Integer.parseInt((String) csYear);
            int Cmes=Integer.parseInt((String) csMes);
            int Cdia=Integer.parseInt((String) csDia);
            if(Cyear<anio || Cmes<mes || Cmes >12 || Cdia<dias || Cdia>31){
               return false; 
            }else{
               return true;
            }
         }else{
           return false;    
         }
    }
    
    public boolean validateFormatTime(String hInicioFIn){
        boolean inputValidate=true;
        inputValidate=hInicioFIn.matches("^\\d{2}:\\d{2}$");
        if(inputValidate){
            CharSequence csHora= hInicioFIn.subSequence(0, 2);
            CharSequence csMinutes= hInicioFIn.subSequence(3, 5);
            int CHora=Integer.parseInt((String) csHora);
            int CMinutes=Integer.parseInt((String) csMinutes);
            if(CHora>23 || CMinutes>59){
               return false; 
            }else{
               return true;
            }
        }else{
           return false;    
        }
        
    }

   

   
}
