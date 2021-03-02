package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PlayersPage {

    public WebDriver driver;
    private static String PAGE_URL = "https://www.pgatour.com/";

    public PlayersPage(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
    }

    public WebElement getPlayerPage() {
        WebElement element = driver.findElement(By.cssSelector(".nav-container >ul >li a[href=\"https://www.pgatour.com/players.html\"]"));
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element1 = wait.until(ExpectedConditions.visibilityOf(element));
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(element1));
        return element2;
    }

    public WebElement getSearchField() {
        return driver.findElement(By.cssSelector(".directory-search .input-field"));

    }

    public WebElement getSearchButton() {
        WebElement element = driver.findElement(By.cssSelector(".directory-search .btn-search"));
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element1 = wait.until(ExpectedConditions.visibilityOf(element));
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(element1));
        return element2;
    }

    public String getResultsTitle() {
        return driver.findElement(By.cssSelector(".results-title")).getText();

    }

    public String getNoResultsTitle() {
        return driver.findElement(By.cssSelector(".no-results")).getText();

    }

}
