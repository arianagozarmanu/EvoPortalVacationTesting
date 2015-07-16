/**
 * Test if the content of an email
 * follows a specific pattern 
 */

package com;

import java.text.ParseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import com.steps.CheckEmailContentSteps;
import com.steps.CheckVacationReportPageStep;
import com.steps.CreateVacationSteps;
import com.steps.DMApproveRequestsSteps;
import com.steps.DMInboxAccessSteps;
import com.steps.EmailConnectingSteps;
import com.steps.LoginSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import tools.Constants;

@RunWith(SerenityRunner.class)
public class BodyEmailContentTest {

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
	@Steps
	public CheckEmailContentSteps emailApp;
	@Steps
	public EmailConnectingSteps emailSteps;

	@Test
	public void holiday_vacation_request_email_follows_specific_pattern() throws ParseException {

		//create a new holiday request
		endUser.logIn(Constants.VALID_SCREEN_NAME, Constants.VALID_PASSWORD);
		dmInboxAccessSteps.openVacationTab();
		newRequest.createNewRequest(2018,"May",3,2018,"May",3);      //write a start date and an end date -->format:YYYY,"---","DD"
																	 //.createNewRequest -> creates automatically a holiday vacation
		endUser.signsOut();
		
		//read email and check the content
		emailSteps.readEmail(Constants.SITE, Constants.EVO_MAIL_ADDRESS, Constants.EVO_MAIL_PASSWORD);
		emailApp.checkEmailContentForHolidayRequest("03/05/2018","03/05/2018");     //write the same start date and end date -->format:DD/MM/YYYY
		
	}
	
	@Test
	public void other_vacation_request_email_follows_specific_pattern() throws ParseException {
		
		//create a new request
		endUser.logIn(Constants.VALID_SCREEN_NAME, Constants.VALID_PASSWORD);
		dmInboxAccessSteps.openVacationTab();
		newRequest.openNewVacationRequestTab();
		newRequest.openStartDateSelection();
		newRequest.selectDate(2018, "Mar", 20); // -->write the request start date
												// in format: YYYY, "---" , DD
		newRequest.openEndDateSelection();
		newRequest.selectDate(2018, "Mar", 20); // -->write the request end date
												// in format: YYYY, "---" , DD
		newRequest.createSickLeave(); // choose what kind of vacation you want :
									// .createSickLeave() ,
									// .createMaternityLeave() ,
									// .createVacationWithoutPayment()
		newRequest.saveTheRequest();
		endUser.signsOut();
		
		//read email and check the content
		emailSteps.readEmail(Constants.SITE, Constants.EVO_MAIL_ADDRESS, Constants.EVO_MAIL_PASSWORD);
		emailApp.checkEmailContentForHolidayRequest("20/03/2018","20/03/2018");     //write the same start date and end date -->format:DD/MM/YYYY		
	}
}
