package subway.domain.constants;

public enum SubwayRule {
    NAME_MINIMUM_LENGTH(2),
    LINE_MINIMUM_STATION_COUNT(2),
    PATH_STARTING_INDEX(1);

    private final int value;

    SubwayRule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
