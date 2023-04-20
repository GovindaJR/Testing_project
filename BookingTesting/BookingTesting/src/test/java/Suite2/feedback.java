package Suite2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class feedback {

@Test
    public void feedbackDetails() throws InterruptedException {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://www.booking.com");
        driver.manage().window().maximize();

        Thread.sleep(1000);
        WebElement closeButton = driver.findElement(By.xpath("//button[@aria-label='Dismiss sign-in info.']"));
        closeButton.click();

        Thread.sleep(1000);
        WebElement flightsLink = driver.findElement(By.id("flights"));
        flightsLink.click();

        Thread.sleep(2000);
        WebElement feedbackElement = driver.findElement(By.xpath("//div[@class='Text-module__root--variant-body_2___-3fYM css-1dprdok']//span[contains(text(),'Give feedback')]"));
        feedbackElement.click();

        Thread.sleep(2000);
        // locate the iframe element
        WebElement iframeElement = driver.findElement(By.cssSelector("div.Overlay-module__root___ER67K iframe.css-18j3dwn"));

        // switch to the iframe
        driver.switchTo().frame(iframeElement);


        Thread.sleep(2000);
        // Find the radio button element by its ID
        WebElement radioButton = driver.findElement(By.id("sgE-90239131-1-2-10014"));

// Click the radio button
        radioButton.click();

        WebElement inputBox = driver.findElement(By.cssSelector("div.sg-question-options textarea.sg-input-essay"));
        inputBox.click();
        inputBox.sendKeys("This is a good website.");

        Thread.sleep(2000);
        WebElement submitButton = driver.findElement(By.id("sg_SubmitButton"));
        submitButton.click();

        Thread.sleep(2000);
        driver.close();
    }

}

