package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Racing;
import racingcar.model.RacingCount;
import racingcar.utils.Converter;
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
        inputCarNames();
    }

    private void inputCarNames() {
        outputView.printInputCarNames();
        List<String> inputs = inputView.inputCarNames();
        List<Car> carInputs = generateCars(inputs);
        Cars cars = Cars.from(carInputs);
        outputView.printTryCount();
        int count = inputView.inputCount();
        RacingCount racingCount = RacingCount.from(count);

        Racing racing = Racing.from(cars);
        while (!racingCount.isEnd()){
            racing.raceOnce();
            racingCount.decrease();
        }
    }

    private List<Car> generateCars(List<String> carInputs) {
        List<Car> cars = new ArrayList<>();
        for (String name : carInputs) {
            cars.add(Car.from(name,new RandomNumberGenerator()));
        }
        return cars;
    }


}
