package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage{

    private String searchInput = "nvidia rtx";

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[contains(@class, 'br10')]/descendant::a[contains(@class, 'link line')]")
    private List<WebElement> searchResults;

    public String getSearchInput(){
        return searchInput;
    }
    public boolean doSearchResultsContainInputWords(){
        String [] inputWords = searchInput.split("\\W+");
        for (var i: searchResults){
            for (var j: inputWords) {
                if (!i.toString().contains(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}

