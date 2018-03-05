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
public class SendEmailAviso {
    public void AvisoEmail(String time){
       Calendar calendario = new GregorianCalendar();
       int hora, minutos, segundos;
       hora =calendario.get(Calendar.HOUR_OF_DAY);
       minutos = calendario.get(Calendar.MINUTE);
       segundos = calendario.get(Calendar.SECOND);
       CharSequence csHour= time.subSequence(0, 2);
       CharSequence csMinutes= time.subSequence(3, 5);
       CharSequence csSeconds= time.subSequence(6, 8);
       int bdHour=Integer.parseInt((String) csHour);
       int bdMinutes=Integer.parseInt((String) csMinutes);
       int bdSeconds=Integer.parseInt((String) csSeconds);
       if(bdHour>6 || bdHour<24){
            if(bdHour-5==hora && bdMinutes==0){
               System.out.println("Mensaje enviado por la hora");
            }else if(bdHour-5!=hora && bdMinutes-5==minutos){
                System.out.println("Mensaje enviado por los minutos");     
            }
       }else {
        //if(bdHour>1 || bdHour<5){
           
       }
       
    }
    
}
