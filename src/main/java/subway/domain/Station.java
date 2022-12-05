package subway.domain;

import subway.Constants;



public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return Constants.INFO_PREFIX + name;
    }
}
