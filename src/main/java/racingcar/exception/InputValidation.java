package racingcar.exception;

public final class InputValidation {

    private InputValidation() {

    }

    public static boolean isNullOrEmpty(String carName) {
        return carName == null || carName.isEmpty() ;
    }

    public static boolean isBlankContains(String carName) {
        return carName.contains(" ");
    }
}
