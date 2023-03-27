 package Selenium.SeleniumFrameworkDesign.TestComponents;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Selenium.SeleniumFrameworkDesign.pageobjects.Landingpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public Landingpage landingpage;

	public WebDriver initializeDriver() throws IOException {

		Properties pro = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "//src//main//java//Selenium//SeleniumFrameworkDesign//resource//GlobalData.properties");
		pro.load(fis);
		
		String browserame =System.getProperty("browser")!=null ? System.getProperty("browser") :pro.getProperty("browser");
//		pro.getProperty("browser");

		if (browserame.contains("chrome")) {
			
			ChromeOptions options= new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			if(browserame.contains("headless")) {
			options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));
			
		} else if (browserame.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeMethod(alwaysRun=true)
	public Landingpage lunchApplication() throws InterruptedException, IOException {
		driver = initializeDriver();
		landingpage = new Landingpage(driver);
		Thread.sleep(2000);
		landingpage.goTo();
		return landingpage;
	}
	
	
//	@AfterMethod(alwaysRun=true)
//	public void closeBrowser() {
//		driver.close();
//	}
	
	//Read data from Json
public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		
		String jsonContent= FileUtils.readFileToString(new File(filePath)
					,StandardCharsets.UTF_8);
		
		ObjectMapper mapper =new ObjectMapper();
		List<HashMap<String, String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String ,String>>>(){
		});
		return data;
	}
	

public String getScreenShot(String TestCaseName ,WebDriver driver) throws IOException {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File Source=ts.getScreenshotAs(OutputType.FILE);
	File file=new File(System.getProperty("user.dir")+"//Reports//"+TestCaseName+".png");
	FileUtils.copyFile(Source,file );
	return System.getProperty("user.dir")+"//Reports//"+TestCaseName+".png";	

	
	
	
}
	

}
