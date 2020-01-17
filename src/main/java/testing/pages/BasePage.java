package testing.pages;

import testing.baseTest.TestBase;

public abstract class BasePage {

    TestBase testBase = new TestBase();

    protected abstract boolean isLoaded();
}
