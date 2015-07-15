package com.steps;

import com.pages.BodyEmailAppearancePage;
import com.pages.EmailConnecting;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CheckEmailAppearanceSteps extends ScenarioSteps {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	EmailConnecting emailCon;
	BodyEmailAppearancePage emailApp;

	@Step
	public void getEmail(String site, String email, String pass) {
		emailCon.readLastEmail(site, email, pass);
	}

	@Step
	public void checkHolidayRequest(String startDate,String endDate) {
		emailApp.holidayVacationRequestEmployee(startDate,endDate);
	}
	
	@Step
	public void emailWasReceived(String data){
		emailApp.emailWasCreated(data);
	}
	
	//employee
	@Step
	public void emailWasReceivedEmployee(String data){
		emailApp.emailWasCreatedEmployee(data);
	}
}
