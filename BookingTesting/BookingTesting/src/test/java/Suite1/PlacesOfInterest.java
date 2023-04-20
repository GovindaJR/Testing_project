package Suite1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PlacesOfInterest {


    //Find place of interest
    @Test
    public void POI() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.booking.com");
        driver.manage().window().maximize();

        //close ad
        Thread.sleep(2000);
        WebElement closeButton = driver.findElement(By.xpath("//button[@aria-label='Dismiss sign-in info.']"));
        closeButton.click();

        // click places of interest
        Thread.sleep(1000);
        driver.findElement(By.partialLinkText("Places of interest")).click();
        Thread.sleep(1000);

        // click Hotels near Times Square
        driver.findElement(By.partialLinkText("Hotels near Times Square")).click();
        Thread.sleep(1000);

        // click LUMA Hotel
        driver.findElement(By.partialLinkText("LUMA Hotel")).click();
        Thread.sleep(1000);

        // open map
        driver.findElement(By.xpath("//*[@id=\"hotel_sidebar_static_map\"]/div/button")).click();
        //driver.findElement(By.xpath("/html/body/div[3]/div/div[5]/div[1]/div[1]/div[1]/div/div[1]/div[3]/a/div/button")).click();
        Thread.sleep(7000);

        // close maps
        driver.navigate().back();
        Thread.sleep(1500);

        Thread.sleep(2000);
        driver.close();

    }
}

