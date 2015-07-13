package com.steps;

import com.pages.LoginPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

public class UserSteps extends ScenarioSteps {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
    public void error_message_occurs()
    {
    	loginPage.checkIfErrorAppears();
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
