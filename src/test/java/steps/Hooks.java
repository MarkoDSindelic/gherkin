package steps;

import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    TestContext testContext;


    public Hooks(TestContext context){
        testContext = context;
    }

    @Before
    public void setUp(){
        //driver is already set up through test context


    }

    @After
    public void tearDown(){

        testContext.getWebCustomDriverManager().quitDriver();
    }



}
