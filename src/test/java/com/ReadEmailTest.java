package com;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;






import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import tools.Constants;





import com.pages.EmailConnecting;
import com.steps.CreateSpecialVacationSteps;
import com.steps.CreateVacationSteps;
import com.steps.DMInboxAccessSteps;
import com.steps.EmailConnectingSteps;
import com.steps.UserSteps;

@RunWith(SerenityRunner.class)

public class ReadEmailTest{

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
    EmailConnectingSteps email;

    @Test
    public void readEmail() {
    	email.readEmail();
    }


}