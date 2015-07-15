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





import com.steps.CreateSpecialVacationSteps;
import com.steps.CreateVacationSteps;
import com.steps.DMApproveRequestsSteps;
import com.steps.DMInboxAccessSteps;
import com.steps.UserSteps;

@RunWith(SerenityRunner.class)
public class CreateSpecialVacationTest {

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
    CreateSpecialVacationSteps specialRequest;
    @Steps
    DMApproveRequestsSteps validation;
    
    
    
    @Test
    public void create_Vacation() throws ParseException {
        endUser.is_the_home_page();
		endUser.enters_data(Constants.VALID_SCREEN_NAME,Constants.VALID_PASSWORD);
		endUser.signsIn();
		vacationTab.openVacationTab();
		employee.createNewRequest(2016,"Nov",24,2016,"Nov",24);
		specialRequest.selectSpecialVacation();
		specialRequest.takeVacationForChildBirth();
		employee.saveTheRequest();
		specialRequest.verifyIfSpecialVacationCreated();
		employee.openMyRequestsTab();
		validation.request_is_approved(Constants.PENDING_MSG);
		endUser.signsOut();
    }

} 