package baseball.validator;

import baseball.domain.Baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.domain.Baseball.*;

public class BaseballsValidator {

    private static final String ERROR_NOT_NUMBER = "입력한 숫자가 존재하지 않습니다.";
    private static final String ERROR_SIZE_NUMBER = "입력한 숫자는 3자리여야 합니다.";
    private static final String ERROR_RANGE_NUMBER = "입력한 숫자는 1에서 9사이의 숫자여야 합니다.";
    private static final String ERROR_DUPLICATE_NUMBER = "입력한 숫자는 중복되지 않아야 합니다..";

    static public void validate(List<Baseball> baseballs) {
        validateNotNullAndNotEmpty(baseballs);
        validateNumeric(baseballs);
        validateNumberOfBalls(baseballs);
        validateDuplicates(baseballs);
    }

    private static void validateNotNullAndNotEmpty(List<Baseball> baseballs) {
        if (baseballs == null || baseballs.isEmpty()) {
            throwIllegalArgumentException(ERROR_NOT_NUMBER);
        }
    }

    private static void validateNumeric(List<Baseball> baseballs) {
        baseballs.stream()
                .filter(ball -> ball.number() == null || ball.number() < MIN_BALL || ball.number() > MAX_BALL)
                .findAny()
                .ifPresent(ball -> throwIllegalArgumentException(ERROR_RANGE_NUMBER));
    }

    private static void validateNumberOfBalls(List<Baseball> baseballs) {
        if (baseballs.size() != BALL_SIZE) {
            throwIllegalArgumentException(ERROR_SIZE_NUMBER);
        }
    }

    private static void validateDuplicates(List<Baseball> baseballs) {
        Set<Integer> set = new HashSet<>();
        for (Baseball baseball : baseballs) {
            if (set.contains(baseball.number())) {
                throwIllegalArgumentException(ERROR_DUPLICATE_NUMBER);
            }
            set.add(baseball.number());
        }
    }

    private static void throwIllegalArgumentException(String message) {
        throw new IllegalArgumentException(message);
    }
}
