package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.exception.CarValidation;
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
            throw new IllegalArgumentException("시도 횟수는 1이상의 정수로 입력해야 합니다.");
        }
    }
}
