package racingcar.model;

import java.util.List;

public class Winners {
    private final List<Winner> winners;

    private Winners(List<Winner> winners) {
        this.winners = winners;
    }

    public static Winners of(List<Winner> winners) {
        return new Winners(winners);
    }


}
