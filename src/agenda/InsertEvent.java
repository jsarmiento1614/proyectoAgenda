/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.util.Scanner;

/**
 *
 * @author JSarmiento
 */
public class InsertEvent {
    Scanner teclado=new Scanner(System.in);
    String fecha, tEvento,dEvento,Ubicacion,inicio,Fin;
    public void InsertEvent(String IdUser, String email) {
         System.out.println("Fecha del Evento:\t\t\t\t\t\t\tFormato> 2010-10-10");
         System.out.print(" ");
         fecha=teclado.nextLine();
         System.out.println("Titulo del evento:");
         System.out.print(" ");
         tEvento=teclado.nextLine();
         System.out.println("Detalles del evento:");
         System.out.print(" ");
         dEvento=teclado.nextLine();
         System.out.println("Ubicación del Evento:");
         System.out.print(" ");
         Ubicacion=teclado.nextLine();
         System.out.println("Hora Inicio del Evento:\t\t\t\t\t\t\tFormato>   00:00:00");
         System.out.print(" ");
         inicio=teclado.nextLine();
         System.out.println("Hora Fin del Evento:\t\t\t\t\t\t\tFormato>   00:00:00");
         System.out.print(" ");
         Fin=teclado.nextLine();
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
         String correctInfo=teclado.nextLine();
         if("S".equalsIgnoreCase(correctInfo)){
            Querys.IsertEvento(IdUser,email,fecha, tEvento, dEvento, Ubicacion, inicio, Fin);
            }else{
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

   

   
}
