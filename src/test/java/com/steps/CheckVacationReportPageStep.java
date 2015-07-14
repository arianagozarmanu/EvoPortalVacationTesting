package com.steps;

import com.pages.AssignedToMeRequestsPage;
import com.pages.DMFirstPage;
import com.pages.DMVacationsReportPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CheckVacationReportPageStep extends ScenarioSteps{

	DMVacationsReportPage vacReportPage;
	
	@Step
	public void openVacationReportTab(){
		vacReportPage.openVacationReportTab();
	}
	
	@Step
	public void getTotalFreeDays(){
		vacReportPage.getTotalFreeDays();
	}
	
	@Step
	public void typeName(String lastName, String firstName){
		vacReportPage.typeName(lastName,firstName);
	}
}
