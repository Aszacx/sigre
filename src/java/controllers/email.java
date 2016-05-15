/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.Properties;
import java.util.Random;
import javax.activation.DataHandler;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author Lenovo
 */
public class email {
    
    Properties p = new Properties();
    
    public boolean enviar(String destinatario, String asunto, String cuerpo) throws MessagingException {
        p.setProperty("mail.smtp.host", "smtp.gmail.com");
        p.setProperty("mail.smtp.starttls.enable", "true");
        p.setProperty("mail.smtp.port", "587");
        p.setProperty("mail.smtp.user", "jimbo.earth@gmail.com");
        p.setProperty("mail.smtp.auth", "true");
        
        Session s = Session.getDefaultInstance(p,null);
        
        MimeMessage mensaje = new MimeMessage(s);
        mensaje.setFrom(new InternetAddress("jimbo.earth@gmail.com"));
        mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
        mensaje.setSubject(asunto);
        mensaje.setText(cuerpo, "UTF-8", "html");
        Transport t = s.getTransport("smtp");
        t.connect("jimbo.earth@gmail.com", "aeqpbmqepjhmfbuf");
        t.sendMessage(mensaje, mensaje.getAllRecipients());
        t.close();
        return true;
    }
    
    public String generarPassword(int longitud){
        String cadenaAleatoria = "";
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        int i = 0;
        while (i < longitud){
            char c = (char)r.nextInt(255);
            if ( (c >= '0' && c <='9') || (c >='A' && c <='Z') ){
                cadenaAleatoria += c;
                i ++;
                }
        }
        return cadenaAleatoria;
    }
}
