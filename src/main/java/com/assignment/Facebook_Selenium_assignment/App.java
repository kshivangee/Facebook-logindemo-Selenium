package com.assignment.Facebook_Selenium_assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Hello World!");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.getTitle();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		WebElement email = driver.findElement(By.name("email"));
		WebElement password = driver.findElement(
				By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[1]/div[2]/div/input"));
		WebElement loginButton = driver.findElement(By.cssSelector("button"));
		Thread.sleep(5000);
		email.sendKeys("shivangee123@gmail.com");
		Thread.sleep(5000);
		password.sendKeys("shivangee");
		Thread.sleep(5000);
		loginButton.click();
		Thread.sleep(5000);
		TakesScreenshot screenshot = ((TakesScreenshot) driver);
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("/Temp/output_screenshot.jpg");
		FileUtils.copyFile(srcFile, destFile);
		driver.quit();
    }
}
