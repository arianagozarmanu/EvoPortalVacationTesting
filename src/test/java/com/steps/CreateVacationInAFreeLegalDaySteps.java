package com.steps;

import com.pages.CreateVacationInAFreeLegalDayPage;
import com.pages.LoginPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import static ch.lambdaj.Lambda.join;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class CreateVacationInAFreeLegalDaySteps extends ScenarioSteps {

	CreateVacationInAFreeLegalDayPage createVacation;


    @Step
    public void openNewVacationRequestTab() {
        createVacation.openNewVacationRequestTab();
    }


    @Step
    public void startingDate()
    {
    	createVacation.selectStartDate();
    }
    
    @Step
    public void endingDate()
    {
    	createVacation.selectEndDate();
    }
    
    @Step
    public void saveTheRequest()
    {
    	createVacation.saveTheRequest();
    }
    
    @Step
    public void invalidSelectionOfDates()
    {
    	createVacation.cannotCreateVacationRequest();
    }
    
    @Step
    public void openMyRequestsTab()
    {
    	createVacation.openMyRequestsTab();
    }
    
   
    }
