package com.pages;

import java.io.Console;

import net.serenitybdd.core.pages.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DatePickerPage extends PageObject {

	private static int year;
	private static int day;
	private static String month;
	
	public AssignedToMeRequestsPage dataSet;
	
	public void selectDate(int year, String month, int day) {
		
		this.year=year;
		this.month=month;
		this.day=day;
		
		waitABit(1000);
		WebElement title = getDriver().findElement(By
				.cssSelector("[style*='display: block'] .dp_caption"));
		title.click();
		waitABit(1000);
		title.click();
		waitABit(1000);

		WebElement yearBox = getDriver().findElement(By
				.xpath("//div[@class='Zebra_DatePicker'][contains(@style,'block')]//td[text()='" + Integer.toString(year) + "']"));
		
		element(yearBox).waitUntilVisible();
		yearBox.click();

		waitABit(1000);

		WebElement monthBox = getDriver().findElement(By
				.xpath("//div[@class='Zebra_DatePicker'][contains(@style,'block')]//td[text()='" + month + "']"));
		monthBox.click();

		waitABit(1000);
		waitABit(1000);

		WebElement dayBox = getDriver().findElement(By
				.xpath("//div[@class='Zebra_DatePicker'][contains(@style,'block')]//td[text()='" + Integer.toString(day) + "']"));
		dayBox.click();

		waitABit(1000);
		waitABit(1000);

	}
	
	public void convertMonth() {
		switch (month) {

		case ("Jan"):
			month = "01";

		case ("Feb"):
			month = "02";

		case ("Mar"):
			month = "03";

		case ("Apr"):
			month = "04";

		case ("May"):
			month = "05";

		case ("Jun"):
			month = "06";

		case ("Jul"):
			month = "07";

		case ("Aug"):
			month = "08";

		case ("Sep"):
			month = "09";

		case ("Oct"):
			month = "10";

		case ("Nov"):
			month = "11";

		case ("Dec"):
			month = "12";

		default:
			System.out.println("Error!  The month is not valid!");

		}
		
	}
	public void convertDate(){
		String date = day+ "/"+ month + "/" + year;
		dataSet.setData(date);
	}
}
