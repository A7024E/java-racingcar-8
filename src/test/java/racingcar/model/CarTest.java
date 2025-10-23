package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("입력된 이름으로 자동차를 생성할 수 있다.")
    @Test
    void createCar() {
        //given
        String carName = "pobi";

        //when
        Car car = Car.from(carName);

        //then
        assertThat(car.getName()).isEqualTo(carName);
    }

    @DisplayName("자동차의 초기값은 0이다")
    @Test
    void createCar_setsInitialPositionToZero(){
        //given
        String carName = "woni";

        //when
        Car car = Car.from(carName);

        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("자동차의 이름이 5글자 초과시 예외처리")
    @Test
    void createCar_whenNameLengthExceedsFive_thenThrowException(){
        //given
        String carName = "woniwoni";

        //when //then
        assertThatThrownBy(()->Car.from(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

}