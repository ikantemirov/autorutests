package io.ikantemirov;

import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.HtmlElement;

public interface PopupModal extends HtmlElement{

    @FindBy(".//i[contains(@class, 'FiltersVehicle__compatibility-modal-close')]")
    HtmlElement modalClose();

    @FindBy(".//input[@class='compatibility__query-text']")
    HtmlElement inputText();

    @FindBy(".//span[@class='compatibility__item-title']")
    HtmlElement compatibilityItem();
}
