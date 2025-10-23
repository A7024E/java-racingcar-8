package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.exception.InputValidation;
import racingcar.utils.Converter;

public class InputView {

    public List<String> inputCarNames() {
        String input = Console.readLine();
        validateInput(input);
        String[] inputs = input.split(",");
        return Converter.generateCarNames(inputs);
    }

    private static void validateInput(String input) {
        InputValidation.validateCarName(input);
        InputValidation.validateCarNameBlank(input);
    }

}
