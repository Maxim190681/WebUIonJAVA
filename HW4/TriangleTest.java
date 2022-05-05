package Tests;

import org.example.HW4.TriangleArea;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TriangleTest {
    // уровни логирования  TRACE, DEBUG, IFO, WARN, ERROR
    // перед всеми тестами,  например очистить  записи в БД для создания новых записей (diary)

    private static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @BeforeAll
    static void beforeAll() {
        logger.info("INFO");
        logger.debug("DEBUG");
        logger.error("ERROR");

        System.out.println("method was completed once before all class tests");
    }

    // перед каждым тестом ( пример - в  All регистрируем веб драйвер, в Each - создаем новый чистый экземпляр
    @BeforeEach
    void beforeEach() {
        System.out.println("method is performed before each test");
    }


    @Test
    @DisplayName("Data size is negative")
    public void CheckNegativeNumbers() {
        double areaS = TriangleArea.triangleArea(0, 2, 3);
        Assertions.assertFalse(areaS > 0);
    }

    @Test
    @DisplayName("Data size is positive")
    public void CheckPositiveNumbers() {
        double areaS = TriangleArea.triangleArea(3, 2, 3);
        Assertions.assertTrue(areaS > 0);
    }


    // после каждого теста - например SELENIUM  driver quit - если тест упал, браузер закроется
    @AfterEach
    void afterEach() {
        System.out.println("method will be completed after each test");
    }

    // После всех  тестов
    @AfterAll
    static void afterAll() {
        System.out.println("method will be completed after all tests");
    }
}
