package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.InputValidation;

public class InputView {

    public String inputCarName() {
        String input = Console.readLine();
        InputValidation.validateCarName(input);
        return Console.readLine();
    }

}
