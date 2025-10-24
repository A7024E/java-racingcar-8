package racingcar.model;

import java.util.List;
import java.util.Objects;
import racingcar.dto.CarResultDto;
import racingcar.exception.CarValidation;
import racingcar.utils.RandomNumberStrategy;

public class Car {
    private final String name;
    private int position;
    private final RandomNumberStrategy randomNumberStrategy;

    private Car(String name, RandomNumberStrategy randomNumberStrategy) {
        CarValidation.validate(name);
        this.name = name;
        this.position = 0;
        this.randomNumberStrategy = randomNumberStrategy;
    }

    public static Car of(String name, RandomNumberStrategy randomNumberStrategy) {
        return new Car(name, randomNumberStrategy);
    }

    public void move() {
        int randomNumber = generateRandomNumber();
        if (randomNumber >= 4) {
            moveForward();
        }
    }

    public void addWinner(List<String> winners) {
        winners.add(name);
    }

    public int maxPosition(int maxPosition) {
        return Math.max(maxPosition, this.position);
    }

    public boolean isMaxPosition(int maxPosition) {
        return this.position == maxPosition;
    }

    private void moveForward() {
        position += 1;
    }

    private int generateRandomNumber() {
        return randomNumberStrategy.generateNumber();
    }

    public CarResultDto toCarResultDto() {
        return CarResultDto.of(name, position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
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
