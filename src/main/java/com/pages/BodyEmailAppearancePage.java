package com.pages;

import java.io.*;

import org.junit.Assert;

import net.serenitybdd.core.pages.PageObject;
import tools.Constants;

public class BodyEmailAppearancePage extends PageObject {

	private String subjectPattern = "You have submitted a new Vacation Request";
	private String receivePattern = "New Vacation Request submitted";
	private String contentPattern1 = "<br /> <br />" + "\n" + "\n" + "\n"
			+ "			You have submitted a new Vacation Request. Your holiday interval is: <strong>";
	private String strongPattern = "</strong>." + "\n";
	private String brPattern = "		<br />" + "\n";
	private String contentPattern2 = "					Please check if the request was approved before going on holiday, if not please contact your vacation approver, <b>";
	private String bPattern = "</b>." + "\n" + "			" + "\n" + "\n";
	private String contentPattern3 = "\n" + "<!-- " + "\n" + "<br/> <br/> " + "\n" + "\n" + "Cheers, " + "\n"
			+ "<br /> " + "\n" + "The EvoPortal Team" + "\n" + "--><br/> <br/> Cheers, <br /> The EvoPortal Team";

	public void vacationRequestEmployee() {
		checkTheSubject();
		checkTheContent();
	}

	public void checkTheSubject() {
		Assert.assertTrue("Subject is not correct!", EmailConnecting.subject.equals(subjectPattern));
	}

	public static void writeToFile(String file1, String textToWrite) {
		BufferedWriter output = null;
		File file = new File(file1);
		try {
			output = new BufferedWriter(new FileWriter(file));
			output.write(textToWrite);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (output != null)
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	public void checkTheContent() {
		String result = "";
		String text = EmailConnecting.content;
		writeToFile("C:/Users/arianagozarmanu/Desktop/EmailContent.txt", text);
		String name = "";

		int i = 0;
		while (text.charAt(i) != ',') {
			name = name + text.charAt(i);
			i++;
		}
		name = name + "," + "\n";
		result = name + contentPattern1 + Constants.START_DATA + " - " + Constants.END_DATA + strongPattern + brPattern
				+ contentPattern2 + "Ariana Gozar-Manu" + bPattern + contentPattern3 + "\n";
		writeToFile("C:/Users/arianagozarmanu/Desktop/MyContent.txt", result);

		System.out.println("------My Result");
		System.out.println(result);
		System.out.println("------Email Content");
		System.out.println(text);
		System.out.println("------");

		System.out.printf("My Result size = %d , Content size = %d ", result.length(), text.length());
		i = 0;

		System.out.printf("\n\nWhere texts didn't match anymore:\n");
		while (text.charAt(i) == result.charAt(i)) {
			System.out.print(text.charAt(i));
			i++;
		}

		System.out.println();
		System.out.printf("Next char in content=", text.charAt(i));
		System.out.println();
		System.out.printf("Next char in my result=", result.charAt(i));

		System.out.println();
		System.out.println("------Email Content");
		System.out.println(text);

		System.out.println("Characters splited by '|':");
		System.out.println();
		System.out.println("------Email Content");
		i = 0;
		while (i < text.length()) {
			System.out.print(text.charAt(i));
			System.out.print("|");
			i++;
		}
		System.out.println();
		System.out.println("------My Result");
		i = 0;

		while (i < result.length()) {
			System.out.print(result.charAt(i));
			System.out.print("|");
			i++;
		}
		System.out.println();
		Assert.assertTrue("Content is not correct!", text.equals(result));

	}

	public void emailWasCreated(String data) {
		System.out.println(data);
		Assert.assertTrue("No email about a vacation submitted!", EmailConnecting.subject.contains(receivePattern));
		Assert.assertTrue("No request submitted in " + data + " !", EmailConnecting.content.contains(data));
	}

}
