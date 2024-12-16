package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SimpleElements {

    private WebDriver driver;

    public SimpleElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement loginText(){
        return driver.findElement(By.xpath("//h3[text()='Login']"));
    }

    public WebElement slider(){
        return driver.findElement(By.xpath("//*[@id=\"sliderContainer\"]/div[1]/span/input"));
    }
}
