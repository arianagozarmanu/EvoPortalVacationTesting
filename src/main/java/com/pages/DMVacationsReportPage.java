package com.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class DMVacationsReportPage extends PageObject{
	
	@FindBy(css ="div[class='tab-pane active'] tr[class='section-result'] td:nth-child(2)")
	private WebElementFacade totalFreeDays;
	
	@FindBy(css="a[href*='menuItem=vacation-report']")
	private WebElementFacade vacationReportTab;
	
	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_reportLastName']")
	private WebElementFacade lastNameField;
	
	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_reportFirstName']")
	private WebElementFacade firstNameField;
	
	private static int freeDays;
	
	public void openVacationReportTab(){
		vacationReportTab.click();
	}
	
	public void getTotalFreeDays(){
		String days=totalFreeDays.getText();
		freeDays=Integer.parseInt(days);
		System.out.println(freeDays);
	}
	
	public void typeName(String lastName,String firstName){
		
	}
	

}
