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

import com.steps.UserSteps;

@RunWith(ThucydidesRunner.class)
public class SignInInvalidTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = Constants.EVO_URL)
    public Pages pages;

    @Steps
    UserSteps endUser;
    
    
    @Test
    public void sign_in_should_be_valid() {
        endUser.is_the_home_page();
		endUser.enters_data(Constants.VALID_SCREEN_NAME,Constants.INVALID_PASSWORD);
		endUser.signsIn();
		endUser.sign_in_validation();
		endUser.signsOut();

    }

} 