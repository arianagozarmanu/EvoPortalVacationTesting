package com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.EmailConnectingSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import tools.Constants;

@RunWith(SerenityRunner.class)
public class ReadEmailTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = Constants.EVO_URL)
	public Pages pages;

	@Steps
	EmailConnectingSteps email;

	@Test
	public void readEmail() {
		email.readEmail(Constants.SITE, Constants.EVO_MAIL_ADDRESS, Constants.EVO_MAIL_PASSWORD);
	}

}