package org.pk.Ecommerce.Test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ApplyJob {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.naukri.com/mnjuser/recommendedjobs");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.cssSelector("#usernameField")).sendKeys("pradeep.kulal45@gmail.com");
		driver.findElement(By.cssSelector("#passwordField")).sendKeys("p@9900141852");
		driver.findElement(By.xpath("//button[@class='waves-effect waves-light btn-large btn-block btn-bold blue-btn textTransform']")).click();
		List<WebElement> jobList=driver.findElements(By.className("jobTuple bgWhite z-depth-1 "));
		for(WebElement job:jobList) {
			String jobName=driver.findElement(By.className("title ellipsis typ-16Bold")).getText();
			driver.findElement(By.xpath("//span[contains(text(),'1-3 Yrs')]")).click();
		}
	}

}
