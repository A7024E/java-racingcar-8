package racingcar.exception;

public final class CarNameValidation {

    private CarNameValidation() {

    }

    public static void validate(String input) {
        if (isNullOrEmpty(input)) {
            throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
        }
        if (isBlankContains(input)) {
            throw new IllegalArgumentException("공백을 입력할 수 없습니다.");
        }
        if (isCarNameRange(input)) {
            throw new IllegalArgumentException("자동차의 이름은 5글자를 넘을 수 없습니다");
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
