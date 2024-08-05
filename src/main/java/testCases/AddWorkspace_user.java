package testCases;

import Base.baseClass;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageFactory.HomePage;

import java.util.PriorityQueue;

public class AddWorkspace_user extends baseClass {
    LoginApplication Applogin;
    HomePage HPage;
    @BeforeClass
    public void setup() throws InterruptedException {
        HPage= PageFactory.initElements(driver, HomePage.class);
        Applogin= new LoginApplication();

    }


    @Test (priority=2)
    public void AdduserFLow() throws InterruptedException {

        try {
            Applogin.ApplicationLoginTry();
          //HPage.HomePage_isdisplayed();
          HPage.HomePage_settingsClick();
          HPage.HomePage_settings_usersClick();
          HPage.Setting_Add_userClick();
          HPage.Add_inputUseremail();
          HPage.Add_userClick();
        } catch (Exception e)
        {
            System.out.println(e+"CHeck");
        }
    }


}
