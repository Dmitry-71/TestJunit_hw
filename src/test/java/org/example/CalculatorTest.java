package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    Calculator calc;

    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }


    @Test
    @DisplayName("Проверка корректности сложения")
    public void testPlus() {
        //given
        final int x = 5;
        final int y = 7;
        final int expected = 12;
        //when
        final int result = calc.plus.apply(x, y);
        //then
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Проверка корректности сложения")
    public void testWrongPlus() {
        //given
        final int x = 5;
        final int y = 8;
        final int expected = 12;
        //when
        final int result = calc.plus.apply(x, y);
        //then
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Проверка корректности вычитания")
    public void testMinus() {
        //given
        final int x = 10;
        final int y = 7;
        final int expected = 3;
        //when
        final int result = calc.minus.apply(x, y);
        //then
        Assertions.assertEquals(expected, result);
    }
    @Test
    @DisplayName("Проверка корректности вычитания")
    public void testWrongMinus() {
        //given
        final int x = 10;
        final int y = 4;
        final int expected = 3;
        //when
        final int result = calc.minus.apply(x, y);
        //then
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Проверка корректности умножения")
    public void testMultiply() {
        //given
        final int x = 5;
        final int y = 7;
        final int expected = 35;
        //when
        final int result = calc.multiply.apply(x, y);
        //then
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Проверка корректности деления")
    public void testDivide() {
        //given
        final int x = 35;
        final int y = 7;
        final int expected = 5;
        //when
        final int result = calc.divide.apply(x, y);
        //then
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Проверка деления на 0")
    public void testDivideByZero() {
        //given
        final int x = 35;
        final int y = 0;
        //then
        Assertions.assertThrows(
                ArithmeticException.class,
                () -> calc.divide.apply(x, y)
        );
    }


    @Test
    @DisplayName("Проверка текста исключения при делении на 0")
    public void testExceptionDivideByZero() {
        //given
        final int x = 35;
        final int y = 0;

        //when
        final  ArithmeticException exception = Assertions.<ArithmeticException>assertThrows(
                ArithmeticException.class,
                () -> calc.divide.apply(x, y)
        );
        //then
        Assertions.assertEquals("Деление на 0!", "Деление на 0!");
    }

    @Test
    @DisplayName("Проверка вычисления квадрата из числа")
    public void testPow() {
        //given
        Calculator calc = new Calculator();
        final int x = 5;
        final int expected = 25;
        //when
        final int result = calc.pow.apply(x);
        //then
        Assertions.assertEquals(expected, result);

    }

    @Test
    @DisplayName("Проверка корректности абсалюта")
    public void testAbs() {
        //given
        Calculator calc = new Calculator();
        final int x = -5;
        final int expected = 5;
        //when
        final int result = calc.abs.apply(x);
        //then
        Assertions.assertEquals(expected, result);

    }

    @Test
    @DisplayName("Проверка корректности проверки положительного числа")
    public void testIsPositive() {
        //given
        Calculator calc = new Calculator();
        final int x = -5;
        final Boolean expected = false;
        //when
        final Boolean result = calc.isPositive.test(x);
        //then
        Assertions.assertEquals(expected, result);
    }
}