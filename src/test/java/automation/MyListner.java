package automation;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListner implements ITestListener {
//    execute only once
    public void onStart(ITestContext context) {
        System.out.println("OnStart Method");
    }
//    execute multiple times whenever any TestCase started
    public void onTestStart(ITestResult result) {
        System.out.println("OnTestStart Method");
    }
//  execute is the test Case is passed
    public void onTestSuccess(ITestResult result) {
        System.out.println("OnTestSuccess Method");
    }
//  Execute if the test case get failed
    public void onTestFailure(ITestResult result) {
        System.out.println("OnTestFailed Method");
    }
// execute if the testcase get skipped
    public void onTestSkipped(ITestResult result) {
        System.out.println("OnTestSkipped Method");
    }
// execute only once after the test completion
    public void onFinish(ITestContext context) {
        System.out.println("OnFinish Method");
    }


}
