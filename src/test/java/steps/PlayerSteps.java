package steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.PlayersPage;

public class PlayerSteps {
    public WebDriver driver;
    PlayersPage playersPage;

    public PlayerSteps(WebDriver driver) {
        this.driver = driver;
        this.playersPage = new PlayersPage(driver);
    }

    @Step("Open Players Page")
    public void getPlayersPage() {
        playersPage.getPlayerPage().click();
    }

    @Step("Search to Search Field")
    public void setSearchFieldText(String value) {
        playersPage.getSearchField().sendKeys(value);
        ;
    }

    @Step("Click on Search Field")
    public void clickSearchButton() {
        playersPage.getSearchButton().click();
    }

    @Step("Check that search result matches to expected result")
    public void checkResult() {
        String SearchResult = "We have found 1 result matching \"Tiger\"";
        Assert.assertTrue(SearchResult, SearchResult.equals(playersPage.getResultsTitle()));
    }

    @Step("Clear Search Result")
    public void clearSearchResult() {
        playersPage.getSearchField().clear();
    }

    @Step("Check that  in case when no result found appropriate message is displayed")
    public void checkAnotherResult() {
        String SearchResult = "Sorry, there are no results matching ix.co";
        Assert.assertTrue(SearchResult, SearchResult.equals(playersPage.getNoResultsTitle()));
    }
}
