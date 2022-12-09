package subway.domain.station;

import static subway.domain.constants.ErrorMessage.STATION_NAME_INVALID_LENGTH;
import static subway.domain.constants.SubwayRule.NAME_MINIMUM_LENGTH;

public class Station {
    private final String name;

    public Station(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() < NAME_MINIMUM_LENGTH.getValue()) {
            throw new IllegalArgumentException(STATION_NAME_INVALID_LENGTH.getValue());
        }
    }

    public String getName() {
        return name;
    }
}
