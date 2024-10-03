package cucumber;

import managers.PageObjectManager;
import managers.CustomWebDriverManager;
import utility.Utility;

public class TestContext {

    private CustomWebDriverManager customWebDriverManager;
    private PageObjectManager pageObjectManager;
    private Utility utility;

    public TestContext(){
        customWebDriverManager = new CustomWebDriverManager();
        pageObjectManager = new PageObjectManager(customWebDriverManager.createDriver());
        utility = new Utility();
    }

    public CustomWebDriverManager getWebDriverManagerTwo(){
        return customWebDriverManager;
    }

    public PageObjectManager getPageObjectManager(){
        return pageObjectManager;
    }

    public Utility getUtility(){
        return utility;
    }

}
