package Suite1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class TestTopBarLinks {


    @Test
    void TestLinks() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://www.booking.com/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button[aria-label='Dismiss sign-in info.']")).click();
        Thread.sleep(1000);

        // Change Currency
        driver.findElement(By.cssSelector("button[aria-label='Prices in U.S. Dollar']")).click();
        Thread.sleep(1000);
        WebElement currencyResult = driver.findElements(By.cssSelector("button[data-testid='selection-item']")).stream()
                .filter(webElement -> webElement.getText().contains("Pound Sterlin"))
                .findFirst().get();
        currencyResult.click();
        Thread.sleep(1000);


        // Demo Currency Change
        WebElement element = driver.findElements(By.cssSelector("div[data-testid='webcore-carousel-heading']")).stream()
                .filter(webElement -> webElement.getText().contains("Homes guests"))
                .findFirst().get();

        js.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(2000);


        // Change Language
        driver.findElement(By.cssSelector("button[aria-label='Language: English (US)']")).click();
        Thread.sleep(2000);
        WebElement languageResult = driver.findElements(By.cssSelector("button[data-testid='selection-item']")).stream()
                .filter(webElement -> webElement.getText().contains("Español"))
                .findFirst().get();

        languageResult.click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[aria-label='Idioma: Español']")).click();
        languageResult = driver.findElements(By.cssSelector("button[data-testid='selection-item']")).stream()
                .filter(webElement -> webElement.getText().contains("English (UK"))
                .findFirst().get();
        languageResult.click();
        Thread.sleep(3000);

        // Test Customer Support button
        driver.findElement(By.cssSelector("a[aria-label='Customer support']")).click();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);


        // Test Property Button
        driver.findElement(By.cssSelector("a[data-testid='header-custom-action-button']")).click();
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(2000);


        // Test Register button
        driver.findElement(By.cssSelector("a[data-testid='header-sign-up-button']")).click();
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(2000);

        // Test Sign In button
        driver.findElement(By.cssSelector("a[aria-label='Sign in']")).click();
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(2000);


        driver.close();

    }

}
