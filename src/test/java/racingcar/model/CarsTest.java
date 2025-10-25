package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    @DisplayName("자동차 이름들을 받아 Cars 객체가 잘 생성되는지 확인한다")
    @Test
    void createCars() {
        //given
        List<String> carNames = List.of("pobi", "woni", "jun");
        //when
        Cars cars = Cars.fromCarNames(carNames);

        //then
        assertThat(cars).isEqualTo(Cars.fromCarNames(carNames));
    }

    @DisplayName("자동차 이름이 중복됐을 경우 예외발생")
    @Test
    void carsWithDuplicateNames() {
        // given
        List<String> carNames = List.of("pobi","pobi","jun");
        // when// then
        assertThatThrownBy(() -> Cars.fromCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 자동차가 없는 경우 예외를 발생하지 않는다.")
    @Test
    void nonDuplicateCar() {
        //given
        List<String> carNames = List.of("pobi", "woni", "jun");

        //when //then
        assertThatCode(() -> Cars.fromCarNames(carNames))
                .doesNotThrowAnyException();
    }
}