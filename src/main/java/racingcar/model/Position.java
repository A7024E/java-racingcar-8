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

}
