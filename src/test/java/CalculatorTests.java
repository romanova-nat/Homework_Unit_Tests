import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTests {

    Calculator sut;

    @BeforeEach
    public void unit() {
        sut = new Calculator();
    }

    @Test
    public void shouldBePlus() {
        // arrange
        int a = 2;
        int b = 3;
        int expected = 5;

        //act
        int result = sut.plus.apply(a, b);

        //assert
        assertEquals(expected, result);
    }

    @Test
    public void shouldDivideByZero() {
        int a = 10;
        int b = 0;
        var expected = ArithmeticException.class;

        assertThrows(expected,
                () -> sut.devide.apply(a, b));
    }

    @ParameterizedTest
    @MethodSource("sourse")
    public void shouldCountCorrectly(int a, int b, int expected) {
        int result = sut.multiply.apply(a, b);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> sourse() {
        return Stream.of(Arguments.of(2, 3, 6), Arguments.of(5, 2, 10));
    }
}
