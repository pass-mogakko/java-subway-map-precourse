package subway.domain;

import static subway.domain.constants.SubwayRule.NAME_MINIMUM_LENGTH;

public class Station {
    private final String name;

    public Station(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() < NAME_MINIMUM_LENGTH.getValue()) {
            throw new IllegalArgumentException("역 이름은 최소 2글자 이상이어야 합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
