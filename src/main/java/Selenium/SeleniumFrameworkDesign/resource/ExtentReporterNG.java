package Selenium.SeleniumFrameworkDesign.resource;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public static ExtentReports getReportObject() {
		String file=System.getProperty("user.dir")+"\\Reports\\ndex.html";
		
		ExtentSparkReporter extentSparkReporter= new ExtentSparkReporter(file);
		extentSparkReporter.config().setReportName("Web Automaton Name");
		extentSparkReporter.config().setDocumentTitle("Test Result");
		ExtentReports extentReports= new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		extentReports.setSystemInfo("Tester", "Mamatha Samala");
		
		return extentReports;
		
	}

}
