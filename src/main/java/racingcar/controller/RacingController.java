package racingcar.controller;

import java.util.List;
import racingcar.dto.CarResultDto;
import racingcar.model.Racing;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private Racing racing;

    public RacingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        prepareRace();
        runRacingGame();
        displayWinners();
    }

    private void prepareRace() {
        List<String> cars = readyCars();
        int count = inputRacingCount();
        racing = Racing.of(cars, count);
    }

    private void runRacingGame() {
        outputView.printRacingResultMessage();
        while (racing.canRace()) {
            racingAround();
        }
    }

    private void displayWinners() {
        List<String> winners = racing.findWinners();
        outputView.printWinner(winners);
    }

    private void racingAround() {
        proceedOneRound();
        List<String> racingResultDtos = oneRoundResult();
        outputView.printRacingResult(racingResultDtos);
    }

    private void proceedOneRound() {
        racing.raceOnce();
        racing.decrementRacingCount();
    }

    private List<String> oneRoundResult() {
        List<CarResultDto> carResultDtos = racing.racingResult();
        return mapToResultStrings(carResultDtos);
    }

    private List<String> readyCars() {
        outputView.printInputCarNames();
        return inputView.inputCarNames();
    }

    private int inputRacingCount() {
        outputView.printTryCount();
        return inputView.inputCount();
    }

    private static List<String> mapToResultStrings(List<CarResultDto> carResultDtos) {
        return carResultDtos.stream()
                .map(dto -> dto.name() + " : " + "-".repeat(dto.position()))
                .toList();
    }
}
