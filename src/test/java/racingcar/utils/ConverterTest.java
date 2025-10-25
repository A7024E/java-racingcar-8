package racingcar.utils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class ConverterTest {

    @DisplayName("문자열로 구분된 자동차들을 리스트로 반환한다.")
    @ParameterizedTest
    @CsvSource({
            "'pobi,woni,jun', 3,",
            "'pobi', 1"
    })
    void splitCarNames(String carNames, int carNameSize) {
        //given
        String[] splitCarNames = carNames.split(",");
        //when
        List<String> cars = Converter.toList(splitCarNames);
        //then
        assertThat(cars).hasSize(carNameSize);
    }

    @DisplayName("공백이 포함되거나, 정수 이외의 값이 들어오면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "1 3", " ", "1.2"})
    void invalidRacingCountInputs(String tryCount) {
        //given //when //then
        assertThatThrownBy(() -> Converter.toInt(tryCount))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("1 이상의 정수값이 들어오면 예외를 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "13", "12"})
    void notInvalidRacingCountInputs(String tryCount) {
        //given //when //then
        assertThatCode(() -> Converter.toInt(tryCount))
                .doesNotThrowAnyException();
    }
}