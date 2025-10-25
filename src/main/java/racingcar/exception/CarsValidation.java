package racingcar.exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.model.Car;

public class CarsValidation {
    private CarsValidation() {

    }
    public static void validate(List<Car> cars) {
        validateCars(cars);
    }

    private static void validateCars(List<Car> cars) {
        Set<Car> nonDuplicateCars = new HashSet<>(cars);
        if (nonDuplicateCars.size() != cars.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복이 될 수 없습니다");
        }
    }
}
