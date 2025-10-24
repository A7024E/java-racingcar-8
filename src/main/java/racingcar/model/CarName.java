package racingcar.model;

import java.util.Objects;

public class CarName {
    private String carName;

    private CarName(String carName) {
        this.carName = carName;
    }

    public static CarName from(String carName) {
        return new CarName(carName);
    }

}
