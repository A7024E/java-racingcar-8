package racingcar.exception;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidationTest {

    private InputValidation inputValidation;

    @DisplayName("자동차 이름값이 null 또는 빈 문자열이면 true를 반환")
    @ParameterizedTest
    @NullAndEmptySource
    void inputCarNameNullOrEmpty(String inputCarName) {
        //given //when
        boolean isNullOrEmpty = InputValidation.isNullOrEmpty(inputCarName);

        //Then
        assertThat(isNullOrEmpty).isTrue();
    }

    @DisplayName("입력에 공백이 포함되어 있을 경우 예외발생")
    @ParameterizedTest
    @ValueSource(strings = {" ", "pobi ", "pobi,woni, jun"})
    void inputCarNameBlank(String inputCarName) {
        //given //when
        boolean isContainsBlank = InputValidation.isBlankContains(inputCarName);

        //Then
        assertThat(isContainsBlank).isTrue();

    }
}