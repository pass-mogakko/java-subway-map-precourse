package subway.constants.menu;

public class LineView implements View {

    public final static String MANAGEMENT_TITLE = "## 노선 관리 화면";

    public final static String INSERT_MENU = "1. 노선 등록";
    public final static String DELETE_MENU = "2. 노선 삭제";
    public final static String READ_MENU = "3. 노선 조회";

    @Override
    public String getMenu() {
        return String.join("\n",MANAGEMENT_TITLE, INSERT_MENU, DELETE_MENU, READ_MENU, BACK);
    }

}
