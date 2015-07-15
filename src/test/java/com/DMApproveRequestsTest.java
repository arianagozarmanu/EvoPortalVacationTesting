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

import com.steps.CreateVacationSteps;
import com.steps.DMApproveRequestsSteps;
import com.steps.DMInboxAccessSteps;
import com.steps.UserSteps;

@RunWith(SerenityRunner.class)
public class DMApproveRequestsTest {

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
	public CreateVacationSteps newRequest;

	@Issue("DM Approve Requests Test")

	@Test
	public void DM_can_approve_requests() throws ParseException {
		
		//create a new request
		endUser.logIn(Constants.VALID_SCREEN_NAME, Constants.VALID_PASSWORD);
		dmInboxAccessSteps.openVacationTab();
		newRequest.createNewRequest(Constants.REQUEST_START_YEAR, Constants.REQUEST_START_MONTH,
				Constants.REQUEST_START_DAY, Constants.REQUEST_END_YEAR, Constants.REQUEST_END_MONTH,
				Constants.REQUEST_END_DAY);
		endUser.signsOut();
		
		//approve one request
		endUser.logIn(Constants.DM_SCREEN_NAME, Constants.DM_PASSWORD);
		dmInboxAccessSteps.openVacationTab();
		dmInboxAccessSteps.accessInbox();
		dmApproveSteps.check_last_request();
		dmApproveSteps.click_approve();
		dmApproveSteps.succes_message_occurs();
		endUser.signsOut();
		
		//go to the employee account and verify if his request was approved
		endUser.is_the_home_page();
		endUser.enters_data(Constants.VALID_SCREEN_NAME, Constants.VALID_PASSWORD);
		endUser.signsIn();
		dmInboxAccessSteps.openVacationTab();
		//dmApproveSteps.show_75_requests_per_page();
		dmApproveSteps.request_is_approved(Constants.APPROVE_MSG);

	}
}
