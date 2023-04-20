package Suite2;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class flight {


    //Booking Flight
    @Test
    public void testFlightDetails() throws InterruptedException {
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

        Thread.sleep(1000);
        WebElement oneWayRadioBtn = driver.findElement(By.id("search_type_option_ONEWAY"));
        oneWayRadioBtn.click();

        // Search fort myers
        Thread.sleep(1000);
        WebElement button = driver.findElement(By.cssSelector("button.css-1ovag24"));
        button.click();

        Thread.sleep(1000);
        WebElement searchInput = driver.findElement(By.cssSelector("input.css-1ejj2j9"));
        searchInput.sendKeys("rsw");

        Thread.sleep(1500);
        WebElement element = driver.findElement(By.className("css-1of7gk4"));
        element.click();

        // Search London
        Thread.sleep(1000);
        WebElement button2 = driver.findElement(By.xpath("//button[@data-ui-name='input_location_to_segment_0']"));
        button2.click();

        Thread.sleep(1000);
        WebElement searchInput2 = driver.findElement(By.cssSelector("input.css-1ejj2j9"));
        searchInput2.sendKeys("lhr");

        Thread.sleep(1500);
        WebElement element2 = driver.findElement(By.cssSelector("li.css-1of7gk4[data-ui-name='locations_list_item'][tabindex='0']"));
        element2.click();

        Thread.sleep(1000);
        //Select Date
        WebElement button3 = driver.findElement(By.xpath("//button[@data-ui-name='button_date_segment_0']"));
        button3.click();

        Thread.sleep(1000);
        WebElement button4 = driver.findElement(By.cssSelector("button.Actionable-module__root___lQCcK.Button-module__root--variant-tertiary___MhiYJ.Calendar-module__control--next___N9ipu"));
        button4.click();
        Thread.sleep(500);
        button4.click();

        Thread.sleep(1000);
        WebElement calendar = driver.findElement(By.xpath("//span[@data-date='2023-08-01']"));
        calendar.click();

        Thread.sleep(1000);
        WebElement searchButton = driver.findElement(By.cssSelector("button[data-ui-name='button_search_submit']"));
        searchButton.click();

        Thread.sleep(7000);
        //Select flight
        WebElement seeFlightButton = driver.findElement(By.cssSelector("button[data-testid='flight_card_bound_select_flight']"));
        seeFlightButton.click();

        Thread.sleep(10000);
        WebElement selectButton = driver.findElement(By.xpath("//button[contains(@class, 'Button-module__root--variant-primary') and contains(@class, 'Button-module__root--variant-primary-action') and .//span[text()='Select']]"));
        selectButton.click();

        // Economy flight
        Thread.sleep(3000);
        WebElement nextButton = driver.findElement(By.xpath("//button[contains(@class, 'Button-module__root--variant-primary-action___yZcy0') and contains(@class, 'Button-module__root--wide-true___FST6k')]"));
        //WebElement nextButton = driver.findElement(By.cssSelector("button[class='Actionable-module__root___lQCcK Button-module__root___puEjU Button-module__root--variant-primary___rQ8Eq Button-module__root--size-large___Oef9C Button-module__root--wide-true___FST6k Button-module__root--variant-primary-action___yZcy0']"));
        nextButton.click();

        // Final Page
        Thread.sleep(15000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll down by 500 pixels
        js.executeScript("window.scrollBy(0,500)");

        Thread.sleep(2000);
        WebElement contactEmailInput = driver.findElement(By.className("InputText-module__control___NM4s-"));
        WebElement phoneNumberInput = driver.findElement(By.xpath("//input[@class='InputText-module__control___NM4s-' and @name='number']"));
        WebElement firstNameInput = driver.findElement(By.name("passengers.0.firstName"));
        WebElement lastNameInput = driver.findElement(By.name("passengers.0.lastName"));

        contactEmailInput.sendKeys("softwaretesting10420@gmail.com");
        phoneNumberInput.sendKeys("111-222-3333");
        firstNameInput.sendKeys("Peter");
        lastNameInput.sendKeys("Hernandez");

        // Dropdown Element
        WebElement dropdown = driver.findElement(By.name("passengers.0.gender"));
        // Create a Select object from the dropdown element
        Select select = new Select(dropdown);
        // Select the first option
        select.selectByIndex(1);

        Thread.sleep(1000);

        WebElement dateInput = driver.findElement(By.cssSelector("input[name='passengers.0.birthDate'][date-type='day']"));
        dateInput.sendKeys("01");

        WebElement yearInput = driver.findElement(By.xpath("//input[@id='passengers.0.birthDate' and @date-type='year']"));
        yearInput.sendKeys("2000");

        Thread.sleep(1000);

        // Month
        WebElement dropdown2 = driver.findElement(By.cssSelector("select[name='passengers.0.birthDate'][date-type='month']"));
        dropdown2.click();
        Thread.sleep(1000); // Wait for dropdown options to load
        dropdown2.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(500); // Wait for next option to highlight
        dropdown2.sendKeys(Keys.ENTER);


        Thread.sleep(2000);
        // Find the elements that display the flight details
        WebElement tripType = driver.findElement(By.xpath("//*[@id='basiclayout']/div/div[2]/div/div[1]/div/div[1]/div[1]"));
        WebElement passengerCount = driver.findElement(By.xpath(" //*[@id='basiclayout']/div/div[2]/div/div[1]/div/div[1]/div[3]"));
        WebElement travelDate = driver.findElement(By.xpath(" //*[@id=\"basiclayout\"]/div/div[2]/div/div[1]/div/div[1]/div[5]"));

        // Extract the text from the elements
        String actualTripType = tripType.getText();
        String actualPassengerCount = passengerCount.getText();
        String actualTravelDate = travelDate.getText();

        // Compare the actual values to the expected values
        Assert.assertTrue(actualTripType.contains("One-way") || actualTripType.contains("One way"));
        Assert.assertTrue(actualPassengerCount.contains("1 traveler") || actualPassengerCount.contains("1 traveller"));
        Assert.assertTrue(actualTravelDate.contains("Tue, Aug 1") || actualTravelDate.contains("Tue 1 Aug"));

        WebElement citiesElement = driver.findElement(By.xpath("//div[contains(@class,'')][contains(text(),'Miami to London')]"));
        Assert.assertTrue(citiesElement.isDisplayed());

        js.executeScript("window.scrollBy(0,-500)");

        WebElement linkElement = driver.findElement(By.xpath("//a[contains(@href,'aid=304142')]"));
        linkElement.click();

        Thread.sleep(2000);
        driver.close();

    }
}

