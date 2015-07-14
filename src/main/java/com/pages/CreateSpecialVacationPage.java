package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

import org.junit.Assert;


public class CreateSpecialVacationPage extends PageObject {

    @FindBy(css = "[id*=_CS]")
    private WebElementFacade newSpecialVacation;
    
    @FindBy(css = "[name='specialReason'] [value='CHILD_BIRTH']")
    private WebElementFacade childBirthVacation;
    
    @FindBy(css = "align-to-left vacation-icon status-icon")
    private WebElementFacade statusOfRequest;
    
    public void requestSpecialVacation() {
    	newSpecialVacation.click();
    }
    
    public void VacationForChildBirth() {
    	childBirthVacation.click();
    }
    
    public void requestCreated(){
    	boolean found = false;
    	if(statusOfRequest.isPresent()){
    		found = true;
    	}
    	Assert.assertTrue("Child Birth Vacation request created", found);
    }
		
}
    