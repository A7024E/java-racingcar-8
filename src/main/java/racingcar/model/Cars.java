package racingcar.model;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import racingcar.dto.CarResultDto;
import racingcar.utils.RandomNumberGenerator;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        validateCars(cars);
        this.cars = cars;
    }

    public static Cars fromCarNames(List<String> cars){
        return Cars.from(generateCars(cars));
    }

    private static Cars from(List<Car> cars) {
        return new Cars(cars);
    }

    private void validateCars(List<Car> cars) {
        Set<Car> nonDuplicateCars = new HashSet<>(cars);
        if (nonDuplicateCars.size() != cars.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복이 될 수 없습니다");
        }
    }

    private static List<Car> generateCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(Car.of(carName, new RandomNumberGenerator()));
        }
        return cars;
    }

    public void carsMove() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<String> findWinnersByMaxPosition() {
        int maxPosition = findMaxPosition();
        return addWinners(maxPosition);
    }

    private int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = car.maxPosition(maxPosition);
        }
        return maxPosition;
    }

    private List<String> addWinners(int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isMaxPosition(maxPosition)) {
                car.addWinner(winners);
            }
        }
        return winners;
    }

    public List<CarResultDto> carStatusResult() {
        List<CarResultDto> racingResult = new ArrayList<>();
        for (Car car : cars) {
            CarResultDto carResultDto = car.toCarResultDto();
            racingResult.add(carResultDto);
        }
        return racingResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cars);
    }
}
