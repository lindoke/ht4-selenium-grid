package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Objects;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final String TITLE = "Интернет-магазин Цитрус — гаджеты и аксессуары | Citrus.ua";
    private final String UK_TITLE = "Цитрус - інтернет-магазин гаджетів та аксесуарів";

    @FindBy(xpath = "//a[@class='df jcc full-height link-0-2-20']")
    private WebElement promotionBanner;

    @FindBy(xpath = "//span[contains(@class,'currentCity')]")
    private WebElement openCityListButton;

    @FindBy(xpath = "//a[text()='УКР']")
    private WebElement ukrainianLangButton;

    @FindBy(xpath = "//li[contains(@class, 'city')]")
    private List<WebElement> representedCitiesPopup;

    @FindBy(xpath = "//div[contains(@class, 'pa cup')")
    private WebElement closeCityListPopupButton;

    @FindBy(xpath = "//span[contains(@class, 'ml8 dashed-text')]/ancestor::button")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@placeholder='Поиск']")
    private WebElement searchField;

    @FindBy(xpath = "//div[contains(@class, 'menuIcon-0-2')]")
    private List<WebElement> catalogItems;


    public void titleWait(long timeToWait){
        WebDriverWait wait = new WebDriverWait(driver,timeToWait);
        wait.until(ExpectedConditions.titleContains(UK_TITLE));
    }

    public boolean isPromotionBannerDisplayed(){
        return promotionBanner.isDisplayed();
    }

    public int catalogItemsCount(){
        return catalogItems.size();
    }

    public void clickUkrainianLangButton(){
        ukrainianLangButton.click();
    }

    public boolean isTitleEmpty(){
        return driver.getTitle().isEmpty();
    }

    public boolean isTitleCorrect(){
        return Objects.equals(driver.getTitle(), TITLE);
    }

    public boolean isTitleUkrainian(){
        System.out.println(driver.getTitle());
        return Objects.equals(driver.getTitle(), UK_TITLE);
    }

    public void enterTextToSearchField(final String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText, Keys.ENTER);
    }
}
