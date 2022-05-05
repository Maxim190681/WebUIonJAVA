package Tests;

import org.example.lesson4.Box;
import org.example.lesson4.ZeroBallCountException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class BoxTests {

    // тесты делятся на полную и пустую коробку
    // используем вложенный класс

    Box box;

    @Nested
    class WhenEmpty {
        @BeforeEach
        void initBox() {
            box = new Box();
        }

        @Test
        void exceptionWhenTryShuffleEmptyBox() {
            Assertions.assertThrows(ZeroBallCountException.class, () -> box.shuffleBall());
        }

        @Nested
        class WhenOneBall {
            @BeforeEach
            void addBall() {
                box.addBalls();
            }

            @Test
            void deleteBallTest() {
                box.removeBall();
                Assertions.assertEquals(box.getBallCounter(),0);
            }
        }
    }
}
