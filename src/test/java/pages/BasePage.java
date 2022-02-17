package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions action;

    static {
        System.setProperty("webdriver.chrome.driver","src/test/resources/windows/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, 10);
    }

    //Constructor
    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public static void navigateTo(String URL){
        driver.get(URL);
    }

    public static void closeBrowser(){
        driver.quit();
    }

    private WebElement findElement(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator){
        findElement(locator).click();
    }

    public void write(String locator, String textToWrite){
        findElement(locator).clear();
        findElement(locator).sendKeys(textToWrite);
    }

    public void writeInt(String locator, int intToWrite){
        findElement(locator).clear();
        findElement(locator).sendKeys(String.valueOf(intToWrite));
    }

    public void selectFromDropdownByValue(String locator, String valueToSelect){
        Select dropdown = new Select(findElement(locator));
        dropdown.selectByValue(valueToSelect);
    }

    public void selectFromDropdownByIndex(String locator, int valueToSelect){
        Select dropdown = new Select(findElement(locator));
        dropdown.selectByIndex(valueToSelect);
    }

    public void selectFromDropdownByVisibleText(String locator, String valueToSelect){
        Select dropdown = new Select(findElement(locator));
        dropdown.selectByVisibleText(valueToSelect);
    }

    public void hoverOverElement(String locator){
        action.moveToElement(findElement(locator));
    }

    public void doubleClick(String locator){
        action.doubleClick(findElement(locator));
    }

    public void rightClick(String locator){
        action.contextClick(findElement(locator));
    }

    public String getValuefromTable(String locator, int row, int column){
        String cellIneed = locator+"/table/tbody/tr["+row+"]/td["+column+"]";
        return findElement(cellIneed).getText();
    }

    public void setValueOnTable(String locator, int row, int column, String stringToSend){
        String cellToFill = locator+"/table/tbody/tr["+row+"]/td["+column+"]";
        findElement(cellToFill).sendKeys(stringToSend);
    }

    public void switchToiFrame(int iFrameIdIndex){
        driver.switchTo().frame(iFrameIdIndex);
    }

    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }

    public void dismissAlert(){
        try {
            driver.switchTo().alert().dismiss();
        }catch (NoAlertPresentException e){
            e.printStackTrace();
        }
    }

    public String textFromElement(String locator){
        return findElement(locator).getText();
    }

    public boolean elementIsDisplayed(String locator){
        return findElement(locator).isDisplayed();
    }

    public boolean elementIsEnabled(String locator){
        return findElement(locator).isEnabled();
    }

    public boolean elementIsSelected(String locator){
        return findElement(locator).isSelected();
    }

    public List<WebElement> bringMeAllElements(String locator){
        return driver.findElements(By.className(locator));
    }
}
