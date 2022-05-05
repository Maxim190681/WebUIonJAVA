package org.example.HW4;

/**
 * 1. Напишите функцию, вычисляющую площадь треугольника по трём сторонам (int a, int b, int c).
 * Разместите класс с функцией в src/main/java.
 * 2. Разместите тесты на эту функцию в классе src/test/java/.../TriangleTest.java.
 * 3. Настройте генерацию отчёта и по желанию — логирование.
 * <p>
 * Created by MaximZ190681 2022/04
 */
public class TriangleArea {
    // Формула  Герона - P=a+b+c, р = Р/2, S=√p(p-a)(p-b)(p-c)
    // Math. sqrt() возвращает квадратный корень из аргумента

    public static double triangleArea(int sideA, int sideB, int sideC) {
        double areaS = 0;
        if (sideA > 0 && sideB > 0 && sideC > 0) {
            double pP = 1.0 * (sideA + sideB + sideC) / 2;
            areaS = Math.sqrt(pP * ((pP - sideA) * (pP - sideB) * (pP - sideC)));
            System.out.println("Triangle Area is " + areaS);
        } else {
            System.out.println("Negative digits or zero not use");
        }
        return areaS;
    }
}



