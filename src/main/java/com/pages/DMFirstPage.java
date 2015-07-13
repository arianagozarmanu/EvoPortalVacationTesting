package com.pages;

import org.junit.Assert;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class DMFirstPage extends PageObject{

	@FindBy(css ="a[href*='menuItem=inbox']")
	private WebElementFacade inboxItem;
	
	@FindBy(id="_evovacation_WAR_EvoVacationportlet_multipleApproveButton")
	private WebElementFacade approveButton;
	
	public void accessInbox(){
		inboxItem.click();
	}
	
	public void checkIfApproveButtonExists(){
		Assert.assertTrue("Approve button does not appear", approveButton.isPresent());
	}
	
	public void clickApprove(){
		approveButton.click();
	}
}
