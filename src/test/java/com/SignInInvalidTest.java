package com;

import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.UserSteps;

@RunWith(ThucydidesRunner.class)
public class SignInInvalidTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "http://172.22.4.88:9091/login")
    public Pages pages;

    @Steps
    UserSteps endUser;
    
    
    @Test
    public void sign_in_should_be_valid() {
        endUser.is_the_home_page();
		endUser.enters_data("daniela","evo.portal47");
		endUser.signsIn();
		endUser.error_message_occurs();

    }

} 