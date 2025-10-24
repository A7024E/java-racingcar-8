package racingcar.exception;

public class RacingCountValidation {

    public static void validate(int count) {
        if (isRacingCountRange(count)) {
            throw new IllegalArgumentException("시도횟수는 최소 1 이상이여야 합니다");
        }
    }

    private static boolean isRacingCountRange(int count) {
        return count <= 0;
    }
}
