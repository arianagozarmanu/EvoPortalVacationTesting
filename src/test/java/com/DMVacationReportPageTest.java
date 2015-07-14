package com;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import tools.Constants;

import com.steps.CheckVacationReportPageStep;
import com.steps.DMApproveRequestsSteps;
import com.steps.DMInboxAccessSteps;
import com.steps.UserSteps;

@RunWith(SerenityRunner.class)
public class DMVacationReportPageTest {

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

	@Issue("DM Vacation Report Test")

	@Test
	public void vacation_report_updates_correctly() {
		endUser.is_the_home_page();
		endUser.enters_data(Constants.DM_SCREEN_NAME, Constants.DM_PASSWORD);
		endUser.signsIn();
		dmInboxAccessSteps.openVacationTab();
		vacReportPage.openVacationReportTab();
		vacReportPage.typeName(Constants.LAST_NAME, Constants.VALID_SCREEN_NAME);
		vacReportPage.getTotalFreeDays();
		dmInboxAccessSteps.accessInbox();
		dmApproveSteps.check_last_request();
		//retine 
		//click_reject();
		//dmApproveSteps.succes_message_occurs();
		//Vacations_Report
		//last name vandor
		//first name daniela
		//luat obiect si click
		//total available free days plus one
	}
}
