package racingcar.model;

import java.util.List;
import java.util.Objects;
import racingcar.dto.CarResultDto;

public class Racing {
    private final Cars cars;
    private final RacingCount racingCount;

    public Racing(List<String> cars, int tryCount) {
        this.cars = Cars.fromCarNames(cars);
        this.racingCount = RacingCount.from(tryCount);
    }

    public static Racing of(List<String> carNames, int tryCount) {
        return new Racing(carNames, tryCount);
    }

    public void raceOnce() {
        cars.move();
    }

    public boolean canRace() {
        return racingCount.hasRemaining();
    }

    public void decrementRacingCount() {
        racingCount.decrease();
    }

    public List<CarResultDto> racingResult() {
        return cars.carStatusResult();
    }

    public List<String> findWinners() {
        return cars.findWinnersByMaxPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Racing racing = (Racing) o;
        return Objects.equals(cars, racing.cars) && Objects.equals(racingCount, racing.racingCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, racingCount);
    }
}
