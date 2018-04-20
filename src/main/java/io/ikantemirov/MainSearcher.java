package io.ikantemirov;

import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.HtmlElement;

public interface MainSearcher extends HtmlElement {

    @FindBy(".//input[@class='input__field']")
    HtmlElement inputField();

    @FindBy(".//button[contains(@class, 'searcher__button ')]")
    HtmlElement searchButton();
}
