package com.pages;

import java.util.List;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FilterRequestsPage extends PageObject {

	@FindBy(css = "[id*='_applyButton']")
	private WebElementFacade applyButton;

	@FindBy(css = "a[class*='aui-paginator-link aui-paginator-next-link']")
	private WebElementFacade nextPageButton;

	private static int startNr;
	private static int endNr;

	public void selectFilters(String vacationType, String daysNumber,
			String vacationStatus) {
		
		try {
		WebElement checkBoxType = getDriver().findElement(
				By.cssSelector("[id*='_" + vacationType + "Checkbox']"));
		checkBoxType.click();
		
	
		WebElement checkBoxNumber = getDriver().findElement(
				By.cssSelector("[id*='_" + daysNumber + "Checkbox']"));
		checkBoxNumber.click();
		
		
		WebElement checkBoxStatus = getDriver().findElement(
				By.cssSelector("[id*='_" + vacationStatus + "Checkbox']"));
		checkBoxStatus.click();
		}catch(Exception e){
			System.out.println("You did not type correct the type/number/status");
		}

	}

	public void applyFilters() {
		applyButton.click();
	}

	public String convertType(String type) {
		if (type.equals("HOLIDAY"))
			return "Holiday";
		else if (type.equals("VACATION_WITHOUT_PAYMENT"))
			return "Vacation Without Payment";
		else if (type.equals("SPECIAL_VACATION"))
			return "Special Vacation";
		else if (type.equals("SICK_LEAVE"))
			return "Sick Leave";
		else if (type.equals("MATERNITY_LEAVE"))
			return "Maternity Leave";
		else
			return "The type you've requested does not exist!";

	}

	public void validNumber(String number) {
		if (number.equals("FIFTH")) {
			startNr = 1;
			endNr = 5;
		}
		if (number.equals("TENTH")) {
			startNr = 6;
			endNr = 10;
		}
		if (number.equals("TWENTIETH")) {
			startNr = 11;
			endNr = 20;
		}
		if (number.equals("FIFTIETH")) {
			startNr = 21;
			endNr = 50;
		}
		if (number.equals("REST")) {
			startNr = 51;
			endNr = Integer.MAX_VALUE;
		}

		Assert.assertTrue(
				"The number of days you've requested does not exist!",
				number.equals("REST") || number.equals("FIFTIETH")
						|| number.equals("TWENTIETH") || number.equals("TENTH")
						|| number.equals("FIFTH"));

	}

	public String convertStatus(String status) {
		String result = status.toLowerCase();
		return StringUtils.capitalize(result);
	}

	public void clickNextPageButton() {
		nextPageButton.click();
	}

	public boolean checkTheResultOfFilter(String type, String status) {
		List<WebElement> numberList;
		List<WebElement> statusList;
		List<WebElement> typeList;
		int i;
		while (nextPageButton.isPresent()) {
			numberList = getDriver()
					.findElements(
							By.cssSelector("tr[class*='portlet-section-'] td:nth-child(3) a"));
			typeList = getDriver()
					.findElements(
							By.cssSelector("tr[class*='portlet-section-'] td:nth-child(4) a"));
			statusList = getDriver()
					.findElements(
							By.cssSelector("tr[class*='portlet-section-'] td:nth-child(6) a"));
			int typeSize = typeList.size();
			for (i = 0; i < typeSize; i++) {
				if (typeList.get(i).getText().equals(type)) {
					if (statusList.get(i).getText().equals(status)) {
						int nr = Integer.parseInt(numberList.get(i).getText());
						if (nr >= startNr && nr <= endNr)
							continue;
						else
							return false;
					}
					else return false;
				}
				else return false;
			}
			clickNextPageButton();
			waitABit(500);
			getDriver().navigate().refresh();
		}
		
		//check the last page of the table
		numberList = getDriver()
				.findElements(
						By.cssSelector("tr[class*='portlet-section-'] td:nth-child(3) a"));
		typeList = getDriver()
				.findElements(
						By.cssSelector("tr[class*='portlet-section-'] td:nth-child(4) a"));
		statusList = getDriver()
				.findElements(
						By.cssSelector("tr[class*='portlet-section-'] td:nth-child(6) a"));
		int typeSize = typeList.size();
		for (i = 0; i < typeSize; i++) {
			if (typeList.get(i).getText().equals(type)) {
				if (statusList.get(i).getText().equals(status)) {
					int nr = Integer.parseInt(numberList.get(i).getText());
					if (nr >= startNr && nr <= endNr)
						continue;
					else
						return false;
				}
				else return false;
			}
			else return false;
		}
		
		return true;
	}

	public void validateAppliedFilters(String type, String number, String status) {
		String validType = convertType(type);
		System.out.println(validType);

		String validStatus = convertStatus(status);
		System.out.println(validStatus);

		validNumber(number);
		System.out.println(startNr);
		System.out.println(endNr);

		Assert.assertTrue("Filter does not work properly :("+"\n"+"You did not type correct the type/number/status"+"\n"+ "type: HOLIDAY, VACATION_WITHOUT_PAYMENT, SICK_LEAVE, SPECIAL_VACATION, MATERNITY_LEAVE"+"\n"+"number:FIFTH, TENTH, TWENTIETH, FIFTIETH, REST"+"\n"+"status:PENDING, REJECTED, APROVED, CANCELLED, WITHDRAWN",checkTheResultOfFilter(validType, validStatus));

	}

}
