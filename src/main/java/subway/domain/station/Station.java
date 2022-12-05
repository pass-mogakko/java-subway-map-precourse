package subway.domain.station;

import subway.constant.Constant;
import subway.constant.ErrorMessage;

public class Station {

    private final String name;

    public Station(String name) {
        validate(name);
        this.name = name;
    }

    private static void validate(String name) {
        if (name.length() < Constant.STATION_NAME_SIZE_MIN) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_STATION_NAME_SIZE);
        }
    }

    public String getName() {
        return name;
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }

    // 추가 기능 구현
}
