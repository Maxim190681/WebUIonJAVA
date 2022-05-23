package HW6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.HW6.LoginPage;
import org.example.HW6.MyAccountCheck;
import org.example.HW6.RetToLoginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * https://pitbikeclub.ru (Login: zhegunov.m@yandex.ru, Password: Test_2 )
 * Created by Maximz1906891 2022/05
 */
public class TestUpdate {

    WebDriver driver;
    MyAccountCheck myAccountCheck;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        myAccountCheck = new MyAccountCheck(driver);
    }

    @Test
    void LoginWithValidData() throws InterruptedException {
        driver.get("https://pitbikeclub.ru");
            new LoginPage(driver)
                    .login("zhegunov.m@yandex.ru", "Test_2");

    Assertions.assertEquals(new MyAccountCheck(driver).checkElement.isDisplayed(), true);

            new RetToLoginPage(driver);

    Thread.sleep(7000);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

}
