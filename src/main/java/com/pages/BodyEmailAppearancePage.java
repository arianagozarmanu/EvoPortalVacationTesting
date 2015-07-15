package com.pages;

import org.junit.Assert;

import net.serenitybdd.core.pages.PageObject;

public class BodyEmailAppearancePage extends PageObject {

	private String subjectPattern = "You have submitted a new Vacation Request";
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

	public void checkTheContent() {
		String result = "";
		String text = EmailConnecting.content;
		String name = "";

		int i = 0;
		while (text.charAt(i) != ',') {
			name = name + text.charAt(i);
			i++;
		}
		name = name + "," + "\n";
		result = name + contentPattern1 + "13/08/2020" + " - " + "13/08/2020" + strongPattern + brPattern
				+ contentPattern2 + "Ariana Gozar-Manu" + bPattern + contentPattern3 + "\n";

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

}
