package com.steps;

import com.pages.AssignedToMeRequestsPage;
import com.pages.DMFirstPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class DMApproveRequestsSteps extends ScenarioSteps {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	AssignedToMeRequestsPage approveRequest;
	DMFirstPage firstPage;

	@Step
	public void check_last_request() {
		approveRequest.checkLastRequest();
	}

	@Step
	public void click_approve() {
		firstPage.clickApprove();
	}

	@Step
	public void succes_message_occurs() {
		approveRequest.checkIfSuccesMessageAppears();
	}
	
	@Step
	public void request_is_approved(String status) {
		approveRequest.checkApproveRequest(status);
	}
	
	@Step
	public void show_75_requests_per_page() {
		approveRequest.show75RequestsPerPage();
	}

}
