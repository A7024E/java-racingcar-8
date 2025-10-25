package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.dto.CarResultDto;
import racingcar.utils.StubRandomNumberGenerator;
import racingcar.utils.RandomNumberGenerator;

class CarTest {

    @DisplayName("이름을 가진 자동차 생성.")
    @Test
    void createCar() {
        //given
        String carName = "pobi";

        //when
        Car car = Car.of(carName, new RandomNumberGenerator());

        //then
        CarResultDto carStatusDto = car.toCarResultDto();
        assertThat(carStatusDto.name()).isEqualTo(carName);
    }


    @DisplayName("랜덤값의 크기가 4이상이라면 전진할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"4,1", "3,0"})
    void carCanMove(int randomNumber, int position) {
        // given
        Car car = Car.of("pobi", new StubRandomNumberGenerator(randomNumber));
        // when
        car.move();
        // then
        CarResultDto carStatusDto = car.toCarResultDto();
        assertThat(carStatusDto.position()).isEqualTo(position);
    }

    @DisplayName("주어진 전진값과 현재 자동차의 전진값을 비교하여 더 큰 전진값을 반환한다.")
    @Test
    void findMaxPosition() {
        //given
        Car car = Car.of("pobi", new StubRandomNumberGenerator(4));
        int position = 2;

        car.move();
        car.move();
        car.move();
        //when
        int maxPosition = car.maxPosition(position);

        //then
        assertThat(maxPosition).isEqualTo(car.maxPosition(position));
    }

}