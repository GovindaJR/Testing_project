package Suite2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;

public class TestFindAttractions {

    @Test
    public void testAttractionsPage() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Get to Attractions Page
        driver.get("https://www.booking.com/");
        driver.findElement(By.id("attractions")).click();
        driver.manage().window().maximize();

        // Enter City
        driver.findElement(By.name("query")).sendKeys("New York");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/div/div/div[3]/div/div/div/div[2]/ul[1]/li[3]")).click();

        // Enter Date
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/div/div/div[3]/div/div/div/div[1]/form/div[2]/div")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("span[data-date='2023-04-26']")).click();

        // Select Attraction
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/div/div/div[3]/div/div/div/div/form/button")).click();
        Thread.sleep(4000);
        driver.findElement(By.partialLinkText("SUMMIT One")).click();
        Thread.sleep(4000);

        // Select Time and Tickets
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        js.executeScript("window.scrollBy(0, 800)");
        driver.findElement(By.cssSelector("button[class='fc63351294 a822bdf511 e3c025e003 fa565176a8 f7db01295e c334e6f658 e1b7cfea84 d64a4ea64d']")).click();
        driver.findElement(By.cssSelector("button[class='fc63351294 a822bdf511 d4b6b7a9e7 f7db01295e c938084447 f4605622ad']")).click();

        Thread.sleep(4000);

        // Customer Details
        driver.findElement(By.name("firstName")).sendKeys("test_first_name");
        Thread.sleep(500);
        driver.findElement(By.name("lastName")).sendKeys("test_last_name");
        Thread.sleep(500);
        driver.findElement(By.name("email")).sendKeys("test101@email.com");
        Thread.sleep(500);
        js.executeScript("window.scrollBy(0, 200)");
        driver.findElement(By.name("emailConfirm")).sendKeys("test101@email.com");
        Thread.sleep(500);
        driver.findElement(By.name("phone__number")).sendKeys("1111111111");

        Thread.sleep(2000);

        Assert.assertEquals(driver.getTitle(), "SUMMIT One Vanderbilt Tickets New York – Booking.com");
        driver.get("https://www.booking.com/");

        String originalHandle = driver.getWindowHandle();

        for(String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
                driver.close();
        }


    }


}