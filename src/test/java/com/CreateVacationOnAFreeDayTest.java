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
import com.steps.UserSteps;

@RunWith(SerenityRunner.class)
public class CreateVacationOnAFreeDayTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = Constants.EVO_URL)
    public Pages pages;

    @Steps
    UserSteps endUser;
    @Steps
    CreateVacationSteps employee; 
    @Steps
    DMInboxAccessSteps vacationTab;
    @Steps
    DMApproveRequestsSteps validation;
    
    @Test
    public void create_Vacation() throws ParseException {
		endUser.logIn(Constants.VALID_SCREEN_NAME,Constants.VALID_PASSWORD);
		vacationTab.openVacationTab();
		employee.openNewVacationRequestTab();
		employee.startingDate();
		employee.selectDate(2016, "Dec", 26);
		
		employee.convertDateIntoString();
		
		employee.endingDate();
		employee.selectDate(2016, "Dec", 26);
		employee.saveTheRequest();
		endUser.signsOut();
		
		endUser.logIn(Constants.DM_SCREEN_NAME,Constants.DM_PASSWORD);
		vacationTab.openVacationTab();
		vacationTab.accessInbox();
		
		validation.request_is_approved_on_a_free_day("Holiday");
		endUser.signsOut();
    }

} 