package com;

import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.CheckEmailAppearanceSteps;
import com.steps.CheckVacationReportPageStep;
import com.steps.CreateVacationSteps;
import com.steps.DMApproveRequestsSteps;
import com.steps.DMInboxAccessSteps;
import com.steps.EmailConnectingSteps;
import com.steps.UserSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import tools.Constants;

@RunWith(SerenityRunner.class)
public class BodyEmailAppearanceTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = Constants.EVO_URL)
	public Pages pages;

	@Steps
	public UserSteps endUser;
	@Steps
	public DMInboxAccessSteps dmInboxAccessSteps;
	@Steps
	public DMApproveRequestsSteps dmApproveSteps;
	@Steps
	public CheckVacationReportPageStep vacReportPage;
	@Steps
	public CreateVacationSteps newRequest;
	@Steps
	public CheckEmailAppearanceSteps emailApp;
	@Steps
	public EmailConnectingSteps emailSteps;

	@Test
	public void vacation_report_updates_correctly() throws ParseException {

		//create a new request
		//endUser.logIn(Constants.VALID_SCREEN_NAME, Constants.VALID_PASSWORD);
		//dmInboxAccessSteps.openVacationTab();
		//newRequest.createNewRequest(Constants.REQUEST_START_YEAR, Constants.REQUEST_START_MONTH,
		//		Constants.REQUEST_START_DAY, Constants.REQUEST_END_YEAR, Constants.REQUEST_END_MONTH,
		//		Constants.REQUEST_END_DAY);
		//endUser.signsOut();
		emailSteps.readEmail(Constants.SITE, Constants.EVO_MAIL_ADDRESS, Constants.EVO_MAIL_PASSWORD);
		emailApp.checkEmployeeRequest();
		
	}
}
