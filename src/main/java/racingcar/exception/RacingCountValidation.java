package racingcar.exception;

public class RacingCountValidation {

    private RacingCountValidation() {

    }

    public static void validate(int count) {
        if (isRacingCountRange(count)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_RACING_COUNT.message());
        }
    }

    private static boolean isRacingCountRange(int count) {
        return count <= 0;
    }

}
