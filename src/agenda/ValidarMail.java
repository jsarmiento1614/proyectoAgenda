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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ValidarMail {
    public void validar(String correo){
        Agenda callLogin = new Agenda();
        
        // Patrón para validar el email
        Pattern pattern = Pattern
        .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        Matcher mather = pattern.matcher(correo);
        
            if (mather.find() == true) {
                
                //Querys callqueryEmail=new Querys();
                Querys.queryEmail(correo);
                System.out.println(".........................");
               
            } else {
                System.out.println("El email ingresado no cumple los requisitos como correo.\n");
               
            }       
    }
    
    public void validarRegistro(String email, String nombre){
        Agenda callLogin = new Agenda();
        Registro callregistro =new Registro();
        
        // Patrón para validar el email
        Pattern pattern = Pattern
        .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        Matcher mather = pattern.matcher(email);
            if (mather.find() == true) {
                Querys.IsertRegistro(email, nombre);
                System.out.println(".........................");
               
            } else {
                System.out.println("El email ingresado no cumple los requisitos como correo.");
                callregistro.registroUser();    
            }       
    }

}
