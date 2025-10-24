package racingcar.dto;

public record CarResultDto(String name,int position) {

    public static CarResultDto of(String carName, int position){
        return new CarResultDto(carName,position);
    }
}
