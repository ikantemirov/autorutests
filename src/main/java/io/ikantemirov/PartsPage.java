package io.ikantemirov;

import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.extension.page.BaseUrl;

@BaseUrl("https://auto.ru/parts/")
public interface PartsPage extends WebPage{

    @FindBy("//body")
    PageContent pageContent();

    @FindBy(".//div[contains(@class, 'FiltersVehicle__compatibility-modal')]")
    PopupModal popupModal();

}
