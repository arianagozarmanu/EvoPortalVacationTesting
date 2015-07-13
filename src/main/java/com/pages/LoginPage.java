package com.pages;

import org.junit.Assert;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;


public class LoginPage extends PageObject {

    @FindBy(name="_58_login")
    private WebElementFacade screenName;

    @FindBy(name="_58_password")
    private WebElementFacade password;
    
    @FindBy(css = "input[class='aui-button-input aui-button-input-submit']")
    private WebElementFacade signInButton;
    
    @FindBy(css = "ul[class='main-menu'] a[href*='/vacation']")
    private WebElementFacade vacationButton;
    
    @FindBy(css = "a[href*='/logout']")
    private WebElementFacade signOutButton;

    @FindBy(css = "div.portlet-msg-error")
    private WebElementFacade errorMessage;
    
    public void enter_screenName(String keyword) {
        screenName.type(keyword);
    }
    
    public void enter_password(String keyword) {
        password.type(keyword);
    }

    public void login() {
        signInButton.click();
    }
    
    public void signout(){
    	signOutButton.click();
    }
    
    public void checkIfButtonExists(){
    	boolean found = false;
    	if(vacationButton.isPresent()){
    		found = true;
    	}
    	Assert.assertTrue("Vacation button not found", found);
    }
    
    public void checkIfErrorAppears(){
    	boolean found = false;
    	if(errorMessage.isPresent()){
    		found = true;
    	}
    	Assert.assertTrue("Error message does not appear", found);
    }
    
    public void openVacationTab(){
    	vacationButton.click();
    }

  
}
    