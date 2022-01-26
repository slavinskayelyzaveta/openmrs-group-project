package openmrs;

import io.github.bonigarcia.wdm.WebDriverManager;
import openmrs.pages.CommonPage;
import openmrs.pages.HomePage;
import openmrs.pages.LoginPage;
import openmrs.pages.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class PatientRegistrationTests {

    WebDriver driver;
    SoftAssert softAssert;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        softAssert = new SoftAssert();
        driver = new ChromeDriver();

    }

    @Test
    public void patientRegisterTest() {
        LoginPage loginPage = new LoginPage(driver, softAssert);
        HomePage homePage = new HomePage(driver, softAssert);
        RegistrationPage registrationPage = new RegistrationPage(driver, softAssert);

        loginPage.visitLoginPage();
        loginPage.login();

//       homePage.verifyHomePageTitle();
        homePage.selectTab();
        registrationPage.register();


        softAssert.assertAll();


    }


}
