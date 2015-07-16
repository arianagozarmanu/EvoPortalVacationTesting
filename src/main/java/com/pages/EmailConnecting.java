package com.pages;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

import net.serenitybdd.core.pages.PageObject;

public class EmailConnecting extends PageObject {
	public static String sender;
	public static String sentDate;
	public static String subject;
	public static String content;

	public void readLastEmailReceived(String site, String email, String password) {
		
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
				sender = address.toString();
			}
			sentDate = msg.getSentDate().toString();
			System.out.println(sentDate);
			subject = msg.getSubject();
			System.out.println(subject);
			content = (String) msg.getContent();
			System.out.println(content);

		} catch (Exception mex) {
			mex.printStackTrace();
		}

	}

}
