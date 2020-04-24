package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageTravelResults {
    private static WebElement element = null;

    public static WebElement cat_Details(WebDriver driver){
        element = driver.findElement(By.id("detailsHeading"));
        return element;
    }
    public static WebElement cat_Filter(WebDriver driver){
        element = driver.findElement(By.id("collapseFilterBtn"));
        return element;
    }
    public static WebElement cat_Sort(WebDriver driver){
        element = driver.findElement(By.xpath("//span[@class='fa fa-sort' and normalize-space(contains(text(),'SORT'))]"));
        return element;
    }

    public static WebElement cancel_popup_Coverage(WebDriver driver){
        element = driver.findElement(By.xpath("//div[@id='step-0']/div[3]/button/link"));
        return element;
    }
    public static WebElement got_it_popupHelp(WebDriver driver){
        element = driver.findElement(By.xpath("//div[4]/button/link"));
        return element;
    }

    public static WebElement radio_PromoOnly(WebDriver driver){
        element = driver.findElement(By.xpath("//div[@data-filter-name='Promos Only']"));
        return element;
    }
    public static WebElement radio_ShowAll(WebDriver driver){
        element = driver.findElement(By.xpath("//div[@data-filter-name='Show All']"));
        return element;
    }
    public static WebElement result_PromoOnly_text(WebDriver driver){
        element = driver.findElement(By.xpath("//div[@id='travel-quote-list']/div[2]/div[2]/div/p"));
        return element;
    }
    public static WebElement link_SeeMore(WebDriver driver){
        element = driver.findElement(By.xpath("//a[@class='btn-ripple more']//link[@class='rippleJS']"));
        return element;
    }
    public static WebElement link_SeeLess(WebDriver driver){
        element = driver.findElement(By.xpath("//a[@class='btn-ripple less']//link[@class='rippleJS']"));
        return element;
    }
    public static WebElement radio_PriceLowToHigh(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id='gb_radio_3']"));
        return element;
    }

    public static WebElement radio_AnnualTrip(WebDriver driver){
        element = driver.findElement(By.id("gb_radio_10"));
        return element;
    }
    public static WebElement text_AnnualTrip(WebDriver driver){
        element = driver.findElement(By.xpath("//div[@data-gb-trip-types='annual']"));
        return element;
    }

}
