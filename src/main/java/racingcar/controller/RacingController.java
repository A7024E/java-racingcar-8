package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.CarResultDto;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Racing;
import racingcar.model.RacingCount;
import racingcar.utils.RandomNumberGenerator;
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
        racing = Racing.of(cars,count);
    }

    private void displayWinners() {
        List<String> winners = racing.findWinners();
        outputView.printWinner(winners);
    }

    private void runRacingGame() {
        outputView.printRacingResultMessage();
        while (racing.canRace()) {
            racingAround();
        }
    }

    private void racingAround() {
        proceedOneRound();
        List<String> racingResultDtos = oneRoundResult();
        outputView.printRacingResult(racingResultDtos);
    }

    private List<String> oneRoundResult() {
        List<CarResultDto> carResultDtos = racing.racingResult();
        List<String> racingResult = mapToResultStrings(carResultDtos);
        return racingResult;
    }

    private void proceedOneRound() {
        racing.raceOnce();
        racing.decrementRacingCount();
    }

    private static List<String> mapToResultStrings(List<CarResultDto> carResultDtos) {
        return carResultDtos.stream()
                .map(dto -> dto.name() + " : " + "-".repeat(dto.position()))
                .toList();
    }

    private List<String> readyCars() {
        outputView.printInputCarNames();
        return inputView.inputCarNames();
    }

    private int inputRacingCount() {
        outputView.printTryCount();
        return inputView.inputCount();
    }


}
