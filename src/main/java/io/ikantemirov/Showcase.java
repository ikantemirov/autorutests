package io.ikantemirov;

import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.ExtendedList;
import io.qameta.htmlelements.element.ExtendedWebElement;
import io.qameta.htmlelements.element.HtmlElement;

public interface Showcase extends ExtendedWebElement {

    @FindBy(".//div[@class='showcase__item-content']")
    ExtendedList showcaseItemContents();

}
