package racingcar.model;

import java.util.List;
import java.util.Objects;
import racingcar.exception.CarNameValidation;

public class CarName {

    private String carName;

    private CarName(String carName) {
        CarNameValidation.validate(carName);
        this.carName = carName;
    }

    public static CarName from(String carName) {
        return new CarName(carName);
    }

    public void add(List<String> winners) {
        winners.add(this.carName);
    }

    public String getCarName() {
        return carName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarName carName1 = (CarName) o;
        return Objects.equals(carName, carName1.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(carName);
    }
}
