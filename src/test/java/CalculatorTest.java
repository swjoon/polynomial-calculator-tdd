import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    private static final Calculator cal = new Calculator();

    @Test
    @DisplayName(" 1 + 2 = 3")
    void Test1() {
        assertThat(cal.run("1 + 2")).isEqualTo(3);
    }

    @Test
    @DisplayName(" 1 * 2 = 2")
    void Test2() {
        assertThat(cal.run("1 * 2")).isEqualTo(2);
    }

    @Test
    @DisplayName(" 1 - -2 = 3")
    void Test3() {
        assertThat(cal.run("1 - -2")).isEqualTo(3);
    }

    @Test
    @DisplayName(" 1 / 2 = 0 ")
    void Test4() {
        assertThat(cal.run("1 / 2")).isEqualTo(0);
    }

    @Test
    @DisplayName(" 1 + 2 * 3 = 7 ")
    void Test5() {
        assertThat(cal.run("1 + 2 * 3")).isEqualTo(7);
    }

    @Test
    @DisplayName(" 1 + 2 * 3 + 4 / 2 * 5 + 5 = 22 ")
    void Test6() {
        assertThat(cal.run("1 + 2 * 3 + 4 / 2 * 5 + 5")).isEqualTo(22);
    }

}
