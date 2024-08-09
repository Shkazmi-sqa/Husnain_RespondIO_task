package testCases;

import Base.AppLogin;
import Base.baseClass;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageFactory.HomePage;
import pageFactory.LoginPage;

public class AddWorkspace_user extends baseClass {
    HomePage HPage;

    @BeforeClass
    public void setup() throws InterruptedException {
        HPage= PageFactory.initElements(driver, HomePage.class);
    }


    @Test
    public void AdduserFLow() throws InterruptedException {

        try {
          HPage.HomePage_settingsClick();
          HPage.HomePage_settings_usersClick();
          HPage.Setting_Add_userClick();
          HPage.Add_inputUseremail();
          HPage.Add_userClick();
          HPage.isUserAdded();
        } catch (Exception e)
        {
            System.out.println("CHeck error: " + e);
        }
    }


}
