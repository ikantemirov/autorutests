package io.ikantemirov;

import io.qameta.htmlelements.WebPageFactory;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;
import static ru.yandex.qatools.matchers.webdriver.AttributeMatcher.attr;
import static ru.yandex.qatools.matchers.webdriver.DisplayedMatcher.displayed;
import static ru.yandex.qatools.matchers.webdriver.ExistsMatcher.exists;
import static ru.yandex.qatools.matchers.webdriver.TextMatcher.text;

public class AutoruTests {

    private WebDriver driver;
    private WebDriverWait wait;
    private WebPageFactory factory = new WebPageFactory();
    private PartsPage page;

    @Rule
    public RuleChrome ruleChrome = new RuleChrome();

    @Before
    public void before(){
        driver = ruleChrome.getDriver();
        page = factory.get(driver, PartsPage.class);
        page.go();
        driver.get("https://auto.ru/parts/");
    }

    @Test
    public void shouldOpenStartPage() {
        page.isAt(equalTo("https://auto.ru/parts/"));
    }

    @Test
    public  void shouldDisplayButton() {
        page.pageContent().mainSearcher().searchButton().should(displayed());
    }

    @Test
    public void shouldWriteQuery() {
        page.pageContent().mainSearcher().inputField().should(displayed());
    }

    @Test
    public  void  shouldDisplayShowcase() {
        page.pageContent().showcase().should(displayed());
    }

    @Test
    public void shouldOpenPopupModal() {
        page.pageContent().serp().filtersVehicle().waitUntil(displayed()).click();
        page.popupModal().waitUntil(displayed()).should(attr("aria-hidden", "false"));
    }

    @Ignore
    @Test
    public void shouldClosePopupModal () {
        page.pageContent().serp().filtersVehicle().waitUntil(displayed()).click();
        page.popupModal().modalClose().waitUntil(displayed()).click();
        page.popupModal().should(attr("aria-hidden", "true"));
    }

    @Test
    public void shouldSearchFerrariInPopupModal() {
        page.pageContent().serp().filtersVehicle().waitUntil(displayed()).click();
        page.popupModal().inputText().waitUntil(displayed()).sendKeys("Ferrari");
        page.popupModal().compatibilityItem().should(text("Ferrari"));
    }

    @Test
    public void shouldShowSubcategories() {
        page.pageContent().showcase().showcaseItemContents().get(0).linkPaddedShowcase().click();
        page.pageContent().subcategories().should(exists());
    }

    @Test
    public void shouldCountItemsPopCategories() {
        page.pageContent().popCategories().itemPopCategories().should(hasSize(25));
    }

    @Test
    public void shouldCountExtendedItemsPopCategories() {
        page.pageContent().popCategories().ewePopCategories().get(0).click();
        page.pageContent().popCategories().itemPopCategories().should(hasSize(93));
    }

    @Test
    public void shouldDisplayShowcaseItemContent() {
        page.pageContent().showcase().showcaseItemContents().should(hasSize(5));
    }
}
