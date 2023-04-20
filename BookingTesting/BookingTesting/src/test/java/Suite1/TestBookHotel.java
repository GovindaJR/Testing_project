package Suite1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TestBookHotel {


    @Test
    public void testHotelBooking() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://www.booking.com");
        driver.manage().window().maximize();

        //close ad
        Thread.sleep(2000);
        WebElement closeButton = driver.findElement(By.xpath("//button[@aria-label='Dismiss sign-in info.']"));
        closeButton.click();

        // search Hotels in Miami
        Thread.sleep(1000);
        driver.findElement(By.className("ce45093752")).sendKeys("Miami");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button[class='d47738b911 e246f833f7 fe211c0731']")).click();
        driver.findElement(By.xpath("//*[@id=\"indexsearch\"]/div[2]/div/div/form/div[1]/div[4]/button")).click();

        // Select Date
        driver.findElement(By.cssSelector("span[data-date='2023-05-22']")).click();
        driver.findElement(By.cssSelector("button[class='fc63351294 a822bdf511 d4b6b7a9e7 f7db01295e c938084447 f4605622ad c827b27356']")).click();
        Thread.sleep(1000);

        // Click hotel
        driver.findElement(By.partialLinkText("citizenM")).click();

        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        Thread.sleep(4000);

        js.executeScript("window.scrollBy(0, 1500)");

        WebElement elem = driver.findElement(By.name("nr_rooms_750837401_371401508_2_2_0"));
        Select sel = new Select(elem);
        sel.selectByIndex(1);
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("button[class='txp-bui-main-pp bui-button bui-button--primary  hp_rt_input px--fw-cta js-reservation-button']")).click();

        driver.findElement(By.name("firstname")).sendKeys("test_firstname");
        Thread.sleep(1000);
        driver.findElement(By.name("lastname")).sendKeys("test_lastname");
        Thread.sleep(1000);
        driver.findElement(By.id("email")).sendKeys("testtesttest123@email.com");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button[name='book']")).click();
        Thread.sleep(1000);

        driver.close();

    }
}
