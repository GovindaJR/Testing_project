package Suite1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestSearchFiltering {


    @Test
    void searchFiltering() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.booking.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button[aria-label='Dismiss sign-in info.']")).click();

        // Complete Search Form
        driver.findElement(By.cssSelector("input[placeholder='Where are you going?']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"indexsearch\"]/div[2]/div/div/form/div[1]/div[1]/div/div/div[2]/ul/li[1]/div/div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"indexsearch\"]/div[2]/div/div/form/div[1]/div[4]/button")).click();
        Thread.sleep(1000);


        driver.findElement(By.className("efdb2b543b")).click();
        Thread.sleep(1000);

        // Sustainability Filter
        driver.findElement(By.cssSelector("input[id=':R2nkkq:']")).click();
        Thread.sleep(2000);

        // 5 Star Filter
        js.executeScript("window.scrollBy(0, 600)");
        Thread.sleep(1000);
        driver.findElement(By.id(":Ranksq:")).click();
        Thread.sleep(2000);


        // Resort Filter
        js.executeScript("window.scrollBy(0, 1500)");
        Thread.sleep(1000);
        driver.findElement(By.id(":Ra7lsq:")).click();
        Thread.sleep(1000);

        // Dropdown
        driver.findElement(By.cssSelector("button[data-testid='sorters-dropdown-trigger']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button[data-id='bayesian_review_score']")).click();
        Thread.sleep(2000);

        driver.close();

    }

}
