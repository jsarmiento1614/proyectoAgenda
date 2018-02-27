/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class Perfil {
    Scanner teclado=new Scanner(System.in);
    
    public void ShowPerfilUser(String email){
        Menu callMenu = new Menu();//abrir el menu del perfil.
        Perfil callPerfil=new Perfil();
        callMenu.headerPerfil();        
        Querys.callPerfil(email);
    }
    public void mainPerfil(String IdUser, String email){
        System.out.println("Menú de control de Eventos");
        System.out.println("1) Crear evento\n2) Ver eventos.\nIngrese número de opción: ");
        System.out.print(" ");
        int opt=teclado.nextInt();
        switch (opt) {
            case 1:
                System.out.println("-------------------------------------");
                System.out.println("Ingrese la informacion de su evento:");
                InsertEvent callInsertEvent=new InsertEvent();
                callInsertEvent.InsertEvent(IdUser,email);
                break;
            case 2:
                Perfil callPerfil=new Perfil();
                callPerfil.MenuEventos(IdUser, email);
                break;
            default:
                System.out.println("No ha elegido ninguna de la opciones.");
                break;
        } 
    }
    public void MenuEventos(String IdUser, String email){
        System.out.println("-------------------------------------");
        System.out.println("Selecciona la forma de ver tus Eventos.");
        System.out.println("1) Primeros 3 eventos más cercanos de la fecha.\n"
                        + "2) Eventos Diarios.\n3) Eventos Mensuales.");
        int opt=teclado.nextInt();
        if(opt==1){
            Querys.callFirsTreeEvents(IdUser, email);
        }
    }

  
}
