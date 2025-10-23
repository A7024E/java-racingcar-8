package racingcar.exception;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidationTest {

    private InputValidation inputValidation;

    @BeforeEach
    void setUp() {
        inputValidation = new InputValidation();
    }

    @DisplayName("자동차 이름값을 입력하지 않은 경우 예외발생")
    @ParameterizedTest
    @NullAndEmptySource
    void inputCarNameNullorEmpty(String inputCarName) {
        assertThatThrownBy(()->inputValidation.validateCarName(inputCarName))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("입력에 공백이 포함되어 있을 경우 예외발생")
    @ParameterizedTest
    @ValueSource(strings = {" ", "pobi ", "pobi,woni, jun"})
    void inputCarNameBlank(String inputCarName) {
        assertThatThrownBy(()->inputValidation.validateCarNameBlank(inputCarName))
                .isInstanceOf(IllegalArgumentException.class);

    }
}