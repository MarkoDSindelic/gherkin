package cucumber;

import managers.PageObjectManager;
import managers.WebDriverManagerTwo;

public class TestContext {

    private WebDriverManagerTwo webDriverManagerTwo;
    private PageObjectManager pageObjectManager;

    public TestContext(){
        webDriverManagerTwo = new WebDriverManagerTwo();
        pageObjectManager = new PageObjectManager(webDriverManagerTwo.createLocalDriver());
    }

    public WebDriverManagerTwo getWebDriverManagerTwo(){
        return webDriverManagerTwo;
    }

    public PageObjectManager getPageObjectManager(){
        return pageObjectManager;
    }

}
