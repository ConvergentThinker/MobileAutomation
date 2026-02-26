package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {

    private static ThreadLocal<ExtentReports> extent = new ThreadLocal<>();

    public static ExtentReports getExtent(String udid) {

        if (extent.get() == null) {

            String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss")
                    .format(new Date());

            String reportPath = System.getProperty("user.dir")
                    + "/reports/ExtentReport_" + udid + "_" + timeStamp + ".html";

            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

            ExtentReports extentReports = new ExtentReports();
            extentReports.attachReporter(spark);

            extentReports.setSystemInfo("Device", udid);
            extentReports.setSystemInfo("OS", System.getProperty("os.name"));

            extent.set(extentReports);
        }
        return extent.get();
    }

    public static void flush() {
        if (extent.get() != null) {
            extent.get().flush();
            extent.remove();
        }
    }
}



//package listeners;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//public class ExtentManager {
//
//
//
//        private static ThreadLocal<ExtentReports> extent = new ThreadLocal<>();
//
//        public static ExtentReports getExtent(String udid) {
//            if (extent.get() == null) {
//
//                String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss")
//                        .format(new Date());
//
//                String reportPath = System.getProperty("user.dir")
//                        + "/reports/Report_" + udid + "_" + timeStamp + ".html";
//
//                ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
//                ExtentReports extentReports = new ExtentReports();
//                extentReports.attachReporter(spark);
//
//                extent.set(extentReports);
//            }
//            return extent.get();
//        }
//
//        public static void flush() {
//            if (extent.get() != null) {
//                extent.get().flush();
//                extent.remove();
//            }
//        }
//    }
//
//
