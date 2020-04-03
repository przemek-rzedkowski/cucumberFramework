package com.cucumberFramework.baseTest;


import com.cucumberFramework.support.WaitHelper;
import com.cucumberFramework.support.WebElementHelper;

public abstract class BasePage {

    protected WaitHelper waitHelper;
    protected WebElementHelper element;

    public abstract boolean isPageDisplayed();

}
