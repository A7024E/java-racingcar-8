package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements RandomNumberStrategy {

    @Override
    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }
}
