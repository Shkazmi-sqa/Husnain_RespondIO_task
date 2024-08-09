package Base;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageFactory.HomePage;
import pageFactory.LoginPage;
import utils.TestListeners;

public class AppLogin extends baseClass{

    LoginPage logPage;

    @BeforeClass
    public void setup() throws InterruptedException {
        logPage= PageFactory.initElements(driver, LoginPage.class);

    }

    @Test
    public void ApplicationLogin() throws InterruptedException {
        try {
            logPage.LoginPage_isdisplayed();
            logPage.LoginPage_inputUser();
            logPage.LoginPage_inputPass();
            logPage.LoginPage_LoginbuttonClick();
            logPage.HomePage_isdisplayed();
        } catch (Exception e)
        {
            TestListeners.extentTest.get().log(Status.FAIL, "ApplicationLogin function has following exception: " + e);
        }
    }







}
