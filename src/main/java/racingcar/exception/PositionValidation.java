package racingcar.exception;

public class PositionValidation {

    private PositionValidation() {

    }

    public static void validate(int position) {
        ensureNonNegative(position);
    }

    private static void ensureNonNegative(int position){
        if(position < 0){
            throw new IllegalArgumentException("포지션은 음수가 될 수 없습니다 ");
        }
    }
}
