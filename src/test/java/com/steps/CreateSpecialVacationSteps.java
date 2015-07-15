package com.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;




import com.pages.CreateSpecialVacationPage;


public class CreateSpecialVacationSteps extends ScenarioSteps {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	CreateSpecialVacationPage createSpecialVacation;

	@Step
	public void selectSpecialVacation()
	{
		createSpecialVacation.requestSpecialVacation();
	}

	@Step
	public void takeVacationForChildBirth()
	{
		createSpecialVacation.VacationForChildBirth();
	}
	
	@Step
	public void takeVacationForMarriage()
	{
		createSpecialVacation.VacationForMarriage();
	}
	
	@Step
	public void takeVacationForFuneral()
	{
		createSpecialVacation.VacationForFuneral();
	}

	@Step
	public void verifyIfSpecialVacationCreated()
	{
		createSpecialVacation.requestCreated();
	}
}
