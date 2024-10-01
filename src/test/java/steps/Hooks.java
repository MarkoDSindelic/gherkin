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
        //System.out.println("Before hook");


    }

    @After
    public void tearDown(){

        System.out.println("After hook");

        testContext.getWebDriverManagerTwo().quitDriver();
    }



}
