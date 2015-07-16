package com.steps;

import com.pages.BodyEmailContentPage;
import com.pages.EmailConnecting;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CheckEmailContentSteps extends ScenarioSteps {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	EmailConnecting emailCon;
	BodyEmailContentPage emailApp;

	@Step
	public void getEmail(String site, String email, String pass) {
		emailCon.readLastEmailReceived(site, email, pass);
	}

	@Step
	public void checkEmailContentForHolidayRequest(String startDate,String endDate) {
		emailApp.holidayVacationRequestFollowsSpecificPattern(startDate,endDate);
	}
	
	@Step
	public void checkIfEmailWasReceived(String data){
		emailApp.emailWithNewVacationRequestWasReceivedByDM(data);
	}
	
	@Step
	public void checkIfEmailWasReceivedByEmployee(String data){
		emailApp.confirmationEmailForNewVacationRequestWasCreated(data);
	}
}
