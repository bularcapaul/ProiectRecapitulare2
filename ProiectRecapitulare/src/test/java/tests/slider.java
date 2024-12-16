package tests;

import Actions.SimpleActions;
import WebElements.SimpleElements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utile.BaseTest;

import java.time.Duration;

public class slider extends BaseTest {

    private SimpleActions simpleActions;
    private Wait<WebDriver> wait;

    @Test
    public void sliderTest(){

        simpleActions = new SimpleActions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
driver.manage().window().maximize();
        WebElement slider = driver.findElement(By.xpath("//*[@id=\"js-filter-6411-collapse\"]/div[2]/div[2]/div[1]/a[2]"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2500)", "");
        wait.until(d-> slider.isDisplayed());
        Actions action = new Actions(driver);
        action.dragAndDropBy(slider, -145,0).perform();
        action.dragAndDropBy(slider, 10,0);

    }
}
