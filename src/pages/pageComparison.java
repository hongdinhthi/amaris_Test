package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageComparison {
    private static WebElement element = null;

    public static WebElement insurance_link(WebDriver driver){
        element = driver.findElement(By.xpath("//a[contains(@href, '#Insurance')]"));
        return element;
    }

    public static WebElement travel_tab(WebDriver driver){
        element = driver.findElement(By.xpath("//div[@id='Insurance']/div/ul/li[2]/a"));
        return element;
    }

    public static WebElement show_My_Result_btn(WebDriver driver){
        element = driver.findElement(By.xpath("//button[@name='product-form-submit']//link[@class='rippleJS']"));
        return element;
    }


}
