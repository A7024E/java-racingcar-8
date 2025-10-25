package racingcar.exception;

public final class CarNameValidation {

    private CarNameValidation() {

    }

    public static void validate(String input) {
        if (isNullOrEmpty(input)) {
            throw new IllegalArgumentException(ErrorMessages.EMPTY_CAR_NAME.message());
        }
        if (isBlankContains(input)) {
            throw new IllegalArgumentException(ErrorMessages.BLANK_CAR_NAME.message());
        }
        if (isCarNameRange(input)) {
            throw new IllegalArgumentException(ErrorMessages.EXCEED_NAME_LENGTH.message());
        }
    }

    private static boolean isNullOrEmpty(String carName) {
        return carName == null || carName.isEmpty();
    }

    private static boolean isBlankContains(String carName) {
        return carName.contains(" ");
    }

    private static boolean isCarNameRange(String input) {
        return input.length() > 5;
    }
}
