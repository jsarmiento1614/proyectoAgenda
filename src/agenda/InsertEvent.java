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
         System.out.println("Ubicación del Eventon:");
         System.out.print(" ");
         Ubicacion=teclado.nextLine();
         System.out.println("Inicio del Evento:\t\t\t\t\t\t\tFormato> 00:00:00");
         System.out.print(" ");
         inicio=teclado.nextLine();
         System.out.println("Fin del Evento:\t\t\t\t\t\t\t\tFormato> 00:00:00");
         System.out.print(" ");
         Fin=teclado.nextLine();
         Querys.IsertEvento(IdUser,email,fecha, tEvento, dEvento, Ubicacion, inicio, Fin);
    }
    public void NotificarContact(String email){
       System.out.print(" ");
       String resp=teclado.nextLine();
       if("S".equalsIgnoreCase(resp)){
          System.out.println("llamar Clase enviar correo"); 
       }else{
          //Regreso a la clase perfil.
          System.out.println();
          Perfil callPerfil=new Perfil();
          callPerfil.ShowPerfilUser(email);
       }
    }

   

   
}
