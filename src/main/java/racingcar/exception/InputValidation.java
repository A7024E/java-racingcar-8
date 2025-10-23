package racingcar.exception;

public class InputValidation {

    public static void validateCarName(String carName){
        if(isCarNameNull(carName) || carName.isEmpty()){
            throw new IllegalArgumentException("경주할 자동차 이름을 입력해야합니다");
        }
    }

    public static void validateCarNameBlank(String carName){
        if(isBlankContains(carName)){
            throw new IllegalArgumentException("공백이 포함할 수 없습니다");
        }
    }

    private static boolean isBlankContains(String carName) {
        return carName.contains(" ");
    }

    private static boolean isCarNameNull(String carName) {
        return carName == null;
    }


}
