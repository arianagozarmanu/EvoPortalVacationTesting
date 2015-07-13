package com;

import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import tools.Constants;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.CreateVacationInAFreeLegalDaySteps;
import com.steps.DMInboxAccessSteps;
import com.steps.UserSteps;

@RunWith(ThucydidesRunner.class)
public class CreateVacationInAFreeLegalDayTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = Constants.EVO_URL)
    public Pages pages;

    @Steps
    UserSteps endUser;
    @Steps
    CreateVacationInAFreeLegalDaySteps employee; 
    @Steps
    DMInboxAccessSteps vacationTab;
    
    
    @Test
    public void create_Vacation() {
        endUser.is_the_home_page();
		endUser.enters_data(Constants.VALID_SCREEN_NAME,Constants.VALID_PASSWORD);
		endUser.signsIn();
		vacationTab.openVacationTab();
		employee.openNewVacationRequestTab();
		employee.startingDate();
		employee.endingDate();
		employee.saveTheRequest();
		employee.invalidSelectionOfDates();
    }

} 