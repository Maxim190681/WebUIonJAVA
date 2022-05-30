package HW7;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;

// добавление логов в отчет allure

// можно добавлять в тест, если необходим конкретный скрин
public class CustomLogger implements WebDriverListener {

    private static Logger logger = LoggerFactory.getLogger(CustomLogger.class); //дополнительное логирование в консоль

    public void beforeFindElement(WebDriver driver, By locator) {
        //System.out.println("Logger");
        logger.info("Find element  by locator" + locator.toString());
        Allure.step("Find element  by locator" + locator.toString());  // перед каждым элементом пишется только текст


       /* Allure.addAttachment("ScreenShot_Before_Find_Element",
                new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));*/

        // ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)
    }
    public void beforeQuit(WebDriver driver) { // скриншот перед закрытием браузера
        Allure.addAttachment("ScreenShot_Before_Find_Element",
                new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
    }


}
