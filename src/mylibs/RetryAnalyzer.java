package mylibs;



import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;
/**
 * 
 * @author chenchunfeng
 * 实现
 * 自动执行失败用例
 */
public class RetryAnalyzer implements IRetryAnalyzer {
    private int count = 0;
    private int maxCount = 2;
    public boolean retry(ITestResult result) {
        if (!result.isSuccess()) {
            if (count < maxCount) {
                count++;
                result.setStatus(ITestResult.SUCCESS);
                String message = Thread.currentThread().getName()
                        + ": Error in " + result.getName() + " Retrying "
                        + (maxCount + 1 - count) + " more times";
                System.out.println(message);
                Reporter.log(message);
                return true;
            } else {
                result.setStatus(ITestResult.FAILURE);
            }
        }
        return false;
    }
}

