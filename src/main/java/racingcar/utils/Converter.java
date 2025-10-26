package racingcar.utils;

import java.util.List;
import racingcar.exception.ErrorMessages;

public class Converter {

    private Converter() {

    }

    public static List<String> toList(String[] carNames){
        validateDelimiter(carNames);
        return List.of(carNames);
    }

    public static int toInt(String racingCount) {
        try {
            return Integer.parseInt(racingCount);
        } catch (NumberFormatException exception) {
            throw new NumberFormatException(ErrorMessages.INVALID_RACING_COUNT_INPUT.message());
        }
    }

    public static void validateDelimiter(String[] splitCarNames) {
        for (String splitCarName : splitCarNames) {
            if (isNullOrEmpty(splitCarName)) {
                throw new IllegalArgumentException(ErrorMessages.CONTINUOUS_DELIMITER_ERROR_MESSAGE.message());
            }
        }
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
