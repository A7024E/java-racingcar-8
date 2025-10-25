package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import racingcar.dto.CarResultDto;
import racingcar.exception.CarsValidation;
import racingcar.utils.RandomNumberGenerator;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        CarsValidation.validate(cars);
        this.cars = cars;
    }

    public static Cars fromCarNames(List<String> carsNames) {
        return Cars.fromCars(generateCars(carsNames));
    }

    protected static Cars fromCars(List<Car> cars) {
        return new Cars(cars);
    }

    private static List<Car> generateCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(Car.of(carName, new RandomNumberGenerator()));
        }
        return cars;
    }

    public void move() {
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
