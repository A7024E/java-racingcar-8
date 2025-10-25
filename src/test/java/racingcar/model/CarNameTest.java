package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameTest {
    @DisplayName("자동차이름을 생성할 수 있다.")
    @Test
    void generateName() {
        //given
        String name = "pobi";

        //when
        CarName creatName = CarName.from(name);

        //then
        assertThat(creatName).isEqualTo(CarName.from(name));
    }

    @DisplayName("자동차 이름의 크기가 5를 초과하면 예외를 발생한다.")
    @Test
    void carNameLengthExceedThenFive() {
        //given
        String carName = "pobipobipobipobi";

        //when //then
        assertThatThrownBy(() -> CarName.from(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차의 이름 크기가 5를 초괴하지 않으면 예외를 발생하지 않는다.")
    @Test
    void carNameLengthLessThenFive() {
        //given
        String name = "pobii";

        //when //then
        assertThatCode(() -> CarName.from(name))
                .doesNotThrowAnyException();
    }

    @DisplayName("우승자에 해당하는 자동차를 추가할 수 있다.")
    @Test
    void addWinner() {
        //given
        List<String> winner = new ArrayList<>();

        CarName carName = CarName.from("pobi");

        //when
        winner.add(carName.getCarName());

        //then
        assertThat(winner).containsExactly("pobi");
    }
}