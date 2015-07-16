/**
 * Test if requests sent by users
 * are approved by the DM
 */
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
import com.steps.LoginSteps;

@RunWith(SerenityRunner.class)
public class DMApproveRequestsTest {

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
	public CreateVacationSteps newRequest;

	@Issue("DM Approve Requests Test")

	@Test
	public void DM_can_approve_requests() throws ParseException {
		
		//create a new request
		endUser.logIn(Constants.VALID_SCREEN_NAME, Constants.VALID_PASSWORD);
		dmInboxAccessSteps.openVacationTab();
		newRequest.createNewRequest(2022,"Jun",07,2022,"Jun",07);
		endUser.signsOut();
		
		//approve last request from Inbox first page
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
		dmApproveSteps.show_75_requests_per_page();
		dmApproveSteps.checkStatusOfTheRequest(Constants.APPROVE_MSG);

	}
}
