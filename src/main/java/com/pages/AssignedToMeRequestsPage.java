package com.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class AssignedToMeRequestsPage extends PageObject {

	@FindBy(css = "tr[class*='portlet-section-body results-row last']")
	private WebElementFacade lastRowFromTableRequest1;
	
	@FindBy(css = "tr[class*='portlet-section-alternate results-row alt last']")
	private WebElementFacade lastRowFromTableRequest2;

	@FindBy(css = "tr[class*='portlet-section-body results-row last'] input[name*='rowIds']")
	private WebElementFacade lastRowCheckBox1;
	
	@FindBy(css = "tr[class*='portlet-section-alternate results-row alt last'] input[name*='rowIds']")
	private WebElementFacade lastRowCheckBox2;
	
	@FindBy(css = "div[class='portlet-msg-success']")
	private WebElementFacade succesMessage;

	@FindBy(css = "tr[class*='portlet-section-body results-row last'] td:nth-child(3) a")
	private WebElementFacade dataElement1;
	
	@FindBy(css = "tr[class*='portlet-section-alternate results-row alt last'] td:nth-child(3) a")
	private WebElementFacade dataElement2;

	@FindBy(css = "select[class*='aui-field-input-menu'] option[value='75']")
	private WebElementFacade maxRequestsPerPage;

	@FindBy(css = "span[class*='aui-paginator-next-link']")
	private WebElementFacade nextPageButton;

	private static String data;

	public void checkLastRequest() {
		boolean exist = lastRowFromTableRequest1.isPresent() || lastRowFromTableRequest2.isPresent();
		
		if (exist) {
			if(lastRowFromTableRequest1.isPresent()) {
				lastRowCheckBox1.click();
				data = dataElement1.getText();
			}
			else {
				lastRowCheckBox2.click();
				data = dataElement2.getText();
			}
			
			System.out.println(data);
		} else {
			Assert.assertTrue("Last row of the table does not appear", exist);
		}
	}

	public void checkIfSuccesMessageAppears() {
		Assert.assertTrue("DM is not able to approve a request", succesMessage.isPresent());
	}

	public void show75RequestsPerPage() {
		maxRequestsPerPage.click();
	}
	
	public void clickNextPageButton(){
		nextPageButton.click();
	}

	public void checkIfApproveRequestExists() {
		boolean exists = false;
		
		//while (nextPageButton.isPresent()) {  
			List<WebElement> dataList = getDriver()
					.findElements(By.cssSelector("tr[class*='portlet-section-'] td:nth-child(1) a"));
			List<WebElement> statusList = getDriver()
					.findElements(By.cssSelector("tr[class*='portlet-section-'] td:nth-child(6) a"));
			for (int i = 0; i < dataList.size(); i++) {
				if (dataList.get(i).getText().equals(data)) {
					if (statusList.get(i).getText().equals("Approved")) {
						exists = true;
					}
				}
				// System.out.println(dataList.get(i).getText());
			}
			//clickNextPageButton();
		//}
		Assert.assertTrue("Request does not exist!", exists);
	}
}