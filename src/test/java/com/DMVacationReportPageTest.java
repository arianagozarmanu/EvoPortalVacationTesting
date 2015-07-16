package com;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import java.text.ParseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import tools.Constants;
import com.steps.CheckVacationReportPageStep;
import com.steps.CreateVacationSteps;
import com.steps.DMApproveRequestsSteps;
import com.steps.DMInboxAccessSteps;
import com.steps.LoginSteps;

@RunWith(SerenityRunner.class)
public class DMVacationReportPageTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = Constants.EVO_URL)
	public Pages pages;

	@Steps
	public LoginSteps endUser;
	@Steps
	public DMInboxAccessSteps dmInboxAccessSteps;
	@Steps
	public DMApproveRequestsSteps dmApproveSteps;
	@Steps
	public CheckVacationReportPageStep vacReportPage;
	@Steps
	public CreateVacationSteps newRequest;

	@Issue("DM Vacation Report Test")

	@Test
	public void vacation_report_updates_correctly() throws ParseException {
		
		//create a new request
		endUser.logIn(Constants.VALID_SCREEN_NAME, Constants.VALID_PASSWORD);
		dmInboxAccessSteps.openVacationTab();
		newRequest.createNewRequest(2019,"Apr",30,2019,"Apr",30);
		endUser.signsOut();
		
		//get total free days for a gived name - employee
		endUser.logIn(Constants.DM_SCREEN_NAME, Constants.DM_PASSWORD);
		dmInboxAccessSteps.openVacationTab();
		vacReportPage.openVacationReportTab();
		vacReportPage.typeName(Constants.LAST_NAME, Constants.FIRST_NAME);
		vacReportPage.clickSearchButton();
		vacReportPage.accessUser();
		vacReportPage.getTotalFreeDays();
		
		//reject one of his request
		dmInboxAccessSteps.accessInbox();
		vacReportPage.checkOneRequest(Constants.LAST_NAME, Constants.FIRST_NAME);
		vacReportPage.clickReject();
		dmApproveSteps.succes_message_occurs();
		
		//verify his total free days  
		vacReportPage.searchUser(Constants.LAST_NAME, Constants.FIRST_NAME);
		vacReportPage.accessUser();
		vacReportPage.compareTotalFreeDays();
	}
}
