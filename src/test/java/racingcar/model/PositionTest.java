package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}