package racingcar.exception;

public class RacingCountValidation {

    private static final int MIN_COUNT = 0;

    private RacingCountValidation() {

    }

    public static void validate(int count) {
        if (isInvalidRacingCount(count)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_RACING_COUNT.message());
        }
    }

    private static boolean isInvalidRacingCount(int count) {
        return count <= MIN_COUNT;
    }

}
