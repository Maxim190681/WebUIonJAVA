package HW7;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.example.HW6.LoginPage;
import org.example.HW6.MyAccountCheck;
import org.example.HW6.RetToLoginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;

/**
 * https://pitbikeclub.ru (Login: zhegunov.m@yandex.ru, Password: Test_2 )
 * Created by Maximz1906891 2022/05
 */
    @Epic("New_Site")
public class TestUpdate {

    WebDriver driver;
    MyAccountCheck myAccountCheck;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new EventFiringDecorator(new CustomLogger()).decorate(new ChromeDriver()); // до подключения CustomLogger driver = new ChromeDriver(); перечеркнутый метод = устарел
        driver.manage().window().maximize();
        myAccountCheck = new MyAccountCheck(driver);
    }

    @Test
    @Feature("Login")
    @Story("Valid_Login&Pwd")
    @TmsLink("123")  // ID Теста по ресурсу allure.link.tms.pattern=https://example.org/browse/{}
    void LoginWithValidData() throws InterruptedException {
        driver.get("https://pitbikeclub.ru");
            new LoginPage(driver)
                    .login("zhegunov.m@yandex.ru", "Test_2");

    Assertions.assertEquals(new MyAccountCheck(driver).checkElement.isDisplayed(), true);

           new RetToLoginPage(driver);

    Thread.sleep(3000);
    }


    @AfterEach
    void tearDown() {
       LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);  // добавляем логи ошибок из панели разработчика CONSOLE

       for(LogEntry logEntry : logEntries) {
           Allure.addAttachment("Browser log element", logEntry.getMessage());
       }


        driver.quit();
    }

}
