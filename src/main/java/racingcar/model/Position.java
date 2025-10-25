package racingcar.model;

import java.util.Objects;
import racingcar.exception.PositionValidation;

public class Position {
    public int position;

    private Position(int position) {
        PositionValidation.validate(position);
        this.position = position;
    }

    public static Position from(int position) {
        return new Position(position);
    }

    public void forward() {
        position = position + 1;
    }

    public int calculateMaxPosition(int maxPosition) {
        return Math.max(maxPosition, this.position);
    }

    public boolean isSamePosition(int maxPosition) {
        return this.position == maxPosition;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(position);
    }
}
