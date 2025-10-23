package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    @DisplayName("자동차 이름들을 받아 Cars 객체가 잘 생성되는지 확인한다")
    @Test
    void createCars() {
        // given
        List<Car> carsList = List.of(
                Car.from("pobi"),
                Car.from("woni"),
                Car.from("jun")
        );

        // when
        Cars cars = Cars.from(carsList);
        // then
        assertThat(cars).isEqualTo(Cars.from(carsList));
    }

    @DisplayName("자동차 이름이 중복됐을 경우 예외발생")
    @Test
    void carsWithDuplicateNames() {
        // given
        List<Car> carList = List.of(
                Car.from("pobi"),
                Car.from("pobi")
        );
        // when// then
        assertThatThrownBy(()-> Cars.from(carList))
                .isInstanceOf(IllegalArgumentException.class);
    }
}