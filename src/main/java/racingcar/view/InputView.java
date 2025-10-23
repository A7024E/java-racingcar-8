package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.InputValidation;

public class InputView {

    public String inputCarName() {
        String input = Console.readLine();
        validateInput(input);
        return Console.readLine();
    }

    private static void validateInput(String input) {
        InputValidation.validateCarName(input);
        InputValidation.validateCarNameBlank(input);
    }

}
