package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.exception.ErrorMessages;
import racingcar.utils.Converter;

public class InputView {

    public List<String> inputCarNames() {
        String input = Console.readLine();
        String[] inputs = input.split(",");
        return Converter.generateCarNames(inputs);
    }

    public int inputCount() {
        return parseRacingCount(Console.readLine());
    }

    private int parseRacingCount(String racingCount) {
        try {
            return Integer.parseInt(racingCount);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_RACING_COUNT_INPUT.message());
        }
    }
}
