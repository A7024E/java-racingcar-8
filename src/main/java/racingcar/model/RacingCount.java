package racingcar.model;

import java.util.Objects;

public class RacingCount {
    private int count;

    private RacingCount(int count) {
        validateRacingCount(count);
        this.count = count;
    }

    public static RacingCount from(int count) {
        return new RacingCount(count);
    }

    public void decrease() {
        count -= 1;
    }

    public int getCount() {
        return count;
    }

    private void validateRacingCount(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("시도횟수는 최소 1 이상이여야 합니다");
        }
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
