package com;

import java.text.ParseException;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import tools.Constants;
import com.steps.*;

@RunWith(SerenityRunner.class)
public class UserEmailReceiveTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = Constants.EVO_URL)
	public Pages pages;

	@Steps
	LoginSteps user;
	@Steps
	CreateVacationSteps employee;
	@Steps
	DMInboxAccessSteps vacationTab;
	@Steps
	DMApproveRequestsSteps validation;
	@Steps
	EmailConnectingSteps emailCon;
	@Steps
	CheckEmailContentSteps emailApp;

	@Test
	public void employee_receive_confirmation_email_for_requests() throws ParseException {
		
		// create a request
		user.logIn(Constants.VALID_SCREEN_NAME, Constants.VALID_PASSWORD);
		vacationTab.openVacationTab();
		//employee.openNewVacationRequestTab();
		//employee.startingDate();
		//employee.selectDate(2017, "Apr", 24); // -->write the request start date
												// in format: YYYY, "---" , DD
		//employee.endingDate();
		//employee.selectDate(2017, "Apr", 24); // -->write the request end date
												// in format: YYYY, "---" , DD
		employee.createNewRequest(2017, "Apr",25, 2017, "Apr",25); // choose what kind of vacation you want :
									// .createSickLeave() ,
									// .createMaternityLeave() ,
									// .createVacationWithoutPayment()
								    // .createNewRequest() -> creates automatically a holiday vacation with data as parameter

		employee.saveTheRequest();

		// read email and check if the request was announced
		emailCon.readEmail(Constants.SITE, Constants. EVO_MAIL_ADDRESS, Constants.EVO_MAIL_PASSWORD);
		emailApp.checkIfEmailWasReceivedByEmployee("25/04/2017"); // -->write the request start date in format: DD/MM/YYYY										 
													
	}
}
