package io.ikantemirov;

import io.qameta.htmlelements.WebPageFactory;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.core.IsEqual.equalTo;
import static ru.yandex.qatools.matchers.webdriver.DisplayedMatcher.displayed;

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
    public  void  shouldDisplayShowcase() {
        page.pageContent().showcase().should(displayed());
    }

    @Test
    public void shouldDisplayShowcaseItemContent() {
        page.pageContent().showcase().showcaseItemContents().should(arrayWithSize(5));
    }

    @Test
    public void shouldWriteQuery() {
        page.pageContent().mainSearcher().inputField().should(displayed());// not work .sendKeys("111");
    }



}
