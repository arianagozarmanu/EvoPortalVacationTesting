package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;


public class CreateVacationPage extends PageObject {

    @FindBy(css = "a[href*='menuItem=new-request']")
    private WebElementFacade newVacationRequest;
    
    @FindBy(css = "[id*='startDate']")
    private WebElementFacade startDate;
    
    @FindBy(css = "[id*='endDate']")
    private WebElementFacade endDate;
    
    @FindBy(css = ".aui-button-content [id*='saveButton']")
    private WebElementFacade saveRequest;
    
    @FindBy(css = "div.carousel-slider li a[href*='menuItem=my-requests']")
    private WebElementFacade myRequests;
    
    @FindBy(css = ".portlet-msg-error")
    private WebElementFacade createVacationError;
    
    @FindBy(css = "[id*='_CF']")
    private WebElementFacade vacationWithoutPayment;
    
    @FindBy(css = "[id*='_CM']")
    private WebElementFacade sickLeave;
    
    @FindBy(css = "[id*='_ML']")
    private WebElementFacade maternityLeave;
    
    public void openNewVacationRequestTab() {
    	newVacationRequest.click();
    }
    
    public void selectStartDate() {
        startDate.click();
    }
    
    public void selectEndDate() {
        endDate.click();
    }
    
    public void saveTheRequest() {
        saveRequest.click();
    }
    
    public void openMyRequestsTab() {
        myRequests.click();
    }
    
    public void cannotCreateVacationRequest(){
    	boolean found = false;
    	if(createVacationError.isPresent()){
    		found = true;
    	}
    	Assert.assertTrue("You already have a vacation set up overlaping the selected time range", found);
    }
    
    public void createVacationWithoutPayment(){
    	vacationWithoutPayment.click();
    }
    
    public void createSickLeave(){
    	sickLeave.click();
    }
    
    public void createMaternityLeave(){
    	maternityLeave.click();
    }
   
  
}
    