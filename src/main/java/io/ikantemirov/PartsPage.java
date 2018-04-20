package io.ikantemirov;

import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.extension.page.BaseUrl;

@BaseUrl("https://auto.ru/parts/")
public interface PartsPage extends WebPage{

    @FindBy("//div[@class='page__content-left']")
    PageContent pageContent();

}
