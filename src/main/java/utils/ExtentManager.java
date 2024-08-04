package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.util.Date;

public class ExtentManager {

    private static ExtentReports extent;
    protected static ExtentSparkReporter spark;

    public static ExtentReports createInstance() {
        String fileName = getReportName();
        String directory = System.getProperty("user.dir") + "/reports/";
        new File(directory).mkdirs();
        String path = directory + fileName;
        spark = new ExtentSparkReporter(path);
        spark.config().setEncoding("utf-8");
        spark.config().setDocumentTitle("Automation Reports");
        spark.config().setReportName("Automation Test Results");
        spark.config().setTheme (Theme. STANDARD);
        extent = new ExtentReports();
        extent.setSystemInfo("Organization", "Let's Kode It");
        extent.setSystemInfo("Browser", "Edge");
        extent.attachReporter(spark);
        return extent;
    }

    public static String getReportName() {
        Date d = new Date();
        String fileName = "AutomationReport_" + d.toString().replace(":", "_").replace("", "_") + ".html";
        return fileName;
    }

}
