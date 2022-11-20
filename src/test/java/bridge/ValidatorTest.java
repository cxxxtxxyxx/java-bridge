package bridge;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidatorTest {

    @DisplayName("3이상 20이하의 숫자를 입력하지 않으면 예외가 발생한다")
    @ValueSource(strings = {"2", "21", "100", "0", "abc"})
    @ParameterizedTest
    void sizeTest(String input){
        assertThatThrownBy(() -> Validator.size(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("U 또는 D 문자를 입력하지 않으면 예외가 발생한다")
    @Test
    void directionTest(){
        assertThatThrownBy(() -> Validator.direction("Q"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("R 또는 Q 문자를 입력하지 않으면 예외가 발생한다")
    @Test
    void retryCommandTest(){
        assertThatThrownBy(() -> Validator.retryCommand("I"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
