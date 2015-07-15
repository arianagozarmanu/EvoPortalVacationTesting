package com.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class DMVacationsReportPage extends PageObject {

	@FindBy(css = "div[class='tab-pane active'] tr[class='section-result'] td:nth-child(2)")
	private WebElementFacade totalFreeDays;

	@FindBy(css = "a[href*='menuItem=vacation-report']")
	private WebElementFacade vacationReportTab;

	@FindBy(css = "input[id='_evovacation_WAR_EvoVacationportlet_reportLastName']")
	private WebElementFacade lastNameField;

	@FindBy(css = "input[id='_evovacation_WAR_EvoVacationportlet_reportFirstName']")
	private WebElementFacade firstNameField;

	@FindBy(css = "input[id='_evovacation_WAR_EvoVacationportlet_searchButton']")
	private WebElementFacade searchButton;

	@FindBy(css = "td[id*='_evovacation_WAR_EvoVacationportlet_usersSearchContainer_col-last-name_'] a")
	private WebElementFacade lastName;

	@FindBy(css = "a[class*='aui-paginator-link aui-paginator-next-link']")
	private WebElementFacade nextPageButton;
	
	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_multipleRejectButton'] ")
	private WebElementFacade rejectButton;

	private static int freeDays;

	public void openVacationReportTab() {
		vacationReportTab.click();
	}

	public void getTotalFreeDays() {
		String days = totalFreeDays.getText();
		freeDays = Integer.parseInt(days);
		System.out.println(freeDays);
	}

	public void typeName(String lastName, String firstName) {
		lastNameField.type(lastName);
		firstNameField.type(firstName);
	}

	public void clickSearchButton() {
		searchButton.click();
	}

	public void accessUser() {
		lastName.click();
	}

	public void clickNextPageButton() {
		nextPageButton.click();
	}
	
	public void clickRejectButton(){
		rejectButton.click();
	}
	
	public void compareTotalFreeDays(){
		String days = totalFreeDays.getText();
		boolean ok=false;
		if(days.equals(Integer.toString(freeDays+1))){
			ok=true;
		}
		Assert.assertTrue("Wrong update for Total Free Days!",ok);
	}

	public void checkOneRequest(String lastName, String firstName) {

		List<WebElement> nameList;
		List<WebElement> checkBoxList;
		boolean notFind = true;
		int nameListSize;
		int i = 0;
		String name = firstName + " " + lastName;
		System.out.printf("After concatenation: ",name);
		while (nextPageButton.isPresent() && notFind) {
			nameList = getDriver().findElements(By.cssSelector("tr[class*='portlet-section-'] td:nth-child(2) a"));
			checkBoxList = getDriver().findElements(
					By.cssSelector("tr[class*='portlet-section-'] td:nth-child(1)  input[name*='rowIds']"));
			nameListSize = nameList.size();
			System.out.println(name);
			while (i < nameListSize && notFind) {
				if (nameList.get(i).getText().equals(name))
					checkBoxList.get(i).click();{
					notFind = false;
				}
				System.out.printf("Name "+i+":",nameList.get(i).getText()); 
				i++;
			}
			if(notFind){
				clickNextPageButton();
				waitABit(500);
				getDriver().navigate().refresh();
			}
		}

		nameList = getDriver().findElements(By.cssSelector("tr[class*='portlet-section-'] td:nth-child(2) a"));
		checkBoxList = getDriver()
				.findElements(By.cssSelector("tr[class*='portlet-section-'] td:nth-child(1)  input[name*='rowIds']"));
		nameListSize = nameList.size();
		System.out.println(name);
		System.out.printf("Next Page Name: ",name);
		System.out.printf("Boolean value:",notFind);
		while (notFind && i < nameListSize) {
			if (nameList.get(i).getText().equals(name)) {
				checkBoxList.get(i).click();
				notFind = false;
			}
			System.out.println(nameList.get(i).getText());
			i++;
		}

		Assert.assertTrue("Request from " + firstName + " " + lastName + " does not exist!", !notFind);

	}

}
