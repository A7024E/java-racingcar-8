package racingcar.model;

import java.util.Objects;
import racingcar.utils.RandomNumberStrategy;

public class Car {
    private final String name;
    private int position;
    private final RandomNumberStrategy randomNumberStrategy;

    private Car(String name, RandomNumberStrategy randomNumberStrategy) {
        validateCar(name);
        this.name = name;
        this.position = 0;
        this.randomNumberStrategy = randomNumberStrategy;
    }

    public static Car from(String name, RandomNumberStrategy randomNumberStrategy) {
        return new Car(name, randomNumberStrategy);
    }

    public void move() {
        int randomNumber = generateRandomNumber();
        if (randomNumber >= 4) {
            moveForward();
        }
    }

    private void moveForward() {
        position += 1;
    }

    private int generateRandomNumber() {
        return randomNumberStrategy.generateRandomNumber();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateCar(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5글자를 넘을 수 없습니다");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
