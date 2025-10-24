package racingcar.model;

import java.util.List;
import java.util.Objects;

public class Winner {
    private String name;
    private int position;

    private Winner(String name) {
        this.name = name;
    }

    public static Winner from(String name) {
        return new Winner(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Winner winner = (Winner) o;
        return Objects.equals(name, winner.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
