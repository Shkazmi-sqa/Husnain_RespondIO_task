package pageFactory;

import Variables.configReader;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.TestListeners;

public class HomePage {

    final WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Dashboard')]")
    public WebElement HomePage_dashboard;

    @FindBy(how = How.CSS, using = "//*[@id=\"root\"]/div/div/div/nav/div/div[1]/a[7]")
    public WebElement HomePage_Settings;

    @FindBy(how = How.CSS, using = "a[data-pw='users']")
    public WebElement Settings_Users;

    @FindBy(how = How.CSS, using = "button[data-pw='btn-add-usr']")
    public WebElement Users_addUser_btn;

    @FindBy(how = How.CSS, using = "input[placeholder='Email Address']")
    public WebElement addUser_email_input;


    @FindBy(how = How.XPATH, using = "/html/body/div[7]/div/div[2]/form/div/div[4]/div/button[2]")
    public WebElement addUser_btn;



    public void HomePage_isdisplayed()
    {
        if(HomePage_dashboard.isDisplayed()) {
            //System.out.println(TestListeners.extentTest.get());
            TestListeners.extentTest.get().log(Status.PASS, "Home Page is loaded successfully");
        }
    }

    public void Add_inputUseremail()
    {
        if(addUser_email_input.isDisplayed()) {
            addUser_email_input.sendKeys("Test_user9@gmail.com");
            TestListeners.extentTest.get().log(Status.PASS, "Inserting user email address");
        }

    }


    public void HomePage_settingsClick()
    {
        if(HomePage_Settings.isDisplayed()) {
            HomePage_Settings.click();
            TestListeners.extentTest.get().log(Status.PASS, "Clicking Login button");
        }

    }

    public void HomePage_settings_usersClick()
    {
        if(Settings_Users.isDisplayed()) {
            Settings_Users.click();
            TestListeners.extentTest.get().log(Status.PASS, "Clicking Login button");
        }

    }

    public void Setting_Add_userClick()
    {
        if(Users_addUser_btn.isDisplayed()) {
            Users_addUser_btn.click();
            TestListeners.extentTest.get().log(Status.PASS, "Clicking Login button");
        }

    }


    public void Add_userClick()
    {
        if(addUser_btn.isDisplayed()) {
            addUser_btn.click();
            TestListeners.extentTest.get().log(Status.PASS, "Clicking Login button");
        }

    }





    public HomePage(WebDriver driver){
        this.driver = driver;

    }
}
