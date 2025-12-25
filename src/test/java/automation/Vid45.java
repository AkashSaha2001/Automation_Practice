package automation;

import org.testng.Assert;
import org.testng.annotations.Test;

/*
Dependency Method and Grouping


Grouping Method =>

class 1 - m1, m2, m3
class 2 - m4, m5 ,m6
class 3 - m7, m8 ,m9

Sanity
Regression
Function
 */
public class Vid45 {
    @Test(priority = 1, groups = {"sanity"})
    void openWebSite() {
//        Assert.assertTrue(false);
        Assert.assertTrue(true);
    }

    @Test(priority = 2, dependsOnMethods = {"openWebSite"}, groups = {"sanity", "regression"})
    void login() {
        Assert.assertTrue(true);
    }

    @Test(priority = 3, dependsOnMethods = {"login"}, groups = {"sanity", "regression"})
    void search() {
        Assert.assertTrue(true);
    }

    @Test(priority = 4, dependsOnMethods = {"login", "search"}, groups = {"sanity", "regression"})
    void advSearch() {
        Assert.assertTrue(true);
    }

    @Test(priority = 5, dependsOnMethods = {"login"}, groups = {"regression"})
    void logout() {
        Assert.assertTrue(true);
    }

}
