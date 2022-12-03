package subway.dto;

public class FinalStationsDTO {

    private final String upFinalStationName;
    private final String downFinalStationName;

    public FinalStationsDTO(String upFinalStationName, String downFinalStationName) {
        this.upFinalStationName = upFinalStationName;
        this.downFinalStationName = downFinalStationName;
    }

    public String getUpFinalStationName() {
        return upFinalStationName;
    }

    public String getDownFinalStationName() {
        return downFinalStationName;
    }
}
