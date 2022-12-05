package subway.domain.station;

import subway.message.ErrorMessage;

public class Station {
    private final String name;

    private static final int MINIMUM_NAME_LENGTH = 2;

    public Station(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateNameLength(String name) {
        if (name.length() < MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.MINIMUM_STATION_NAME_LENGTH);
        }
    }

    // 추가 기능 구현
}
