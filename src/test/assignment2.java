package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static java.lang.Thread.sleep;
import java.util.*;
import org.openqa.selenium.interactions.Actions;

import pages.pageComparison;
import pages.pageTravelResults;

public class assignment2 {
    public static WebDriver driver = null;

    public static void doAssignment2() {
        System.out.println(" ---- Step 1: Go to Gobear web link  -----");
        System.setProperty("webdriver.chrome.driver", "/Users/dinhthihong/Documents/GobearAssessment/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.gobear.com/ph?x_session_type=UAT");
        wait5000();
        pageComparison.insurance_link(driver).click();
        pageComparison.travel_tab(driver).click();
        wait5000();
        pageComparison.show_My_Result_btn(driver).isDisplayed();
        pageComparison.show_My_Result_btn(driver).click();
        wait5000();

        System.out.println("---- Step 2: Click Cancel on popup Coverage ----- ");
        pageTravelResults.cancel_popup_Coverage(driver).isDisplayed();
        pageTravelResults.cancel_popup_Coverage(driver).click();
        wait5000();
        System.out.println("---- Step 3: Click Got it on popup Help -----");
        pageTravelResults.got_it_popupHelp(driver).isDisplayed();
        pageTravelResults.got_it_popupHelp(driver).click();

        // Verify there are at least 3 cards
        System.out.println(" ---- Step 4: Verify at least 3 cards are displayed  -----");
        verifyAtLeast3CardsAreDisplayed();

        // Verify there are 3 categories
        System.out.println(" ---- Step 5: Verify there are 3 categories: Filter, Sort and Details  -----");
        pageTravelResults.cat_Details(driver).isDisplayed();
        pageTravelResults.cat_Filter(driver).isDisplayed();
        pageTravelResults.cat_Sort(driver).isDisplayed();

        /// Test at least 1 option per option
        System.out.println(" ---- Step 6: Try to check Filter category by trying select Promos only radiobutton  -----");
        pageTravelResults.radio_PromoOnly(driver).click();
        wait5000();
        verifyPromosOnlyResultText();
        System.out.println(" ---- Step 7: Try to click on See More, See Less buttons  -----");
        pageTravelResults.link_SeeMore(driver).click();
        wait5000();
        pageTravelResults.link_SeeLess(driver).click();

        System.out.println(" ---- Step 8: Try to select option Price Low to High on SORT then verify the prices are displayed in right order  ----");
        wait5000();
        new Actions(driver).moveToElement(pageTravelResults.radio_PriceLowToHigh(driver)).click().perform();
        verifyPriceLowToHigh();

        System.out.println(" ---- Step 9: Try to click on Annual Trip on Details option  ----");
        new Actions(driver).moveToElement(pageTravelResults.radio_AnnualTrip(driver)).click().perform();
        wait5000();
        pageTravelResults.text_AnnualTrip(driver).isDisplayed();

        driver.close();

    }

    public static void verifyAtLeast3CardsAreDisplayed()
    {
        List<WebElement> eleCards = driver.findElements(By.xpath("//div[@class = 'card-brand']"));
        if(eleCards.size() >= 3)
        {
            System.out.println("PASSED: Number of cards are greater than 3 ");
        }
        else
        {
            System.out.println("FAILED: Number of cards are less than 3 ");
        }

    }

    public static void verifyPromosOnlyResultText()
    {
        pageTravelResults.result_PromoOnly_text(driver).isDisplayed();
        String act_Text = pageTravelResults.result_PromoOnly_text(driver).getText();
        if(act_Text.equalsIgnoreCase("No plans match your filter criteria…"))
        {
            System.out.println("PASSED: Promos only radio button works properly ");
        }
        else
        {
            System.out.println("FAILED: There is something wrong with Promos Only radio ");
        }
        pageTravelResults.radio_ShowAll(driver).click();
    }

    public static void verifyPriceLowToHigh(){
        List<WebElement> elePrices = driver.findElements(By.xpath("//div[@class='policy-price']"));
        for( int i=1; i < elePrices.size(); i++ )
        {

            String startPrice;
            String nextPrice;
            startPrice = elePrices.get(i-1).getAttribute("premium");
            nextPrice = elePrices.get(i).getAttribute("premium");
            Integer startP = Integer.parseInt(startPrice);
            Integer nextP= Integer.parseInt(nextPrice);
            if (startP > nextP)
            {
                System.out.println("FAILED: The price is not in the right order" + "check these prices" + startPrice +" and "+ nextPrice);
            }
            ///// I'm sorry when I doing the comparison like that, if I have more time I will integrate with TestNG or JUnit to use Assert/Veriy.....
        }

    }

    public static void wait5000()
    {
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
