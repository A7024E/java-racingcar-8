package racingcar.model;

import java.util.List;
import java.util.Objects;
import racingcar.dto.CarResultDto;
import racingcar.utils.RandomNumberStrategy;

public class Car {
    private final CarName name;
    private final Position position;
    private final RandomNumberStrategy randomNumberStrategy;

    private Car(String name, RandomNumberStrategy randomNumberStrategy) {
        this.name = CarName.from(name);
        this.position = Position.from(0);
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
        name.add(winners);
    }

    public int maxPosition(int maxPosition) {
        return position.calculateMaxPosition(maxPosition);
    }

    public boolean isMaxPosition(int maxPosition) {
        return position.isSamePosition(maxPosition);
    }

    private void moveForward() {
        position.forward();
    }

    private int generateRandomNumber() {
        return randomNumberStrategy.generateNumber();
    }

    public CarResultDto toCarResultDto() {
        return CarResultDto.of(name.getCarName(), position.getPosition());
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
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
