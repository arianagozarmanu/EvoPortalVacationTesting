/**
 * Test if a vacation request with implicit settings
 * is created, selecting just the start and end date
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
public class CreateVacationTest {

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
    public void create_holiday_request() throws ParseException {
		user.logIn(Constants.VALID_SCREEN_NAME,Constants.VALID_PASSWORD);
		vacationTab.openVacationTab();
		employee.openNewVacationRequestTab();
		employee.openStartDateSelection();
		employee.selectDate(2021, "May", 04);
		employee.convertDateIntoString();
		employee.openEndDateSelection();
		employee.selectDate(2021, "May", 04);
		employee.saveTheRequest();
		employee.openMyRequestsTab();
		validation.show_75_requests_per_page();
		validation.checkStatusOfTheRequest(Constants.PENDING_MSG);
		user.signsOut();
    }

} 