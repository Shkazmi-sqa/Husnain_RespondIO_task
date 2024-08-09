package pageFactory;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericFunctions {
    public void waitForVisibility(WebDriver driver, WebElement element) throws Error{
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void clickOnWebElement(WebDriver driver,WebElement element)
    {
        clickOnWebElement(driver, element);

    }

    public String generateRandomUser()
    {   String randomeuser=null;
        String s = RandomStringUtils.randomAlphanumeric(12);
        randomeuser= s + "@gmail.com";
        return randomeuser;
    }


}
