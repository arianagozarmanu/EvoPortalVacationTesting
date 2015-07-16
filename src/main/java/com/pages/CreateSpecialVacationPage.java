package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;

public class CreateSpecialVacationPage extends PageObject {

    @FindBy(css = "[id*=_CS]")
    private WebElementFacade newSpecialVacation;
    
    @FindBy(css = "[name='specialReason'] [value='MARRIAGE']")
    private WebElementFacade marriageVacation;
    
    @FindBy(css = "[name='specialReason'] [value='CHILD_BIRTH']")
    private WebElementFacade childBirthVacation;
    
    @FindBy(css = "[name='specialReason'] [value='FUNERAL']")
    private WebElementFacade funeralVacation;
    
    @FindBy(css = ".portlet-msg-success")
    private WebElementFacade statusOfRequest;
    
    public void requestSpecialVacation() {
    	newSpecialVacation.click();
    }
    
    public void VacationForMarriage() {
    	marriageVacation.click();
    }
    
    public void VacationForChildBirth() {
    	childBirthVacation.click();
    }
    
    public void VacationForFuneral() {
    	funeralVacation.click();
    }
    
    public void requestWasCreated(){
    	boolean found = false;
    	if(statusOfRequest.isPresent()){
    		found = true;
    	}
    	Assert.assertTrue("Child Birth Vacation request created", found);
    }
		
}
    