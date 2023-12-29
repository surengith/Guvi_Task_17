package com.SeleniumPracticeTask17.org;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuildControlTool {

	public static void main(String[] args) throws InterruptedException {

		// Create a new instance of the ChromeDriver that includes WebDriver setup
		WebDriver driver = new ChromeDriver();

		// Maximizes the browser window
		driver.manage().window().maximize();

		// Creating a explicit wait class
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// Navigate to the https://www.snapdeal.com/
		driver.navigate().to("https://www.snapdeal.com/");

		// XPath for SignIn button
		WebElement signinButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Sign In')]")));

		// Creating Action class to perform the hold and move to the target element
		Actions act = new Actions(driver);
		act.moveToElement(signinButton).build().perform();

		// XPath for click the login button
		WebElement loginButton = driver
				.findElement(By.xpath("//a[@href='https://www.snapdeal.com/login'][contains(text(),'login')]"));
		loginButton.click();

		// Wait for 3 seconds and switching to frame from window
		Thread.sleep(3000);
		driver.switchTo().frame(0);

		// XPath for UserName
		WebElement userName = driver
				.findElement(By.xpath("//div[@class='iframeSignin']//descendant::input[@name='username']"));
		userName.sendKeys("surendharpalaniswamy@gmail.com");

		// XPath for clicking the continue button
		WebElement continueButton = driver
				.findElement(By.xpath("//button[@id='checkUser'][contains(text(),'continue')]"));
		continueButton.click();

		// Using explicit wait class for visibility of OTP screen
		WebElement otp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='screen2']")));

		// Using if condition to Print the successful message
		if (otp.getText().contains("surendharpalaniswamy@gmail.com")) {
			System.out.println("Successful, You are in correct page");
		} else {
			System.out.println("Unsuccessful, You are not in correct page");
		}

		// Wait for 3 seconds and Close the browser
		Thread.sleep(3000);

		driver.close();
	}
}
