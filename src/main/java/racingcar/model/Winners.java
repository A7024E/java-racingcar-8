package racingcar.model;

import java.util.List;
import java.util.Objects;

public class Winners {
    private final List<Winner> winners;

    private Winners(List<Winner> winners) {
        this.winners = winners;
    }

    public static Winners of(List<Winner> winners) {
        return new Winners(winners);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        };
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Winners winners1 = (Winners) o;
        return Objects.equals(winners, winners1.winners);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(winners);
    }
}
