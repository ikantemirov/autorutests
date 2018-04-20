package io.ikantemirov;

import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.HtmlElement;

public interface ShowcaseItemContent extends HtmlElement {

    @FindBy("//a[@class='link link_padded showcase__item-name']")
    LinkPaddedShowcase linkPaddedShowcase();
}
