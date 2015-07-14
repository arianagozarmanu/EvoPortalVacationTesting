package com.pages;

import java.io.Console;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


import net.serenitybdd.core.pages.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DatePickerPage extends PageObject {

	private static int year;
	private static int day;
	private static String month;
	
	private static int monthInt;
	
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
	
	public void convertMonth() throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new SimpleDateFormat("MMM").parse(month));
		monthInt = cal.get(Calendar.MONTH) + 1;
		System.out.println(monthInt);
		
	}
	public void convertDate(){
		String date = day+ "/"+ monthInt + "/" + year;
		System.out.println(date);
		dataSet.setData(date);
	}
}
