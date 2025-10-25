package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.utils.Converter;

public class InputView {

    private static final String CAR_NAME_DELIMITER = ",";

    public List<String> inputCarNames() {
        String input = Console.readLine();
        String[] inputs = input.split(CAR_NAME_DELIMITER);
        return Converter.toList(inputs);
    }

    public int inputCount() {
        return Converter.toInt(Console.readLine());
    }
}
