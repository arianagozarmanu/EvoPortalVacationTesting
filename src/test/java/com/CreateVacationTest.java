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
public class CreateVacationTest {

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
        endUser.is_the_home_page();
		endUser.enters_data(Constants.VALID_SCREEN_NAME,Constants.VALID_PASSWORD);
		endUser.signsIn();
		vacationTab.openVacationTab();
		employee.openNewVacationRequestTab();
		employee.startingDate();
		employee.selectDate(2015, "Nov", 17);
		
		employee.convertDateIntoString();
		
		employee.endingDate();
		employee.selectDate(2015, "Nov", 17);
		employee.saveTheRequest();
		employee.openMyRequestsTab();
		validation.request_is_approved(Constants.PENDING_MSG);
		endUser.signsOut();
    }

} 