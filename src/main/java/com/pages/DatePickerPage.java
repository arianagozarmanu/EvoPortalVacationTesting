package com.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DatePickerPage extends PageObject {

	private static int year;
	private static int day;
	private static String month;
	private static String textInHeader;
	private static String firstYear;
	private static String lastYear;
	private static int firstYearInt;
	private static int lastYearInt;
	private static int i;
	private static boolean sem;

	private static int monthInt;

	@FindBy(css = ".dp_next")
	private WebElementFacade nextButton;

	@FindBy(css = "[style*='display: block'] .dp_caption")
	private WebElementFacade captionHeader;

	public AssignedToMeRequestsPage dataSet;

	public void selectDate(int year, String month, int day) {

		DatePickerPage.year = year;
		DatePickerPage.month = month;
		DatePickerPage.day = day;

		waitABit(1000);
		WebElement title = getDriver().findElement(By.cssSelector("[style*='display: block'] .dp_caption"));
		title.click();
		waitABit(1000);
		title.click();
		waitABit(1000);

		sem = true;
		while (sem) {
			firstYear = "";
			lastYear = "";
			textInHeader = captionHeader.getText();
			int size = textInHeader.length();
			System.out.println(textInHeader);

			for (i = 0; i <= 3; i++) {
				firstYear = firstYear + textInHeader.charAt(i);
			}
			firstYearInt = Integer.parseInt(firstYear);
			System.out.println(firstYearInt);

			for (i = size - 4; i <= size - 1; i++) {
				lastYear = lastYear + textInHeader.charAt(i);
			}

			lastYearInt = Integer.parseInt(lastYear);
			System.out.println(lastYearInt);

			if (year >= firstYearInt && year <= lastYearInt)
				sem = false;
			else
				nextButton.click();

		}

		WebElement yearBox = getDriver()
				.findElement(By.xpath("//div[@class='Zebra_DatePicker'][contains(@style,'block')]//td[text()='"
						+ Integer.toString(year) + "']"));

		element(yearBox).waitUntilVisible();
		yearBox.click();
		waitABit(1000);

		WebElement monthBox = getDriver().findElement(
				By.xpath("//div[@class='Zebra_DatePicker'][contains(@style,'block')]//td[text()='" + month + "']"));
		monthBox.click();

		waitABit(1000);
		waitABit(1000);

		WebElement dayBox = getDriver()
				.findElement(By.xpath("//div[@class='Zebra_DatePicker'][contains(@style,'block')]//td[text()='"
						+ Integer.toString(day) + "']"));
		dayBox.click();

		waitABit(1000);
		waitABit(1000);

	}

	public void convertMonthToInteger() throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new SimpleDateFormat("MMM").parse(month));
		monthInt = cal.get(Calendar.MONTH) + 1;
		System.out.println(monthInt);

	}

	public void convertDate() {
		String date;
		if (day < 10) {
			if (monthInt < 10) {
				date = "0" + day + "/" + "0" + monthInt + "/" + year;
			} else {
				date = "0" + day + "/" + monthInt + "/" + year;
			}
		} else {
			if (monthInt < 10) {
				date = day + "/" + "0" + monthInt + "/" + year;
			} 
			else {
				date = day + "/" + monthInt + "/" + year;
			}
		}
		System.out.println(date);
		dataSet.setData(date);
	}
}
