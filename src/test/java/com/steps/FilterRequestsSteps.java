package com.steps;

import com.pages.FilterRequestsPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class FilterRequestsSteps extends ScenarioSteps{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	FilterRequestsPage filterReq;
	
	@Step
	public void selectFilters(String type, String number, String status){
		filterReq.selectFilters(type,number,status);
	}
	
	@Step
	public void applyFilters(){
		filterReq.applyFilters();
	}
	
	@Step
	public void validateFilter(String type, String number, String status){
		filterReq.validateAppliedFilters(type, number, status);
	}
	
}
