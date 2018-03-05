/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

/**
 *
 * @author JSarmiento
 */
import java.util.Scanner;
public class Registro {
   public void registroUser(){
        int exit=0;
        //instancio el menu
        Agenda callRegis = new Agenda(); 
        Menu callMenu = new Menu();
        ValidarMail callValidator = new ValidarMail();
        do{ 
            System.out.println("____________________________________________________________________________________________"); 
            System.out.println("\n-----------------Agenda-Jsarmiento, Registrate a Continuacion , ¡Es Gratis!-----------------");
            System.out.println("____________________________________________________________________________________________"); 
            String nombre="";
            String email="";
            callMenu.headerRegistro();
            Scanner teclado=new Scanner(System.in);
            //teclado.nextLine();
            System.out.println("Ingresa tu nombre:\t\t\t\t\t\t   Ingrese (C) para Cancelar"); 
            System.out.print(" ");
            nombre=teclado.nextLine();
            if("C".equalsIgnoreCase(nombre)||"C".equalsIgnoreCase(email)){
               Agenda callAgenda=new Agenda();
               callAgenda.Login();
            }
            System.out.println("Ingresa tu correo:");
            System.out.print(" ");
            email=teclado.nextLine();
            
            
            callValidator.validarRegistro(email, nombre);
            callRegis.dRegistro();
        }while(exit!=1);
       
   }
    
}
