package racingcar.model;

import java.util.Objects;

public class RacingCount {
    private final int count;

    private RacingCount(int count) {
        this.count = count;
    }

    public static RacingCount from(int count) {
        return new RacingCount(count);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RacingCount that = (RacingCount) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(count);
    }
}
