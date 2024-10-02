package cucumber;

import managers.PageObjectManager;
import managers.WebDriverManagerTwo;
import utility.Utility;

public class TestContext {

    private WebDriverManagerTwo webDriverManagerTwo;
    private PageObjectManager pageObjectManager;
    private Utility utility;

    public TestContext(){
        webDriverManagerTwo = new WebDriverManagerTwo();
        pageObjectManager = new PageObjectManager(webDriverManagerTwo.createDriver());
        utility = new Utility();
    }

    public WebDriverManagerTwo getWebDriverManagerTwo(){
        return webDriverManagerTwo;
    }

    public PageObjectManager getPageObjectManager(){
        return pageObjectManager;
    }

    public Utility getUtility(){
        return utility;
    }

}
