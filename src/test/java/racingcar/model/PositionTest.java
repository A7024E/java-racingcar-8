package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PositionTest {
    @DisplayName("Position 객체 생성")
    @Test
    void generatePosition() {
        //given //when
        Position position = Position.from(0);

        //then
        assertThat(position).isEqualTo(Position.from(0));
    }

    @DisplayName("position 이 음수를 가질때 예외발생")
    @Test
    void positionIsNegative(){
        //given
        int position = -1;

        //when //then
        assertThatThrownBy(() -> Position.from(position))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("position 값이 1만큼 증가")
    @Test
    void move() {
        //given
        Position position = Position.from(0);

        //when
        position.forward();

        //then
        assertThat(position).isEqualTo(Position.from(1));
    }

    @DisplayName("주어진 position과 현재 position을 비교하여 더 큰 position을 반환한다.")
    @Test
    void calculateMaxPosition() {
        //given
        int maxPosition = 2;
        int presentPosition = 3;
        Position position = Position.from(presentPosition);

        //when
        int result = position.calculateMaxPosition(maxPosition);

        //then
        assertThat(result).isEqualTo(presentPosition);
    }

    @DisplayName("주어진 최대 position과 현재 position을 비교하여 참, 거짓을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"3, true", "2, false"})
    void isMaxPosition(int maxPosition, boolean expectedValue) {
        //given
        int presentPosition = 3;
        Position position = Position.from(presentPosition);

        //when
        boolean result = position.isSamePosition(maxPosition);

        //then
        assertThat(result).isEqualTo(expectedValue);
    }
}