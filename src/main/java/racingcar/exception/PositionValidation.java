package racingcar.exception;

public class PositionValidation {

    private static final int MIN_POSITION = 0;

    private PositionValidation() {

    }

    public static void validate(int position) {
        ensureNonNegative(position);
    }

    private static void ensureNonNegative(int position){
        if(isNegative(position)){
            throw new IllegalArgumentException(ErrorMessages.NEGATIVE_POSITION.message());
        }
    }

    private static boolean isNegative(int position) {
        return position < MIN_POSITION;
    }
}
