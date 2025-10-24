package racingcar.view;

import java.util.List;

public class OutputView {

    public void printInputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printTryCount(){
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printRacingResultMessage(){
        System.out.println(System.lineSeparator()+"실행 결과");
    }

    public void printRacingResult(List<String> racingResult) {
        for (String input : racingResult) {
            System.out.println(input);
        }
        System.out.println();
    }


}
