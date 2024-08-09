package apiTestCases;

import Base.baseClass;
import Variables.configReader;
import com.alibaba.fastjson2.JSONObject;
import com.aventstack.extentreports.Status;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.TestListeners;


public class LoginAPICases {

    protected String Username;
    protected String userpassword;
    protected String BaseAPIURL;

    protected String loginAPIURL;

    @BeforeClass
    public void getRequiredInfo() {
        configReader.initializePropertyFile();
        Username = configReader.property.getProperty("Login_User");
        userpassword = configReader.property.getProperty("Login_Pass");
        BaseAPIURL = configReader.property.getProperty("APP_URL");
        loginAPIURL = BaseAPIURL + "auth/login";
    }

    @Test
    public void loginWithValidCredentials() {
        try {
            Response response_login_case1;
            JSONObject jsonparm = new JSONObject();
            jsonparm.put("email", Username);
            jsonparm.put("password", userpassword);
            response_login_case1 = RestAssured.given().contentType(ContentType.JSON)
                    .body(jsonparm.toString()).baseUri(loginAPIURL)
                    .when().post();
            int status_code = response_login_case1.getStatusCode();
            if (status_code == 200) {
                TestListeners.extentTest.get().log(Status.PASS, "[LoginAPI Cases] valid credentials case API Response as expected: " + status_code);
            } else {
                TestListeners.extentTest.get().log(Status.FAIL, "[LoginAPI Cases] valid credentials case API Response not as per expected: " + status_code);
            }
        } catch (Exception e) {
            TestListeners.extentTest.get().log(Status.FAIL, "LoginAPI Cases: loginWithValidCredentials function break with exception: " + e);
        }
    }

    @Test
    public void loginWithInvalidPassword() {
        try {
            Response response_login_case2;
            JSONObject jsonparm = new JSONObject();
            jsonparm.put("email", Username);
            jsonparm.put("password", userpassword + "12");
            response_login_case2 = RestAssured.given().contentType(ContentType.JSON)
                    .body(jsonparm.toString()).baseUri(loginAPIURL)
                    .when().post();
            int status_code = response_login_case2.getStatusCode();
            if (status_code == 401) {
                TestListeners.extentTest.get().log(Status.PASS, "[LoginAPI Cases] Invalid Password case API Response as expected: " + status_code);
            } else {
                TestListeners.extentTest.get().log(Status.FAIL, "[LoginAPI Cases] Invalid Password case API Response not as per expected: " + status_code);
            }
        } catch (Exception e) {
            TestListeners.extentTest.get().log(Status.FAIL, "LoginAPI Cases: loginWithInvalidPassword function break with exception: " + e);
        }
    }

    @Test
    public void loginWithInvalidusername() {
        try {
            Response response_login_case3;
            JSONObject jsonparm = new JSONObject();
            jsonparm.put("email", Username + "mm");
            jsonparm.put("password", userpassword);
            response_login_case3 = RestAssured.given().contentType(ContentType.JSON)
                    .body(jsonparm.toString()).baseUri(loginAPIURL)
                    .when().post();
            int status_code = response_login_case3.getStatusCode();
            if (status_code == 400) {
                TestListeners.extentTest.get().log(Status.PASS, "[LoginAPI Cases] Invalid Username case API Response as expected: " + status_code);
            } else {
                TestListeners.extentTest.get().log(Status.FAIL, "[LoginAPI Cases] Invalid Username case API Response not as per expected: " + status_code);
            }
        } catch (Exception e) {
            TestListeners.extentTest.get().log(Status.FAIL, "LoginAPI Cases: loginWithInvalidusername function break with exception: " + e);
        }
    }


    @Test
    public void loginInvalidusernamePassword() {
        try {
            Response response_login_case4;
            JSONObject jsonparm = new JSONObject();
            jsonparm.put("email", Username + "mm");
            jsonparm.put("password", userpassword+ "12");
            response_login_case4 = RestAssured.given().contentType(ContentType.JSON)
                    .body(jsonparm.toString()).baseUri(loginAPIURL)
                    .when().post();
            int status_code = response_login_case4.getStatusCode();
            if (status_code == 400) {
                TestListeners.extentTest.get().log(Status.PASS, "[LoginAPI Cases] Invalid Username_password case API Response as expected: " + status_code);
            } else {
                TestListeners.extentTest.get().log(Status.FAIL, "[LoginAPI Cases] Invalid Username_password case API Response not as per expected: " + status_code);
            }
        } catch (Exception e) {
            TestListeners.extentTest.get().log(Status.FAIL, "LoginAPI Cases: loginInvalidusernamePassword function break with exception: " + e);
        }
    }

}
