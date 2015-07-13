package com.pages;

import net.serenitybdd.core.pages.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DatePickerPage extends PageObject {

	public void selectDate(int year, String month, int day) {

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

		WebElement dayBox = getDriver().findElement(By
				.xpath("//div[@class='Zebra_DatePicker'][contains(@style,'block')]//td[text()='" + Integer.toString(day) + "']"));
		dayBox.click();

		waitABit(1000);

	}

}
