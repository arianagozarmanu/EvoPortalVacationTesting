/**
 * Test if a vacation created in National Free Days
 * does not appear in the Inbox tab of the DM
 */
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
import com.steps.CreateVacationSteps;
import com.steps.DMApproveRequestsSteps;
import com.steps.DMInboxAccessSteps;
import com.steps.LoginSteps;

@RunWith(SerenityRunner.class)
public class CreateVacationOnAFreeDayTest {

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
    
    @Test
    public void national_free_day_vacation_request_is_not_created() throws ParseException {
    	
    	//create request
		user.logIn(Constants.VALID_SCREEN_NAME,Constants.VALID_PASSWORD);
		vacationTab.openVacationTab();
		employee.openNewVacationRequestTab();
		employee.openStartDateSelection();
		employee.selectDate(2027, "Dec", 01);
		employee.convertDateIntoString();
		employee.openEndDateSelection();
		employee.selectDate(2027, "Dec", 01);
		employee.saveTheRequest();
		user.signsOut();
		
		//check DM's Inbox
		user.logIn(Constants.DM_SCREEN_NAME,Constants.DM_PASSWORD);
		vacationTab.openVacationTab();
		vacationTab.accessInbox();
		validation.findRequestsByType("Holiday");
		user.signsOut();
    }

} 