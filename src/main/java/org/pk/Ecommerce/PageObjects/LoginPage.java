package org.pk.Ecommerce.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.pk.Ecommerce.AbstractComponents.AbstractComponents;

public class LoginPage extends AbstractComponents {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="userEmail") WebElement userEmailInput;
	@FindBy(id="userPassword") WebElement userPasswordInput;
	@FindBy(id="login") WebElement loginBtn;
	@FindBy(css="[class*='flyInOut']") WebElement ToastMsg;
	
	
	public ProductCataloguePage loginApplication(String email,String password) {
		userEmailInput.sendKeys(email);
		userPasswordInput.sendKeys(password);
		loginBtn.click();
		return new ProductCataloguePage(driver);
	}
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	public String getToastMsg() {
		waitForWebElementToAppear(ToastMsg);
		return ToastMsg.getText();
	}
}
