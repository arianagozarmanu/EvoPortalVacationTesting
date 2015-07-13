package com.pages;

import ch.lambdaj.function.convert.Converter;
import net.thucydides.core.annotations.DefaultUrl;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

import java.util.List;

import static ch.lambdaj.Lambda.convert;


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

  
}
    