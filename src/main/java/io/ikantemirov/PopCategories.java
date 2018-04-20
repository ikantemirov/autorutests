package io.ikantemirov;

import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.ExtendedList;
import io.qameta.htmlelements.element.ExtendedWebElement;
import io.qameta.htmlelements.element.HtmlElement;


public interface PopCategories extends ExtendedWebElement {

    @FindBy("//a[@class='link pop-categories__item']")
    ExtendedList<ItemPopCategory> itemPopCategories();

    @FindBy("//span[@class='link pop-categories__item']")
    ExtendedList<EwePopCategory> ewePopCategories();

}
