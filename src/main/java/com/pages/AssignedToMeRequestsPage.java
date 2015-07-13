package com.pages;

import org.junit.Assert;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class AssignedToMeRequestsPage extends PageObject{

	@FindBy(css="tr[class*='portlet-section-body results-row last']")
	private WebElementFacade lastRowFromTableRequest;
	
	@FindBy(css="tr[class*='portlet-section-body results-row last'] input[name*='rowIds']")
	private WebElementFacade lastRowCheckBox;
	
	@FindBy(css="div[class='portlet-msg-success']")
	private WebElementFacade succesMessage;
	
	public void checkLastRequest(){
		boolean exist=lastRowFromTableRequest.isPresent();
		if(exist){
			lastRowCheckBox.click();
		}
		else {
			Assert.assertTrue("Lats row of the table does not appear", exist);
		}
	}
	
	public void checkIfSuccesMessageAppears(){
		Assert.assertTrue("DM is not able to approve a request", succesMessage.isPresent());
	}
}

