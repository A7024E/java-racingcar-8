package racingcar.utils;

import java.util.List;
import racingcar.exception.ErrorMessages;

public class Converter {

    private Converter() {

    }

    public static int toInt(String racingCount) {
        try {
            return Integer.parseInt(racingCount);
        } catch (NumberFormatException exception) {
            throw new NumberFormatException(ErrorMessages.INVALID_RACING_COUNT_INPUT.message());
        }
    }

    public static List<String> toList(String[] carNames){
        return List.of(carNames);
    }
}
