package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarResultDto;
import racingcar.utils.RandomNumberGenerator;
import racingcar.utils.StubRandomNumberGenerator;

class RacingTest {
    @DisplayName("자동차 객체와 레이싱 카운트 객체 를 이용하여 경주생성 테스트")
    @Test
    void createRacing() {
        // given
        Cars cars = generateCars();
        RacingCount racingCount = insertRacingCount();
        // when
        Racing racing = Racing.of(cars, racingCount);
        // then
        assertThat(racing).isEqualTo(Racing.of(cars, RacingCount.from(1)));
    }

    @DisplayName("경주가 잘 진행되는지 테스트한다")
    @Test
    void runRacing() {
        // given
        Cars cars = generateCars();
        RacingCount racingCount = insertRacingCount();
        Racing racing = Racing.of(cars, racingCount);
        // when
        boolean raceResult = racing.canRace();
        // then
        assertThat(raceResult).isTrue();
    }

    @DisplayName("경주 결과를 반환한다")
    @Test
    void racingResult() {
        // given
        Cars cars = generateCars();
        RacingCount racingCount = insertRacingCount();
        Racing racing = Racing.of(cars, racingCount);
        racing.raceOnce();

        // when
        List<CarResultDto> racingResults = racing.racingResult();
        // then
        assertThat(racingResults).containsExactly(
                CarResultDto.of("pobi", 1),
                CarResultDto.of("woni", 0),
                CarResultDto.of("jun", 0)
        );
    }

    @DisplayName("우승자를 반환한다.")
    @Test
    void resultRacingWinner() {
        // given
        Cars cars = generateCars();
        RacingCount racingCount = insertRacingCount();
        Racing racing = Racing.of(cars, racingCount);
        racing.raceOnce();
        // when
        List<String> winner = racing.findWinners();
        // then
        assertThat(winner).containsExactly("pobi");

    }

    @DisplayName("우승자들을 반환한다.")
    @Test
    void resultRacingWinners() {
        // given
        Car pobi = Car.from("pobi", new StubRandomNumberGenerator(4));
        Car woni = Car.from("woni", new StubRandomNumberGenerator(4));
        Car jun = Car.from("jun", new StubRandomNumberGenerator(1));

        Cars cars = Cars.from(List.of(pobi, woni, jun));
        Racing racing = Racing.of(cars, RacingCount.from(1));
        racing.raceOnce();
        // when
        List<String> winner = racing.findWinners();
        // then
        assertThat(winner).containsExactly("pobi", "woni");

    }
    private Cars generateCars() {
        Car pobi = Car.from("pobi", new StubRandomNumberGenerator(4));
        Car woni = Car.from("woni", new StubRandomNumberGenerator(3));
        Car jun = Car.from("jun", new StubRandomNumberGenerator(1));

        return Cars.from(
                List.of(pobi, woni, jun)
        );
    }
    private RacingCount insertRacingCount() {
        return RacingCount.from(1);
    }
}