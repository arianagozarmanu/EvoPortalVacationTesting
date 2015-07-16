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
public class DMEmailReceiveTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = Constants.EVO_URL)
	public Pages pages;

	@Steps
	LoginSteps endUser;
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
	public void DM_receives_mail_notification() throws ParseException {
		
		// create a request
		endUser.logIn(Constants.VALID_SCREEN_NAME, Constants.VALID_PASSWORD);
		vacationTab.openVacationTab();
		employee.openNewVacationRequestTab();
		employee.openStartDateSelection();
		employee.selectDate(2018, "May", 18); // -->write the request start date
												// in format: YYYY, "---" , DD
		employee.openEndDateSelection();
		employee.selectDate(2018, "May", 18); // -->write the request end date
												// in format: YYYY, "---" , DD
		employee.createSickLeave(); // choose what kind of vacation you want :
									// .createSickLeave() ,
									// .createMaternityLeave() ,
									// .createVacationWithoutPayment()
								    // .createNewRequest() -> creates automatically a holiday vacation with data as parameter
		employee.saveTheRequest();

		// read email and check if the request was announced
		emailCon.readEmail(Constants.SITE, Constants.EVO_MAIL_DM_ADDRESS, Constants.EVO_MAIL_DM_PASSWORD);
		emailApp.checkIfEmailWasReceived("18/05/2018"); // -->write the request start date in format: DD/MM/YYYY										 
													
	}
}
