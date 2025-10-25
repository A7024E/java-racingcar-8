package racingcar.view;

import java.util.List;

public class OutputView {

    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String RACING_RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE_PREFIX = "최종 우승자 : ";
    private static final String NAME_DELIMITER = ", ";

    public void printInputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
    }

    public void printTryCount() {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
    }

    public void printRacingResultMessage() {
        System.out.println(System.lineSeparator() + RACING_RESULT_MESSAGE);
    }

    public void printRacingResult(List<String> racingResult) {
        for (String input : racingResult) {
            System.out.println(input);
        }
        System.out.println();
    }

    public void printWinner(List<String> winners) {
        String winner = String.join(NAME_DELIMITER, winners);
        System.out.println(WINNER_MESSAGE_PREFIX + winner);
    }

}
