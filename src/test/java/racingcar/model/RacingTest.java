package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.RandomNumberGenerator;

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
        Racing racing = Racing.of(cars, racingCount);
        // then
        assertThat(racing).isEqualTo(Racing.of(cars, racingCount));
    }


}