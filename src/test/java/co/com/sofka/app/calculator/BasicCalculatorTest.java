package co.com.sofka.app.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class BasicCalculatorTest {
    private final BasicCalculator basicCalculator = new BasicCalculator();

    @Test
    @DisplayName("Testing sum: 1 + 1 = 2")
    public void sum() {
        // Arrange
        Long number1 = 1L;
        Long number2 = 1L;
        Long expectedValue = 2L;

        // Act
        Long result = basicCalculator.sum(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @Test
    @DisplayName("Fail Testing sum: 1 + 1 = 3")
    void failSum() {
        // Arrange
        Long number1 = 1L;
        Long number2 = 1L;
        Long expectedValue = 3L;

        // Act
        Long result = basicCalculator.sum(number1, number2);

        // Assert
        assertNotEquals(expectedValue,result,"1 + 1 != 2");
    }


    @DisplayName("Testing several sums")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })
    void severalSums(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.sum(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    @Test
    @DisplayName("Testing subtract: 2 - 1 = 1")
    void subtract() {
        // Arrange
        Long number1 = 2L;
        Long number2 = 1L;
        Long expectedValue = 1L;

        // Act
        Long result = basicCalculator.subtract(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several subtracts")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "3,    1,   2",
            "1,    2,   -1",
            "50,  40, 10",
            "100,  85, 15"
    })
    void severalSubtracts(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.subtract(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    @Test
    @DisplayName("Testing multiply: 2 * 2 = 4")
    void multiply() {
        // Arrange
        Long number1 = 2L;
        Long number2 = 2L;
        Long expectedValue = 4L;

        // Act
        Long result = basicCalculator.multiply(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several multiply")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "3,    1,   3",
            "1,    2,   2",
            "50,  0, 0",
            "10,  8, 80"
    })
    void severalMultiply(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.multiply(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    @Test
    @DisplayName("Testing divide: 2 / 2 = 1")
    void divide() {
        // Arrange
        Long number1 = 2L;
        Long number2 = 2L;
        Long expectedValue = 1L;

        // Act
        Long result = basicCalculator.divide(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several divide")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "3,    3,   1",
            "10,    5,   2",
            "50,  10, 5",
            "10,  2, 5"
    })
    void severalDivide(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.divide(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    @Test
    void exceptionTesting() {
        // Arrange
        Long number1 = 2L;
        Long number2 = 0L;
        String expect = "/ by zero";

        // Act
        Exception exception = assertThrows(ArithmeticException.class, () ->
                basicCalculator.divide(number1, number2));

        // Assert
        assertEquals(expect, exception.getMessage());
    }

}
