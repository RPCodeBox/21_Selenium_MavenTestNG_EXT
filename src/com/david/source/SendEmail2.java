package com.david.source;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail2
{
   public static void sendDSR(String filename)
   {
      
      // Recipient's email ID needs to be mentioned.
//      String to = "davisolo@cisco.com";
	   String[] to = {"davisolo@cisco.com"};//, "bhanukal@cisco.com", "msiddali@cisco.com"};
      // Sender's email ID needs to be mentioned
      String from = "testDSR@cisco.com";

      // Assuming you are sending email from localhost
      String host = "outbound.cisco.com";

      // Get system properties
      Properties properties = System.getProperties();

      // Setup mail server
      properties.setProperty("mail.smtp.host", host);

      // Get the default Session object.
      Session session = Session.getDefaultInstance(properties);
      
      //String filename = "C:/david/Comments/Q2FY13/AutoDSR/Q2FY13_TCB_DSR_REPORT_Sep14.xlsm";

      try{
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         //message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
         
         InternetAddress[] addressTo = new InternetAddress[to.length];
         for (int i = 0; i < to.length; i++)
         {
             addressTo[i] = new InternetAddress(to[i]);
         }

         // Set To: header field of the header.
        // message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
         
         message.setRecipients(Message.RecipientType.TO, addressTo);

                                  
         // Set Subject: header field
         message.setSubject("Today's DSR");

         // Now set the actual message
         message.setText("This is actual message");
         
       //  message.setFileName(filename);
         
         MimeBodyPart mbp1 = new MimeBodyPart();

         // attach the file to the message
         FileDataSource fds = new FileDataSource(filename);
         mbp1.setDataHandler(new DataHandler(fds));
         mbp1.setFileName(fds.getName());
         //mbp2.setText("Team, \n Please find Today’s Q2FY13  TCB DSR\n If you have started your Q2 TCB execution and if any of your track is in yellow / red color (in Execution Summary & ScopeTrack ), please provide the comments for the same \n     		 Thanks & Regards,\n S.David");

         String mailBody = "Team, <BR><BR>Please find Today\'s Q2FY13  TCB DSR. <BR><BR>If any of your track is in yellow / red color, please provide the comments for the same. <BR><BR>Thanks & Regards,<BR>S.David.";
         MimeBodyPart bp2 = new MimeBodyPart();  
         bp2.setContent( mailBody, "text/html; charset=ISO-8859-9" );  
         
   // create the Multipart and add its parts to it
         Multipart mp = new MimeMultipart();
         mp.addBodyPart(mbp1);
         mp.addBodyPart(bp2);
         message.setContent(mp);
         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
}
