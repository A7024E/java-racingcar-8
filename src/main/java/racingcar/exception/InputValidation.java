package racingcar.exception;

public class InputValidation {

    public static void validateCarName(String carName){
        if(isCarNameNull(carName) || carName.isEmpty()){
            throw new IllegalArgumentException("경주할 자동차 이름을 입력해야합니다");
        }
    }

    private static boolean isCarNameNull(String carName) {
        return carName == null;
    }


}
