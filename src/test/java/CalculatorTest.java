import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    private static final Calculator Calc = new Calculator();

    @Test
    @DisplayName(" 1 + 2 = 3")
    void Test1() {
        assertThat(Calc.run("1 + 2")).isEqualTo(3);
    }

    @Test
    @DisplayName(" 1 * 2 = 2")
    void Test2() {
        assertThat(Calc.run("1 * 2")).isEqualTo(2);
    }

    @Test
    @DisplayName(" 1 - -2 = 3")
    void Test3() {
        assertThat(Calc.run("1 - -2")).isEqualTo(3);
    }

    @Test
    @DisplayName(" 1 / 2 = 0 ")
    void Test4() {
        assertThat(Calc.run("1 / 2")).isEqualTo(0);
    }

    @Test
    @DisplayName(" 1 + 2 * 3 = 7 ")
    void Test5() {
        assertThat(Calc.run("1 + 2 * 3")).isEqualTo(7);
    }

    @Test
    @DisplayName(" 1 + 2 * 3 + 4 / 2 * 5 + 5 = 22 ")
    void Test6() {
        assertThat(Calc.run("1 + 2 * 3 + 4 / 2 * 5 + 5")).isEqualTo(22);
    }

    @Test
    @DisplayName(" (1 + 2) * 3 = 9 ")
    void Test7(){
        assertThat(Calc.run("(1 + 2) * 3")).isEqualTo(9);
    }

    @Test
    @DisplayName(" 9 + (10 * (1 + 2) + (4 + 3) * -5) * 3 + 10 = 4 ")
    void Test8(){
        assertThat(Calc.run("9 + (10 * (1 + 2) + (4 + 3) * -5) * 3 + 10")).isEqualTo(4);
    }

    @Test
    @DisplayName(" 9 + (10 * (1 + 2) + ((4 + 3) * -5 + -5) / 8) * 3 + 10 = 94 ")
    void Test9(){
        assertThat(Calc.run("9 + (10 * (1 + 2) + ((4 + 3) * -5 + -5) / 8) * 3 + 10")).isEqualTo(94);
    }
}
