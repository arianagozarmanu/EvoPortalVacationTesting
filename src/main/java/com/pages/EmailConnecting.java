package com.pages;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import net.serenitybdd.core.pages.PageObject;
import tools.Constants;


public class EmailConnecting extends PageObject{
	public static String sender;
	public static String sentDate;
	public static String subject;
	public static String content;
	
	public void readLastEmail(String site,String email, String password) {
	//public static void main(String[] args){
		Properties props = new Properties();
		props.setProperty("mail.store.protocol", "imaps");
		try {
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            store.connect(site, email, password);
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            Message msg = inbox.getMessage(inbox.getMessageCount());
            Address[] in = msg.getFrom();
            for (Address address : in) {
                //System.out.println("FROM:" + address.toString());
                sender=address.toString();
            }
            //Multipart mp = (Multipart) msg.getContent(); -this is for attachments 
            //BodyPart bp = mp.getBodyPart(0);
            //System.out.println("SENT DATE:" + msg.getSentDate());
            //System.out.println("SUBJECT:" + msg.getSubject());
            //System.out.println("CONTENT:" + msg.getContent());
            sentDate=msg.getSentDate().toString();
            System.out.println(sentDate);
            subject=msg.getSubject();
            System.out.println(subject);
            content=(String) msg.getContent();
            System.out.println(content);
            
           
        } catch (Exception mex) {
            mex.printStackTrace();
        }
    
	}
	
	

}
