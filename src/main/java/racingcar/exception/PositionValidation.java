package racingcar.exception;

public class PositionValidation {

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
        return position < 0;
    }
}
