/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SL.MAIL;

import javax.mail.*;
import javax.mail.internet.*;

import java.security.Security;
import java.util.Properties;

/**
 *
 * @author Kalyan Kasyap
 */
public class SendMail {

    Transport transport;
    MimeMessage message;

    public SendMail(String from, String password, String to) {

        try {
            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

            Properties props = new Properties();
            props.setProperty("mail.transport.protocol", "smtp");

            props.setProperty("mail.host", "smtp.gmail.com");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            props.put("mail.debug", "true");
//props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.fallback", "false");

            Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {

                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication("kalyankasyapcse@gmail.com", "ibm08733Gibm");
                        }
                    });

            session.setDebug(true);


            transport = session.getTransport();
            InternetAddress addressFrom = new InternetAddress(from);

            MimeMessage message = new MimeMessage(session);
            message.setSender(addressFrom);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            this.message = message;


        } catch (NoSuchProviderException e) {
            System.out.println("No Classes Found to Connect to Mail Server");
        } catch (AddressException e) {
            System.out.println("Your E-mail Address Is Wroing");
        } catch (MessagingException e) {
            System.out.println("Internet Connection Is Not there For Ur Computer");
        }
    }

    public void send(String subject, String body) {
        try {
            message.setSubject(subject);
            message.setContent(body, "text/plain");

            transport.connect();
            transport.send(message);
            transport.close();
        } catch (NoSuchProviderException e) {
            System.out.println("No Classes Found to Connect to Mail Server");
        } catch (AddressException e) {
            System.out.println("Your E-mail Address Is Wroing");
        } catch (MessagingException e) {
            System.out.println("Internet Connection Is Not there For Ur Computer");
        }

    }
}
