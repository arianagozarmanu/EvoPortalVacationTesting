package com.steps;

import com.pages.EmailConnecting;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class EmailConnectingSteps extends ScenarioSteps {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	EmailConnecting emailCon;

	@Step
	public void readEmail(String site, String email, String pass) {
		emailCon.readLastEmailReceived(site, email, pass);
	}

}
