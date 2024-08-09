package pageFactory;

import Variables.configReader;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.TestListeners;

public class HomePage extends GenericFunctions {

    final WebDriver driver;

    protected String RandomUser;

    @FindBy(how = How.XPATH, using = "//div[@id='root']//a[@data-pw='settings']")
    public WebElement HomePage_Settings;

    /*  @FindBy(how = How.XPATH, using = "//div[@id='root']//a[@href='/space/242025/settings/users']")
      public WebElement Settings_Users;

    @FindBy(how = How.XPATH, using = "//div[@data-pw='Workspace Settings']//a[@data-pw='users']")
    public WebElement Settings_Users;

    */

    @FindBy(how = How.CSS, using = "a[data-pw='users']")
    public WebElement Settings_Users;

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div/div/main/div/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div[3]/div[1]/div/div")
    public WebElement Users_addUser_btn;

    @FindBy(how = How.XPATH, using = "//div[@class='v-overlay-container']//input[@placeholder='Email Address']")
    public WebElement addUser_email_input;


    @FindBy(how = How.XPATH, using = "/html/body/div[7]/div/div[2]/form/div/div[4]/div/button[2]")
    public WebElement addUser_btn;


    public void Add_inputUseremail() throws InterruptedException {
        try {
            RandomUser = generateRandomUser();
            if (addUser_email_input.isDisplayed()) {
                addUser_email_input.sendKeys(RandomUser);
                TestListeners.extentTest.get().log(Status.PASS, "Inserting user email address");
                Thread.sleep(2000);
            } else TestListeners.extentTest.get().log(Status.FAIL, "Input New user email field is not Visible");

        } catch (Exception e) {
            TestListeners.extentTest.get().log(Status.FAIL, "Add_inputUseremail function has following exception: " + e);
        }
    }


    public void HomePage_settingsClick() throws InterruptedException {
        try {
            waitForVisibility(driver, HomePage_Settings);
            if (HomePage_Settings.isDisplayed()) {
                HomePage_Settings.click();
                TestListeners.extentTest.get().log(Status.PASS, "Clicking Nav Bar Setting button");
            } else TestListeners.extentTest.get().log(Status.FAIL, "HomePage Nav Bar Setting button is not Visible");

        } catch (Exception e) {
            TestListeners.extentTest.get().log(Status.FAIL, "HomePage_settingsClick function has following exception: " + e);
        }
    }

    public void HomePage_settings_usersClick() throws InterruptedException {
        try {
            //waitForVisibility(driver, Settings_Users);
            if (Settings_Users.isDisplayed()) {
                Settings_Users.click();
                TestListeners.extentTest.get().log(Status.PASS, "Clicking users button from settings");
                Thread.sleep(2000);
            } else TestListeners.extentTest.get().log(Status.FAIL, "Settings Page User button is not Visible");

        } catch (Exception e) {
            TestListeners.extentTest.get().log(Status.FAIL, "HomePage_settings_usersClick function has following exception: " + e);
        }
    }

    public void Setting_Add_userClick() throws InterruptedException {

        try {
            waitForVisibility(driver, Users_addUser_btn);
            if (Users_addUser_btn.isDisplayed()) {
                Users_addUser_btn.click();
                TestListeners.extentTest.get().log(Status.PASS, "Clicking Add User button to invite new user");
            } else TestListeners.extentTest.get().log(Status.FAIL, "Add User button is not Visible");

        } catch (Exception e) {
            TestListeners.extentTest.get().log(Status.FAIL, "Setting_Add_userClick function has following exception: " + e);
        }
    }


    public void Add_userClick() throws InterruptedException {
        try {
            waitForVisibility(driver, addUser_btn);
            if (addUser_btn.isDisplayed()) {
                addUser_btn.click();
                TestListeners.extentTest.get().log(Status.PASS, "Click on Add user to invite");
            } else
                TestListeners.extentTest.get().log(Status.FAIL, "Add User button on new user dialog box is not Visible");

        } catch (Exception e) {
            TestListeners.extentTest.get().log(Status.FAIL, "Add_userClick function has following exception: " + e);
        }
    }

    public void isUserAdded() {
        try {
            String addeduser_xpath = "//div[@role='listbox']/*[contains(string(),'" + RandomUser + "')]";
            WebElement addeduser = driver.findElement(By.xpath(addeduser_xpath));
            waitForVisibility(driver, addeduser);
            if (addeduser.isDisplayed()) {
                TestListeners.extentTest.get().log(Status.PASS, "Added user Successfully added in Users list");
            } else TestListeners.extentTest.get().log(Status.FAIL, "Added user is not Visible in listed User");

        } catch (Exception e) {
            TestListeners.extentTest.get().log(Status.FAIL, "isUserAdded function has following exception: " + e);
        }
    }


    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.RandomUser = generateRandomUser();

    }
}
