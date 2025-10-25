package racingcar.exception;

public enum ErrorMessages {
    EMPTY_CAR_NAME("자동차 이름을 입력해야 합니다."),
    BLANK_CAR_NAME("공백을 입력할 수 없습니다."),
    EXCEED_NAME_LENGTH("자동차의 이름은 5글자를 넘을 수 없습니다."),
    DUPLICATE_CAR_NAME("자동차 이름은 중복이 될 수 없습니다."),
    NEGATIVE_POSITION("포지션은 음수가 될 수 없습니다."),
    INVALID_RACING_COUNT("시도 횟수는 최소 1 이상이여야 합니다."),
    INVALID_RACING_COUNT_INPUT("시도 횟수는 정수로 입력해야 합니다.");


    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}