package io.ikantemirov;

import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.HtmlElement;

public interface PageContent extends HtmlElement {

    @FindBy(".//div[@class='searcher searcher_type_serp']")
    MainSearcher mainSearcher();

    @FindBy("//div[@class='showcase']")
    Showcase showcase();

    @FindBy("//div[@class='pop-categories']")
    PopCategories popCategories();

    @FindBy("//div[@class='serp']")
    Serp serp();

    @FindBy("//div[@class='subcategories']")
    Subcategories subcategories();

}
