package racingcar.controller;

import racingcar.domain.*;
import racingcar.domain.numbergenerator.NumberGenerator;
import racingcar.domain.numbergenerator.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private static final String DELIMITER = ",";

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final NumberGenerator numberGenerator = new RandomNumberGenerator();

    private final Cars cars;
    private final GameTime gameTime;

    public GameController() {
        this.cars = new Cars(initCars());
        this.gameTime = initGameTime();
    }

    private static GameTime initGameTime() {
        String gameTime = inputView.inputGameTime();
        return new GameTime(gameTime);
    }

    private String[] initCars() {
        return inputView.inputCarName();
    }

    public void runGame() {
        while (gameTime.isInPlay()) {
            runSingleRound();
            gameTime.runOnce();
        }
    }

    private void runSingleRound() {
        cars.moveCars(numberGenerator);
        cars.getCars()
                .forEach(car -> outputView.printPosition(
                        car.getCarName().getCarName(), car.getPosition().getPosition()));
        System.out.println();
    }

    public void finishGame() {
        Winners winners = new Winners(cars);
        cars.getCars()
                .forEach(car -> outputView.printPosition(
                        car.getCarName().getCarName(), car.getPosition().getPosition()));
        outputView.printWinners(winners);
    }
}
