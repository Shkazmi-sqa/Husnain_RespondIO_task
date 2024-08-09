package pageFactory;

import Variables.configReader;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.TestListeners;

public class LoginPage extends GenericFunctions {

    protected String LoginUser;
    protected String LoginPass;
    final WebDriver driver;


    @FindBy(how = How.CSS, using = "input[placeholder='Email address']")
    public WebElement Input_UserName;

    @FindBy(how = How.CSS, using = "input[placeholder='Password']")
    public WebElement Input_LoginPass;

    @FindBy(how = How.CSS, using = "button[data-pw='btn-signin']")
    public WebElement Login_btn;
    @FindBy(how = How.CSS, using = "img[src='https://cdn.respond.io/platform/web/assets/static/images/logo_black.svg']")
    public WebElement Login_logo;


    @FindBy(how = How.XPATH, using = "//div[@id='root']//nav[@data-pw='nav-content']")
    public WebElement HomePage_NavBar;

    public void LoginPage_isdisplayed() {

        try {
            waitForVisibility(driver, Login_logo);
            if (Login_logo.isDisplayed()) {
                TestListeners.extentTest.get().log(Status.PASS, "Login Page is loaded successfully");
            } else
                TestListeners.extentTest.get().log(Status.FAIL, "Login Page Login logo not found");
        } catch (Exception e) {
            TestListeners.extentTest.get().log(Status.FAIL, "LoginPage_isdisplayed function has following exception: " + e);
        }

    }

    public void LoginPage_inputUser() {
        try {
            waitForVisibility(driver, Input_UserName);
            if (Input_UserName.isDisplayed()) {
                Input_UserName.sendKeys(LoginUser);
                TestListeners.extentTest.get().log(Status.PASS, "LoginPage Username Credentials is Inserted");
            } else TestListeners.extentTest.get().log(Status.FAIL, "LoginPage Username Field not Visible");

        } catch (Exception e) {
            TestListeners.extentTest.get().log(Status.FAIL, "LoginPage_inputUser function has following exception: " + e);
        }
    }

    public void LoginPage_inputPass() {
        try {
            waitForVisibility(driver, Input_LoginPass);
            if (Input_LoginPass.isDisplayed()) {
                Input_LoginPass.sendKeys(LoginPass);
                TestListeners.extentTest.get().log(Status.PASS, "LoginPage Password Credentials is Inserted");
            } else TestListeners.extentTest.get().log(Status.FAIL, "LoginPage Password Field not Visible");

        } catch (Exception e) {
            TestListeners.extentTest.get().log(Status.FAIL, "LoginPage_inputPass function has following exception: " + e);
        }
    }

    public void LoginPage_LoginbuttonClick() {
        try {
            waitForVisibility(driver, Login_btn);
            if (Login_btn.isDisplayed()) {
                Login_btn.click();
                TestListeners.extentTest.get().log(Status.PASS, "LoginPage Clicking on Login button");
            } else TestListeners.extentTest.get().log(Status.FAIL, "LoginPage Login button is not Visible");

        } catch (Exception e) {
            TestListeners.extentTest.get().log(Status.FAIL, "LoginPage_LoginbuttonClick function has following exception: " + e);
        }
    }

    public void HomePage_isdisplayed() {
        try {
            System.out.println("Locator for setting user: " +HomePage_NavBar);
            waitForVisibility(driver, HomePage_NavBar);

            if (HomePage_NavBar.isDisplayed()) {
                TestListeners.extentTest.get().log(Status.PASS, "HomePage Nav Bar is loaded successfully");
            } else TestListeners.extentTest.get().log(Status.FAIL, "HomePage Nav Bar is not Visible");

        } catch (Exception e) {
            TestListeners.extentTest.get().log(Status.FAIL, "HomePage_isdisplayed function has following exception: " + e);
        }
    }


    public LoginPage(WebDriver driver) {
        LoginUser = configReader.property.getProperty("Login_User");
        LoginPass = configReader.property.getProperty("Login_Pass");
        this.driver = driver;

    }

}
