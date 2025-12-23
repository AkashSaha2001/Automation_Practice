package automation;

import org.testng.Assert;
import org.testng.annotations.Test;

/*
Dependency Method and Grouping
 */
public class Vid45 {
    @Test(priority=1)
    void openWebSite(){
//        Assert.assertTrue(false);
        Assert.assertTrue(true);
    }

    @Test(priority=2, dependsOnMethods = {"openWebSite"})
    void login(){
        Assert.assertTrue(true);
    }

    @Test(priority=3, dependsOnMethods = {"login"})
    void search(){
        Assert.assertTrue(false);
    }

    @Test(priority=4,dependsOnMethods = {"login","search"})
    void advSearch(){
        Assert.assertTrue(true);
    }

    @Test(priority=5, dependsOnMethods = {"login"})
    void logout(){
        Assert.assertTrue(true);
    }

}
