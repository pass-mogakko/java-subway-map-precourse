package subway.view.output;

import java.util.List;
import subway.constants.menu.View;

public class LineOutputView implements OutputView {

    private final static String READ_TITLE = "## 노선 목록";

    private final static String SUCCESS_INSERT = "지하철 노선이 등록되었습니다.";
    private final static String SUCCESS_DELETE = "지하철 노선이 삭제되었습니다.";

    public void printInsertSuccess() {
        System.out.println(View.INFO + SUCCESS_INSERT);
    }

    public void printDeleteSuccess() {
        System.out.println(View.INFO + SUCCESS_DELETE);
    }

    public void printLines(List<String> lineNames) {
        System.out.println(READ_TITLE);
        lineNames.stream()
                .forEach(name -> System.out.println(View.INFO + name));
    }

}
