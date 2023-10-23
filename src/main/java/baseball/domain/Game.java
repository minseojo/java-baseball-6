package baseball.domain;

import baseball.service.BallGeneratorService;

public class Game {

    private final Balls computerBalls;
    private boolean isGameOver;

    public Game(BallGeneratorService ballGeneratorService) {
        this.computerBalls = ballGeneratorService.generateRandomBalls();
        this.isGameOver = false;
    }

    public Balls getComputerBalls() {
        return computerBalls;
    }

    public void setGameOver() {
        isGameOver = true;
    }

    public boolean isGameOver() {
        return isGameOver;
    }
}