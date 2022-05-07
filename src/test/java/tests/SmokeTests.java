package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTests extends BaseTest{

    private static final long WAITING_TIME = 100;

    @Test
    public void testHomePageComponents(){
        getHomePage().waitForPageLoadComplete(WAITING_TIME);
        Assert.assertFalse(getHomePage().isTitleEmpty());
        Assert.assertTrue(getHomePage().isTitleCorrect());
        Assert.assertTrue(getHomePage().isPromotionBannerDisplayed());
        getHomePage().clickUkrainianLangButton();
        getHomePage().titleWait(WAITING_TIME);
        Assert.assertTrue(getHomePage().isTitleUkrainian());
        Assert.assertEquals(getHomePage().catalogItemsCount(), 14);
    }

    @Test
    public void testSearchField(){
        getHomePage().waitForPageLoadComplete(WAITING_TIME);
        getHomePage().implicitWait(30);
        getHomePage().enterTextToSearchField(getSearchResultPage().getSearchInput());
        getSearchResultPage().doSearchResultsContainInputWords();
    }
}
