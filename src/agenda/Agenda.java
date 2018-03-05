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
public class Agenda {

    /**
     * @param args the command line arguments
     */
    Scanner teclado=new Scanner(System.in);
    
    public static void main(String[] args) {
        // TODO code application logic here
        String IdUser="1";
        String email="jesus@gmail.com";
        Querys.TriggersEvent(IdUser, email);
        
        Menu callMenu = new Menu();
        Agenda callLogin = new Agenda();     
        callMenu.header();
        //call Inicio de sesion. 
        callLogin.Login();   
        
    }
   
    public void Login(){
        String correo;
        Menu callMenu = new Menu();
        Agenda callRegis = new Agenda();  
        int exit=0;
        do{
            callMenu.headerIniciarSesion();
            System.out.println("Ingrese Correo Electrónico:\t\t\t\t\tIngresa(R) para registrarte.");
            System.out.print(" ");
            correo=teclado.nextLine();
            if("R".equalsIgnoreCase(correo)){
               Registro callregistro =new Registro();
               callregistro.registroUser();
            }
            //System.out.println("____________________________________________________________________________________________\n");
            ValidarMail callValidator = new ValidarMail();
            callValidator.validar(correo);
            callRegis.dRegistro();
        }while(exit!=1); 
     
   }
   public void dRegistro(){ 
        System.out.print(" ");
        String rsp= teclado.next();
        if (rsp.equalsIgnoreCase("s")){
            teclado.nextLine();//limpiare la cache.
            Registro callregistro =new Registro();
            callregistro.registroUser();
            //break;
        }else if (rsp.equalsIgnoreCase("n")){
            teclado.nextLine();//limpiare la cache.            
        }else{
            System.out.println("____________________________________________________________________________________________");
            System.out.println("\n------------------Ha ocurrido un error, dato introducido incorrectamentee-------------------");
            System.out.println("____________________________________________________________________________________________");
        }
   }
    
}
