package com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.DMInboxAccessSteps;
import com.steps.FilterRequestsSteps;
import com.steps.LoginSteps;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.UseTestDataFrom;
import tools.Constants;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("/resources/dataForFilters.csv")


public class FilterRequestsTest {
	
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = Constants.EVO_URL)
	public Pages pages;

	@Steps
	public FilterRequestsSteps filters;
	
	@Steps
	public LoginSteps login;
	
	@Steps
	public DMInboxAccessSteps dmInboxAccessSteps;


	String type,number,status;

	@Issue("Filter_Requests")
	
	@Test
	public void apply_filters_on_My_Requests(){
		login.logIn(Constants.VALID_SCREEN_NAME, Constants.VALID_PASSWORD);
		dmInboxAccessSteps.openVacationTab();
		filters.selectFilters(type, number, status);
		filters.applyFilters();	
		filters.validateFilter(type, number, status);
	}
}
