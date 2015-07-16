package com.steps;

import com.pages.DMFirstPage;
import com.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class DMInboxAccessSteps extends ScenarioSteps {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	LoginPage loginPage;
	DMFirstPage dmFirstPage;

	@Step
	public void openVacationTab() {
		loginPage.openVacationTab();
	}

	@Step
	public void accessInbox() {
		dmFirstPage.accessInbox();
	}

	@Step
	public void checkIfInboxPageIsValid() {
		dmFirstPage.checkIfApproveButtonExists();
	}

}
