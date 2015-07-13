package com.steps;

import com.pages.AssignedToMeRequestsPage;
import com.pages.DMFirstPage;
import com.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

public class DMApproveRequestsSteps extends ScenarioSteps{
	AssignedToMeRequestsPage approveRequest;
	DMFirstPage firstPage;
	
	@Step
	public void check_last_request(){
		approveRequest.checkLastRequest();
	}
	
	@Step
	public void click_approve(){
		firstPage.clickApprove();
	}
	
	@Step
	public void succes_message_occurs(){
		approveRequest.checkIfSuccesMessageAppears();
	}

}
