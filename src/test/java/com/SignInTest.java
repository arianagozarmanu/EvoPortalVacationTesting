package com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import com.steps.LoginSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.UseTestDataFrom;
import tools.Constants;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("/resources/accounts.csv")
public class SignInTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = Constants.EVO_URL)
	public Pages pages;

	@Steps
	public LoginSteps endUser;

	String username, password;

	@Issue("SignIn")

	@Test
	public void sign_in() {
		endUser.is_the_home_page();
		endUser.enters_data(username, password);
		endUser.signsIn();
		endUser.sign_in_validation();
		endUser.signsOut();

	}

}