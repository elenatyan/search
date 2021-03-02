package features;

import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import steps.PlayerSteps;

import java.util.concurrent.TimeUnit;


public class PlayerSearchTest {
    WebDriver driver;

    @Steps
    PlayerSteps playerSteps;

    @Before
    public void setup() {
        ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @Test
    public void testPlayerSearch() {
        playerSteps = new PlayerSteps(driver);
        playerSteps.getPlayersPage();
        playerSteps.setSearchFieldText("Tiger");
        playerSteps.clickSearchButton();
        playerSteps.checkResult();
        playerSteps.clearSearchResult();
        playerSteps.setSearchFieldText("ix.co");
        playerSteps.clickSearchButton();
        playerSteps.checkAnotherResult();
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

}
