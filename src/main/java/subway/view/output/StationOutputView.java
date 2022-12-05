package subway.view.output;

import java.util.List;
import subway.constants.menu.View;

public class StationOutputView {

    private final static String READ_TITLE = "## 역 목록";

    public void printStations(List<String> stationNames) {
        System.out.println(READ_TITLE);
        stationNames.stream()
                .forEach(stationName -> System.out.println(View.INFO + stationName));
    }

}
