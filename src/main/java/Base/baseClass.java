package Base;

import Variables.configReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import testCases.LoginApplication;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;
@Listeners(utils.TestListeners.class)
public class baseClass {

    public WebDriver driver;


    protected String AppUrl;
    protected String BrowserType;
    protected String ExecutionMode;



    @BeforeSuite
    public void suiteSetUP() throws InterruptedException {
        configReader.initializePropertyFile();
        BrowserType= configReader.property.getProperty("BrowserType");
        ExecutionMode= configReader.property.getProperty("ExecutionMode");
        AppUrl= configReader.property.getProperty("APP_URL");

        try {
            initialize(BrowserType,AppUrl,ExecutionMode);
        } catch (InterruptedException e) {
            System.out.println(e);
            throw new RuntimeException(e);

        }
    }


    protected void initialize(String BrowserType,String AppURLProperty, String RunMode) throws InterruptedException{
        try {
            if (BrowserType.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (BrowserType.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                try {
                    driver = new RemoteWebDriver(new URI("http://localhost:4444/").toURL(), options);
                } catch (URISyntaxException | MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                //driver = new FirefoxDriver();
            } else if (BrowserType.equalsIgnoreCase("edge")) {

                if (RunMode.equalsIgnoreCase("seleniumgrid")) {
                    EdgeOptions options = new EdgeOptions();
                    try {
                        driver = new RemoteWebDriver(new URI("http://localhost:4444/").toURL(), options);
                        WebDriverManager.edgedriver().setup();
                    } catch (URISyntaxException | MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                }
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


            driver.get(AppURLProperty);
        }catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException(e);

        }


    }


    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {

        try {
            cleanUp();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }


    protected void cleanUp() {
     try{
        this.driver.close();
        //this.driver.quit();
    }catch (Exception e) {
        System.out.println(e);
        throw new RuntimeException(e);

    }

}
}
