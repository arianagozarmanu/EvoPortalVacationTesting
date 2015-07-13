package com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.UserSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import tools.Constants;

@RunWith(SerenityRunner.class)
public class SignInValidTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = Constants.EVO_URL)
    public Pages pages;

    @Steps
    public UserSteps endUser;

    @Issue("SignIn-ValidCredentials")
    
    @Test
    public void sign_in_should_be_valid() {
        endUser.is_the_home_page();
		endUser.enters_data(Constants.VALID_SCREEN_NAME,Constants.VALID_PASSWORD);
		endUser.signsIn();
		endUser.sign_in_validation();
		endUser.signsOut();

    }

} 