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
public class SelectContact {
    public void Contactos(String email){
        Scanner teclado =new Scanner(System.in);
        String correo = null;
        String asunto, descripcion;
        String [] arrayContact;
        int cantContact=0;
        int contador=0;      
        System.out.println("____________________________________________________________________________________________");
        System.out.println("-----------------------------------Comunica a tus contactos---------------------------------\n");  
        System.out.println("A cuantos contactos quieres enviar notificación");
        System.out.print(" ");
        cantContact=teclado.nextInt();
        System.out.println("-----------------------------------------------");
        arrayContact=new String[cantContact];
        teclado.nextLine();
          for(int i=0;i<arrayContact.length;i++){
              contador++;
              System.out.println("Ingresa tu Contacto #"+contador);
              System.out.print(" ");
              correo=teclado.nextLine();
              arrayContact[i]=correo;  
          }
          System.out.println("-----------------------------------------------");
          System.out.println("Ingresa el Asunto");
          System.out.print(" ");
          asunto=teclado.nextLine();
          System.out.println("Describe el mensaje ha enviar");
          System.out.print(" ");
          descripcion=teclado.nextLine();
          System.out.println("-------------------------------Espera, Conectando con el Servidor---------------------------");
          SendMail callSendMail = new SendMail();
          callSendMail.enviar(email, arrayContact, asunto, descripcion);          
    }
}
