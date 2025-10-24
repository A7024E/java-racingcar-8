package racingcar.model;

import java.util.Objects;

public class Position {
    public int Position;

    private Position(int position) {
        Position = position;
    }

    public static Position from(int position) {
        return new Position(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return Position == position.Position;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(Position);
    }
}
