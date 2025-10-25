package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingTest {
    @DisplayName("자동차 객체와 레이싱 카운트 객체 를 이용하여 경주생성 테스트")
    @Test
    void createRacing() {
        // given
        List<String> cars = generateCars();
        int racingCount = 1;
        // when
        Racing racing = Racing.of(cars, racingCount);
        // then
        assertThat(racing).isEqualTo(Racing.of(cars, racingCount));
    }


    @DisplayName("경주가 가능하면 true를 반환")
    @Test
    void returnTrueWhenRacingIsAvailable() {
        // given
        List<String> cars = generateCars();
        int racingCount = 1;
        Racing racing = Racing.of(cars, racingCount);
        // when
        boolean can = racing.canRace();
        // then
        assertThat(can).isEqualTo(true);
    }

    @DisplayName("경주가 가능하면 false를 반환")
    @Test
    void returnFalseWhenCannotRace() {
        // given
        List<String> cars = generateCars();
        int racingCount = 1;
        Racing racing = Racing.of(cars, racingCount);
        racing.decrementRacingCount();
        // when
        boolean can = racing.canRace();
        // then
        assertThat(can).isEqualTo(false);
    }

    private List<String> generateCars() {
        return List.of("pobi", "woni", "jun");
    }
}