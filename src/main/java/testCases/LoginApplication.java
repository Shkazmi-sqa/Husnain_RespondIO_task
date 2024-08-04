package testCases;

import Base.baseClass;
import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageFactory.HomePage;
import pageFactory.LoginPage;
//@Listeners(utils.TestListeners.class)
public class LoginApplication extends baseClass {

    LoginPage LogPage;

    @BeforeClass
    public void setup() throws InterruptedException {
        LogPage= PageFactory.initElements(driver, LoginPage.class);

    }
@Test
    public void ApplicationLoginTry() throws InterruptedException {
        try {
            LogPage.LoginPage_isdisplayed();
            LogPage.LoginPage_inputUser();
            LogPage.LoginPage_inputPass();
            LogPage.LoginPage_LoginbuttonClick();
            Thread.sleep(10000);
        } catch (Exception e)
        {
            System.out.println(e+"CHeck");
        }
    }


}
