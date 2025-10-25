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
        if (isDupulicateCars(cars, nonDuplicateCars)) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_CAR_NAME.message());
        }
    }

    private static boolean isDupulicateCars(List<Car> cars, Set<Car> nonDuplicateCars) {
        return nonDuplicateCars.size() != cars.size();
    }
}
