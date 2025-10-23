package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
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
        List<String> carInputs = inputView.inputCarNames();
        List<Car> cars = generateCars(carInputs);
        outputView.printTryCount();
        int racingCount = inputView.inputCount();
    }

    private List<Car> generateCars(List<String> carInputs) {
        List<Car> cars = new ArrayList<>();
        for (String name : carInputs) {
            cars.add(Car.from(name));
        }
        return cars;
    }


}
