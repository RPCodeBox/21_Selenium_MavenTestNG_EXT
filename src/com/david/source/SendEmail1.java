package com.david.source;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail1
{
   public static void main(String args[])
   {
      
      // Recipient's email ID needs to be mentioned.
      /* String to = "davisolo@cisco.com";
      String to1 = "bhanukal@cisco.com";
      String to2 = "msiddali@cisco.com"; */
      
      String[] to = {"davisolo@cisco.com"}; 

      // Sender's email ID needs to be mentioned
      String from = "ccwdailydsr@cisco.com";

      // Assuming you are sending email from localhost
      String host = "outbound.cisco.com";

      String filename = "C:/david/Cisco_Webex.txt";
      
      // Get system properties
      Properties properties = System.getProperties();

      // Setup mail server
      properties.setProperty("mail.smtp.host", host);

      // Get the default Session object.
      Session session = Session.getDefaultInstance(properties);

      try{
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));
         
         InternetAddress[] addressTo = new InternetAddress[to.length];
         for (int i = 0; i < to.length; i++)
         {
             addressTo[i] = new InternetAddress(to[i]);
         }

         // Set To: header field of the header.
        // message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
         
         message.setRecipients(Message.RecipientType.TO, addressTo);
         // Set Subject: header field
         message.setSubject("Today's DSR - Automated mail From David's System - Pls Ignore");

         // Now set the actual message
         message.setText("This is actual message");
         
         //message.setFileName("C:\\david\\Comments\\Q2FY13\\AutoDSR\\Q2FY13_TCB_DSR_REPORT_Sep14.xlsm");

         // Send message
         
         MimeBodyPart mbp1 = new MimeBodyPart();

         // attach the file to the message
         FileDataSource fds = new FileDataSource(filename);
         mbp1.setDataHandler(new DataHandler(fds));
         mbp1.setFileName(fds.getName());
       //  mbp1.setText("Test Mail Body");
         
         String mailBody = "Team, <BR><BR>Please find Today\'s Q2FY13  TCB DSR. <BR><BR>If any of your track is in yellow / red color, please provide the comments for the same. <BR><BR>Thanks & Regards,<BR>S.David.";
         MimeBodyPart bp2 = new MimeBodyPart();  
         bp2.setContent( mailBody, "text/html; charset=ISO-8859-9" );  
         
   // create the Multipart and add its parts to it
         Multipart mp = new MimeMultipart();
         mp.addBodyPart(mbp1);
         mp.addBodyPart(bp2);
   // add the Multipart to the message
         message.setContent(mp);
      //   message.setText("This is actual message");
         
         Transport.send(message);
         System.out.println("Sent message successfully....");
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
}

