package racingcar.model;

public class Car {
    private final String name;
    private final int position;

    private Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public static Car from(String name){
        return new Car(name);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
