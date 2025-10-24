package racingcar.utils;

public class StubRandomNumberGenerator implements RandomNumberStrategy {
    private int randomNumber;

    public StubRandomNumberGenerator(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    @Override
    public int generateNumber() {
        return randomNumber;
    }
}
