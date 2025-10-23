package racingcar.utils;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ConverterTest {

    @DisplayName("문자열로 구분된 자동차들을 리스트로 반환한다.")
    @ParameterizedTest
    @CsvSource({
            "'pobi,woni,jun', 3,",
            "'pobi', 1"
    })
    void splitCarNames(String carNames,int carNameSize) {
        //given
        String[] splitCarNames = carNames.split(",");

        //when
        List<String> cars = Converter.generateCarNames(splitCarNames);

        //then
        assertThat(cars).hasSize(carNameSize);
    }

}