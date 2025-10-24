package racingcar.model;

import java.util.Objects;
import racingcar.exception.RacingCountValidation;

public class RacingCount {
    private int count;

    private RacingCount(int count) {
        RacingCountValidation.validate(count);
        this.count = count;
    }

    public static RacingCount from(int count) {
        return new RacingCount(count);
    }

    public void decrease() {
        count -= 1;
    }

    public boolean hasRemaining() {
        return count != 0;
    }

    public int getCount() {
        return count;
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
