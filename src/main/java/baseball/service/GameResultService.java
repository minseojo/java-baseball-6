package baseball.service;

import baseball.domain.GameResult;

import static baseball.domain.GameResult.*;

public class GameResultService {

    public String showResult(GameResult gameResult) {
        return gameResult.createGameResult();
    }

    public boolean restartGame(String choice) {
        if (choice.equals(RESTART)) {
            return true;
        } else if (choice.equals(EXIT)) {
            return false;
        }

        throw new IllegalArgumentException("1 또는 2 중 하나의 유효한 입력이 필요합니다.");
    }
}
