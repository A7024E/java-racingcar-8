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

    public RacingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        List<String> inputs = inputCarNames();
        Cars cars = generateCars(inputs);

        int count = inputRacingCount();
        RacingCount racingCount = RacingCount.from(count);

        Racing racing = Racing.of(cars, racingCount);

        runRacingGame(racing);
        displayWinners(racing);
    }

    private void displayWinners(Racing racing) {
        List<String> winners = racing.findWinners();
        outputView.printWinner(winners);
    }

    private void runRacingGame(Racing racing) {
        outputView.printRacingResultMessage();
        while (racing.canRace()) {
            racingAround(racing);
        }
    }

    private void racingAround(Racing racing) {
        proceedOneRound(racing);
        List<String> racingResultDtos = oneRoundResult(racing);
        outputView.printRacingResult(racingResultDtos);
    }

    private static List<String> oneRoundResult(Racing racing) {
        List<CarResultDto> carResultDtos = racing.racingResult();
        List<String> racingResult= mapToResultStrings(carResultDtos);
        return racingResult;
    }

    private static void proceedOneRound(Racing racing) {
        racing.raceOnce();
        racing.decrementRacingCount();
    }

    private static List<String> mapToResultStrings(List<CarResultDto> carResultDtos) {
        return carResultDtos.stream()
                .map(dto -> dto.name() + " : " + "-".repeat(dto.position()))
                .toList();
    }

    private List<String> inputCarNames() {
        outputView.printInputCarNames();
        return inputView.inputCarNames();
    }

    private int inputRacingCount() {
        outputView.printTryCount();
        return inputView.inputCount();
    }


    private Cars generateCars(List<String> carInputs) {
        List<Car> cars = new ArrayList<>();
        for (String name : carInputs) {
            cars.add(Car.from(name, new RandomNumberGenerator()));
        }
        return Cars.from(cars);
    }

}
