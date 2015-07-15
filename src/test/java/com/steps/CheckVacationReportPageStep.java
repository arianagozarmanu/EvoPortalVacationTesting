package com.steps;

import com.pages.DMVacationsReportPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

public class CheckVacationReportPageStep extends ScenarioSteps {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DMVacationsReportPage vacReportPage;

	@Step
	public void openVacationReportTab() {
		vacReportPage.openVacationReportTab();
	}

	@Step
	public void getTotalFreeDays() {
		vacReportPage.getTotalFreeDays();
	}

	@Step
	public void typeName(String lastName, String firstName) {
		vacReportPage.typeName(lastName, firstName);
	}

	@Step
	public void clickSearchButton() {
		vacReportPage.clickSearchButton();
	}

	@Step
	public void accessUser() {
		vacReportPage.accessUser();
	}

	@Step
	public void clickReject() {
		vacReportPage.clickRejectButton();
	}

	@Step
	public void checkOneRequest(String lastName, String firstName) {
		vacReportPage.checkOneRequest(lastName, firstName);
	}

	@Step
	public void compareTotalFreeDays() {
		vacReportPage.compareTotalFreeDays();
	}

	@StepGroup
	public void searchUser(String lastName, String firstName) {
		openVacationReportTab();
		typeName(lastName, firstName);
		clickSearchButton();
	}

}
