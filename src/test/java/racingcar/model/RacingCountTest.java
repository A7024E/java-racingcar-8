package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCountTest {
    @DisplayName("시도 횟수를 받아 RacingCount 객체를 생성한다.")
    @Test
    void createRacingCount() {
        // given
        int count = 1;
        // when
        RacingCount racingCount = RacingCount.from(count);
        // then
        assertThat(racingCount).isEqualTo(RacingCount.from(1));
    }

    @DisplayName("시도 횟수가 1보다 작은경우 예외를 발생한다")
    @Test
    void racingCountIsLessThanOne() {
        // given
        int count = 0;
        //when// then
        assertThatThrownBy(() -> RacingCount.from(count))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("경기 횟수를 1회 차감한다")
    @Test
    void decreaseRacingCount() {
        // given
        int count = 1;
        RacingCount racingCount = RacingCount.from(count);

        // when
        racingCount.decrease();

        // then
        assertThat(racingCount.getCount()).isEqualTo(--count);

    }

}