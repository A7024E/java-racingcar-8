package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.security.PublicKey;
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

    public int inputCount(){
        return Integer.parseInt(Console.readLine());
    }

    private static void validateInput(String input) {
        if(InputValidation.isNullOrEmpty(input)){
            throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
        }
        if(InputValidation.isBlankContains(input)){
            throw new IllegalArgumentException("공백을 입력할 수 없습니다.");
        }
    }

}
