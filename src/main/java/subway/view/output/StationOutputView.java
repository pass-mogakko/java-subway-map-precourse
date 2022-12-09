package subway.view.output;

import java.util.List;
import subway.constants.menu.View;

public class StationOutputView implements OutputView {

    private final static String READ_TITLE = "## 역 목록";

    private final static String SUCCESS_INSERT = "지하철 역이 등록되었습니다.";
    private final static String SUCCESS_DELETE = "지하철 역이 삭제되었습니다.";

    public void printInsertSuccess() {
        System.out.println(View.INFO + SUCCESS_INSERT);
    }

    public void printDeleteSuccess() {
        System.out.println(View.INFO + SUCCESS_DELETE);
    }

    public void printStations(List<String> stationNames) {
        System.out.println(READ_TITLE);
        stationNames.stream()
                .forEach(stationName -> System.out.println(View.INFO + stationName));
    }

}
