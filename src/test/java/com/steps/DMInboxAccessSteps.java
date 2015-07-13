package com.steps;

import com.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

public class DMInboxAccessSteps extends ScenarioSteps{
	LoginPage loginPage;
	
	@Step
	public void openVacationTab(){
		loginPage.openVacationTab();
	}
}
