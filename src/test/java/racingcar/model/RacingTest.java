package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.RandomNumberGenerator;
import racingcar.utils.StubRandomNumberGenerator;

class RacingTest {
    @DisplayName("자동차 객체와 레이싱 카운트 객체 를 이용하여 경주생성 테스트")
    @Test
    void createRacing() {
        // given
        Cars cars = Cars.from(List.of(
                Car.from("pobi",new RandomNumberGenerator()),
                Car.from("woni",new RandomNumberGenerator()),
                Car.from("jun",new RandomNumberGenerator())
        ));

        RacingCount racingCount = RacingCount.from(1);
        // when
        Racing racing = Racing.from(cars);
        // then
        assertThat(racing).isEqualTo(Racing.from(cars));
    }

    @DisplayName("경주가 잘 진행되는지 테스트한다")
    @Test
    void runRacing() {
        // given
        Car pobi = Car.from("pobi", new StubRandomNumberGenerator(4));
        Car woni = Car.from("woni", new StubRandomNumberGenerator(3));
        Car jun = Car.from("jun", new StubRandomNumberGenerator(2));

        Cars cars = Cars.from(List.of(pobi,woni,jun));
        Racing racing = Racing.from(cars);
        // when
        racing.raceOnce();
        // then
        assertThat(pobi.getPosition()).isEqualTo(1);
        assertThat(woni.getPosition()).isEqualTo(0);
        assertThat(jun.getPosition()).isEqualTo(0);

    }


}