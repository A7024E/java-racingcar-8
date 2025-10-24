package racingcar.utils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {
    @DisplayName("0부터 9까지 랜덤한 한자리 숫자를 생성한다")
    @Test
    void generateRandomNumber() {
        // given
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        // when
        int randomNumber = randomNumberGenerator.generateNumber();
        // then
        assertThat(randomNumber).isBetween(0,9);
    }

}