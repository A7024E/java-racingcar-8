package racingcar.model;

public class Car {
    private final String name;
    private final int position;

    private Car(String name) {
        validateCar(name);
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

    private void validateCar(String name){
        if(name.length() > 5){
            throw new IllegalArgumentException("자동차의 이름은 5글자를 넘을 수 없습니다");
        }
    }
}
