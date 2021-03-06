package com.steps;

import java.text.ParseException;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;
import com.pages.CreateVacationPage;
import com.pages.DatePickerPage;

public class CreateVacationSteps extends ScenarioSteps {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	CreateVacationPage createVacation;
	DatePickerPage datePickerPage;

	@Step
	public void selectDate(int year, String month, int day) {
		datePickerPage.selectDate(year, month, day);
	}

	@Step
	public void openNewVacationRequestTab() {
		createVacation.openNewVacationRequestTab();
	}

	@Step
	public void openStartDateSelection()
	{
		createVacation.selectStartDate();
	}

	@Step
	public void openEndDateSelection()
	{
		createVacation.selectEndDate();
	}

	@Step
	public void saveTheRequest()
	{
		createVacation.saveTheRequest();
	}

	@Step
	public void invalidSelectionOfDates()
	{
		createVacation.cannotCreateVacationRequest();
	}

	@Step
	public void openMyRequestsTab()
	{
		createVacation.openMyRequestsTab();
	}
	
	@Step
	public void createVacationWithoutPayment(){
		createVacation.createVacationWithoutPayment();
	}
	
	@Step
	public void createSickLeave(){
		createVacation.createSickLeave();
	}
	
	@Step
	public void createMaternityLeave(){
		createVacation.createMaternityLeave();
	}
	
	@StepGroup
	public void convertDateIntoString() throws ParseException{
		datePickerPage.convertMonthToInteger();
		datePickerPage.convertDate();
		
	}
	
	@StepGroup
	public void createNewRequest(int startYear, String startMonth, int startDay, int endYear, String endMonth, int endDay) throws ParseException{
		openNewVacationRequestTab();
		openStartDateSelection();
		selectDate(startYear, startMonth, startDay);
		convertDateIntoString();
		openEndDateSelection();
		selectDate(endYear, endMonth, endDay);
	}

}
