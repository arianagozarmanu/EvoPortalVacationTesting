package com.pages;

import java.io.*;
import java.util.*;

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

	public void holidayVacationRequestEmployee(String startDate,String endDate) {
		checkTheSubject();
		checkTheContent(startDate,endDate);
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

	public static boolean compareFiles(String file1, String file2) {

		boolean emailContentIsOk = false;

		String lineA = null;
		String lineB = null;

		// lists of lines
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();

		// lists of characters
		List<Character> charsList1 = new ArrayList<Character>();
		List<Character> charsList2 = new ArrayList<Character>();

		int i;

		try {
			BufferedReader br1 = new BufferedReader(new FileReader(file1));
			BufferedReader br2 = new BufferedReader(new FileReader(file2));

			while ((lineA = br1.readLine()) != null) {
				list1.add(lineA);
			}
			while ((lineB = br2.readLine()) != null) {
				list2.add(lineB);
			}
			br1.close();
			br2.close();

			// create list of characters from file1 (email content)
			for (String x : list1) {
				for (i = 0; i < x.length(); i++) {
					charsList1.add(x.charAt(i));
				}
			}
			// create list of characters from file1 (my result)
			for (String y : list2) {
				for (i = 0; i < y.length(); i++) {
					charsList2.add(y.charAt(i));
				}
			}

			int sizeL1 = charsList1.size();
			int sizeL2 = charsList2.size();

			System.out.println("Email Content has : " + sizeL1 + " characters");
			System.out.println("My Result has : " + sizeL2 + " characters");
			System.out.println();
			System.out.println();

			if (sizeL1 == sizeL2)
				emailContentIsOk = true;

			for (i = 0; emailContentIsOk && i < sizeL1; i++) {
				try {
					System.out.print("List 1 - position " + i + " - " + charsList1.get(i) + " | ");

					if (!(charsList1.get(i).equals(charsList2.get(i)))) {
						emailContentIsOk = false;
						System.out.println();
						System.out.println("Characters don't match at position " + i);
					}

					System.out.print(" List 2 - position " + i + " - " + charsList2.get(i));
					System.out.println();

				} catch (Exception e) {
					System.out.println(e);
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return emailContentIsOk;
	}

	public void checkTheContent(String startDate,String endDate) {
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
		result = name + contentPattern1 + startDate + " - " + endDate + strongPattern + brPattern
				+ contentPattern2 + "Ariana Gozar-Manu" + bPattern + contentPattern3 + "\n";
		
		System.out.println(result);
		System.out.println();
		writeToFile("C:/Users/arianagozarmanu/Desktop/MyContent.txt", result);

		Assert.assertTrue("Contents don't match!", compareFiles("C:/Users/arianagozarmanu/Desktop/EmailContent.txt",
				"C:/Users/arianagozarmanu/Desktop/MyContent.txt"));
	}

	public void emailWasCreated(String data) {
		System.out.println(data);
		Assert.assertTrue("No email about a vacation submitted!", EmailConnecting.subject.contains(receivePattern));
		Assert.assertTrue("No request submitted in " + data + " !", EmailConnecting.content.contains(data));
	}

}
