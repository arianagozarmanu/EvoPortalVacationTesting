package com.steps;

import com.pages.LoginPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import static ch.lambdaj.Lambda.join;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class UserSteps extends ScenarioSteps {

    LoginPage loginPage;

    @Step
    public void entersUserName(String keyword) {
        loginPage.enter_screenName(keyword);
    }

    @Step
    public void entersPassword(String keyword) {
        loginPage.enter_password(keyword);
    }

    @Step
    public void signsIn() {
        loginPage.login();
    }

    @Step
    public void is_the_home_page() {
        loginPage.open();
    }

    @Step
    public void sign_in_validation()
    {
    	loginPage.checkIfButtonExists();
    }
    
    @Step
    public void signsOut()
    {
    	loginPage.signout();	
    }
    
    @StepGroup
    public void enters_data(String term1, String term2) {
        entersUserName(term1);
        entersPassword(term2);
    }
    }
