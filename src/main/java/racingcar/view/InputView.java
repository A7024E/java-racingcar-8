package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.exception.ErrorMessages;
import racingcar.utils.Converter;

public class InputView {

    public List<String> inputCarNames() {
        String input = Console.readLine();
        String[] inputs = input.split(",");
        return Converter.toList(inputs);
    }

    public int inputCount() {
        return Converter.toInt(Console.readLine());
    }

}
