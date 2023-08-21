package org.pk.Ecommerce.Test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssesmentTest {
	ExtentReports extent;
	@BeforeMethod
	public void config() {
		//ExtentReports, ExtentSparkReporter
		ExtentSparkReporter reporter=new ExtentSparkReporter(System.getProperty("user.dir")+"\\reports\\index.html");
		reporter.config().setReportName("Assesment Test");
		reporter.config().setDocumentTitle("Extent reports");
		 extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester Name", "Pradeep");
	}
@Test	
 public void Test(){
	
		ExtentTest test= extent.createTest("Test");
		String product1="ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("pradeep.k@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Pradeep@9900");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-lg-4")));
		List<WebElement> products=driver.findElements(By.cssSelector(".col-lg-4"));
		
		for(WebElement product:products) {
			String name=product.findElement(By.cssSelector(".card-body h5")).getText();
			if(name.equalsIgnoreCase(product1)) {
				product.findElement(By.cssSelector(".card-body button:last-of-type")).click();
			}
		}
		
//		WebElement prod = products.stream().filter(product-> 
//		product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(product1)).findFirst().orElse(null);
	//	prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		WebElement webElement=	driver.findElement(By.xpath("(//button[@class='btn btn-custom'])[3]"));
		JavascriptExecutor js = (JavascriptExecutor)driver; 
        js.executeScript("arguments[0].click();", webElement);
		List<WebElement> cartProducts= driver.findElements(By.cssSelector(".cartSection h3"));

		for(WebElement cartItems:cartProducts) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cartSection h3")));
			String name=cartItems.findElement(By.xpath("//div[@class='cartSection']/h3")).getText();
			if(name.equalsIgnoreCase(product1)) {
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		test.addScreenCaptureFromBase64String(product1);
		extent.flush();
		
		
}

}
