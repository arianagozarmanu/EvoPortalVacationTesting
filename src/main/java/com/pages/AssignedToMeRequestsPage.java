package com.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import tools.Constants;
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

	@FindBy(css = "a[class*='aui-paginator-link aui-paginator-next-link']")
	private WebElementFacade nextPageButton;

	private static String data;

	public void checkLastRequest() {
		boolean first=lastRowFromTableRequest1.isPresent();
		boolean second=lastRowFromTableRequest2.isPresent();
		boolean exist = first || second ;
		
		if (exist) {
			if(first) {
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

	public void checkApproveRequest(String status){
		boolean exists=checkIfApproveRequestExists(status);
		Assert.assertTrue("Request does not exist!", exists);
	}
	
	public boolean checkIfApproveRequestExists(String status) {

		while (nextPageButton.isPresent()) {
			List<WebElement> dataList = getDriver()
					.findElements(By.cssSelector("tr[class*='portlet-section-'] td:nth-child(1) a"));
			List<WebElement> statusList = getDriver()
					.findElements(By.cssSelector("tr[class*='portlet-section-'] td:nth-child(6) a"));
			for (int i = 0; i < dataList.size(); i++) {
				if (dataList.get(i).getText().equals(data)) {
					if (statusList.get(i).getText().equals(status)) {
						return true;
					}
				}
				System.out.println(dataList.get(i).getText());
			}
			clickNextPageButton();
			waitABit(500);
			getDriver().navigate().refresh();
		}
		return false;
	}
	
	public void setData(String newData) {
		data=newData;
	}
}
