package utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;
//    private static ExtentTest test;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static ExtentReports createInstance(String fileName) {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(fileName);
        sparkReporter.config().setDocumentTitle("Test Report");
        sparkReporter.config().setReportName("FF Test Report");
        sparkReporter.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.STANDARD);
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        return extent;
    }

    public static void createTest(String testName) {
//        test = extent.createTest(testName);
//        return test;
        test.set(extent.createTest(testName));

    }

    
    public static ExtentTest getTest() {
        return test.get();
    }
    
    
    public static void flush() {
        extent.flush();
    }
}
