package cucumber;

import managers.PageObjectManager;
import managers.CustomWebDriverManager;
import utility.Utility;

public class TestContext {

    private CustomWebDriverManager customWebDriverManager;
    private PageObjectManager pageObjectManager;
    //private Utility utility;

    public TestContext(){
        customWebDriverManager = new CustomWebDriverManager();
        pageObjectManager = new PageObjectManager(customWebDriverManager.getDriver());
        //utility = new Utility();
    }

    public CustomWebDriverManager getWebCustomDriverManager(){
        return customWebDriverManager;
    }

    public PageObjectManager getPageObjectManager(){
        return pageObjectManager;
    }

   /* public Utility getUtility(){
        return utility;
    }*/

}
