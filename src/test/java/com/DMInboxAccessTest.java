package com;

import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.serenitybdd.junit.runners.SerenityRunner;
import tools.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import com.steps.DMInboxAccessSteps;
import com.steps.UserSteps;

@RunWith(SerenityRunner.class)
public class DMInboxAccessTest {

	@Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = Constants.EVO_URL)
    public Pages pages;

    @Steps
    public UserSteps endUser;
    @Steps
    public DMInboxAccessSteps dmInboxAccessSteps;
    
    @Issue("InboxAccessing")
    
    @Test
    public void dM_can_access_inbox_item(){
    	endUser.is_the_home_page();
    	endUser.enters_data(Constants.DM_SCREEN_NAME, Constants.DM_PASSWORD);
    	endUser.signsIn();
    	dmInboxAccessSteps.openVacationTab();
    	dmInboxAccessSteps.accessInbox();
    	dmInboxAccessSteps.approve_button_appears();
    }
}
