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
        System.out.println("1) Crear evento\n2) Ver eventos.\nIngrese número de opción:\t\t\t\t\t    Ingrese (S) para Salir");       
        System.out.print(" ");
        int opt=teclado.nextInt();
        switch (opt) {
            case 1:
                System.out.println("____________________________________________________________________________________________"); 
                System.out.println("\n-----------------------------Ingrese la informacion de su evento----------------------------");
                System.out.println("____________________________________________________________________________________________"); 
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
        System.out.println("____________________________________________________________________________________________");
        System.out.println("\n---------------------------Selecciona la forma de ver tus Eventos---------------------------");
        System.out.println("____________________________________________________________________________________________");
        System.out.println("1) Primeros 3 eventos más cercanos de la fecha.\n"
                        + "2) Eventos Diarios.\n3) Eventos Mensuales.\t\t\t\t\t\t   Ingrese (C) para Cancelar");
        System.out.print(" ");
        int opt=teclado.nextInt();
        if(opt==1){
            Querys.callFirsTreeEvents(IdUser, email);
        }
    }

  
}
