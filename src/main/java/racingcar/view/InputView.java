package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.security.PublicKey;
import java.util.List;
import racingcar.exception.InputValidation;
import racingcar.utils.Converter;

public class InputView {

    public List<String> inputCarNames() {
        String input = Console.readLine();
        validateCarNameInput(input);
        String[] inputs = input.split(",");
        return Converter.generateCarNames(inputs);
    }

    public int inputCount() {
        String input = Console.readLine();
        validateRacingCountInput(input);
        return Integer.parseInt(input);
    }

    private static void validateCarNameInput(String input) {
        if (InputValidation.isNullOrEmpty(input)) {
            throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
        }
        if (InputValidation.isBlankContains(input)) {
            throw new IllegalArgumentException("공백을 입력할 수 없습니다.");
        }
    }

    private static void validateRacingCountInput(String racingCount) {
        if (InputValidation.isNullOrEmpty(racingCount)) {
            throw new IllegalArgumentException("시도 횟수를 입력해야 합니다.");
        }
        if (InputValidation.isBlankContains(racingCount)) {
            throw new IllegalArgumentException("공백을 입력할 수 없습니다.");
        }
    }
}
