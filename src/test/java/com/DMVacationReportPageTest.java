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
		vacReportPage.typeName(Constants.LAST_NAME, Constants.FIRST_NAME);
		vacReportPage.clickSearchButton();
		vacReportPage.accessUser();
		vacReportPage.getTotalFreeDays();
		dmInboxAccessSteps.accessInbox();
		vacReportPage.checkOneRequest(Constants.LAST_NAME, Constants.FIRST_NAME);
		vacReportPage.clickReject();
		dmApproveSteps.succes_message_occurs();
		vacReportPage.searchUser(Constants.LAST_NAME, Constants.FIRST_NAME);
		vacReportPage.accessUser();
		vacReportPage.compareTotalFreeDays();
	}
}
