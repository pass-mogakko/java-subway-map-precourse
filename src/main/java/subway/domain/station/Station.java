package subway.domain.station;

public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        Station compareStation = (Station) obj;
        return name.equals(compareStation.getName());
    }

    // 추가 기능 구현
}
