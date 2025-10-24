package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.utils.StubRandomNumberGenerator;
import racingcar.utils.RandomNumberGenerator;

class CarTest {

    @DisplayName("이름을 가진 자동차 생성.")
    @Test
    void createCar() {
        //given
        String carName = "pobi";

        //when
        Car car = Car.of(carName,new RandomNumberGenerator());

        //then
        assertThat(car.getName()).isEqualTo(carName);
    }

    @DisplayName("자동차 이름값이 null 또는 빈 문자열이면 true를 반환")
    @ParameterizedTest
    @NullAndEmptySource
    void CarNameNullOrEmptyExcetion(String inputCarName) {
        //given
        //when //Then
        assertThatThrownBy(() -> Car.of(inputCarName,new RandomNumberGenerator()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름을 입력해야 합니다.");
    }

    @DisplayName("입력에 공백이 포함되어 있을 경우 예외발생")
    @ParameterizedTest
    @ValueSource(strings = {" ", "pobi ", "pobi,woni, jun"})
    void inputCarNameBlank(String inputCarName) {
        //when//Then
        assertThatThrownBy(() -> Car.of(inputCarName,new RandomNumberGenerator()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공백을 입력할 수 없습니다.");

    }
    @DisplayName("입력에 공백이 포함되어 있을 경우 예외발생")
    @Test
    void carNameNotFiveRange() {
        //given
        String carName = "pobipobi";
        //when //Then
        assertThatThrownBy(() -> Car.of(carName,new RandomNumberGenerator()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 5글자를 넘을 수 없습니다");
    }



    @DisplayName("Car 객체로 생성된 자동차의 초기 Position 값은 0이다")
    @Test
    void createCar_setsInitialPositionToZero(){
        //given
        String carName = "woni";

        //when
        Car car = Car.of(carName,new RandomNumberGenerator());

        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("자동차의 이름이 5글자 초과시 예외처리")
    @Test
    void createCar_whenNameLengthExceedsFive_thenThrowException(){
        //given
        String carName = "woniwoni";

        //when //then
        assertThatThrownBy(()->Car.of(carName,new RandomNumberGenerator()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("무작위 값이 4 이상이면 자동차가 전진한다")
    @Test
    void moveForward(){
        // given
        int randomNumber = 4;
        Car car = Car.of("pobi",new StubRandomNumberGenerator(randomNumber));
        // when
        car.move();
        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("무작위 값이 4보다 적으면 자동차가 전진하지 않는다")
    @Test
    void notMoveForward(){
        // given
        int randomNumber = 3;
        Car car = Car.of("pobi",new StubRandomNumberGenerator(randomNumber));
        // when
        car.move();
        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }

}