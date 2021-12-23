package com.example.mutuelle_centralisee_v2.DataBase;


import com.example.mutuelle_centralisee_v2.Models.ClientModel;
import com.example.mutuelle_centralisee_v2.MutualApp;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;


public class MailSender extends MutualApp {


    public static void sendMail(String recepient, ClientModel c) throws MessagingException {


        System.out.println("Preparing to send email");
        Properties props = new Properties();


        final String email = "test.mailing.yb@gmail.com";
        final String password = "azerty@123";


        //Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", true);


        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });


        Message message = prepareMessage(session, email, recepient,c);
        Transport.send(message);
        System.out.println("Message sent successfully");
    }

    private static Message prepareMessage(Session session, String from, String to , ClientModel c) {

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Please do not  reply");
            message.setText("Hello mr." + c.getNom() +
            "\nYour information are added successfully");
            return message;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return  null;
    }

}