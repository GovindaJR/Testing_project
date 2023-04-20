package Suite2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Taxis {
    WebDriver driver;

    //Booking Flight
    @Test
    public void taxis() throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://www.booking.com");
        driver.manage().window().maximize();

        //close ad
        Thread.sleep(2000);
        WebElement closeButton = driver.findElement(By.xpath("//button[@aria-label='Dismiss sign-in info.']"));
        closeButton.click();

        Thread.sleep(1000);
        WebElement element = driver.findElement(By.id("airport_taxis"));
        element.click();


        // Search fort myers
        Thread.sleep(2000);
        WebElement pickupLocationInput = driver.findElement(By.id("pickupLocation"));
        pickupLocationInput.sendKeys("london");

        Thread.sleep(1500);
        WebElement buttonElement = driver.findElement(By.className("rw-autocomplete__link"));
        buttonElement.click();

        Thread.sleep(1500);
        WebElement dropoffLocation = driver.findElement(By.id("dropoffLocation"));
        dropoffLocation.sendKeys("germany");

        Thread.sleep(1500);
        WebElement button = driver.findElement(By.cssSelector("button.rw-autocomplete__link[data-test='rw-autocomplete__link--0']"));
        button.click();

        Thread.sleep(1000);
        WebElement pickupDateField = driver.findElement(By.xpath("//button[@aria-label='pickup date input field' and @data-test='rw-date-field__link--pickup']"));
        pickupDateField.click();

        Thread.sleep(1000);
        WebElement button4 = driver.findElement(By.cssSelector("button.rw-c-date-picker__btn.rw-c-date-picker__btn--next[data-test='rw-date-picker__btn--next']"));
        button4.click();

        Thread.sleep(1000);
        WebElement button5 = driver.findElement(By.cssSelector("button.rw-c-date-picker__btn.rw-c-date-picker__btn--next[data-test='rw-date-picker__btn--next']"));
        button5.click();

        Thread.sleep(1000);
        WebElement taxis = driver.findElement(By.xpath("//a[contains(@class, 'rw-c-date-picker__calendar-cell--link') and contains(@aria-label, '9, June 2023')]"));
        taxis.click();

        Thread.sleep(1000);
        //Search click
        WebElement button3 = driver.findElement(By.cssSelector("button.gb-c-search-form__submit-button"));
        button3.click();

        Thread.sleep(12000);
        WebElement linkElement = driver.findElement(By.xpath("//a[contains(@href,'aid=304142')]"));
        linkElement.click();

        Thread.sleep(2000);
        driver.quit();
    }

}

