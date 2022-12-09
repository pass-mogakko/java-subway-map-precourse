package subway.constants.menu;

public class StationView implements View {

    public final static String MANAGEMENT_TITLE = "## 역 관리 화면";

    public final static String INSERT_MENU = "1. 역 등록";
    public final static String DELETE_MENU = "2. 역 삭제";
    public final static String READ_MENU = "3. 역 조회";

    public final static String INSERT_MESSAGE = "등록할 역 이름을 입력하세요.";
    public final static String DELETE_MESSAGE = "삭제할 역 이름을 입력하세요.";

    @Override
    public String getMenu() {
        return String.join("\n",MANAGEMENT_TITLE, INSERT_MENU, DELETE_MENU, READ_MENU, BACK);
    }
}
