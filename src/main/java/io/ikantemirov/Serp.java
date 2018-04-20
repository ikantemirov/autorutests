package io.ikantemirov;

import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.HtmlElement;

public interface Serp extends HtmlElement {

    @FindBy(".//span[@class='link FiltersVehicle__select-button']")
    FiltersVehicle filtersVehicle();

}
