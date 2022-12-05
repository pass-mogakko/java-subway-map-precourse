package subway.constants.menu;

public class SectionView implements View {

    public final static String MANAGEMENT_TITLE = "## 구간 관리 화면";

    public final static String INSERT_MENU = "1. 구간 등록";
    public final static String DELETE_MENU = "2. 구간 삭제";

    @Override
    public String getMenu() {
        return String.join("\n",MANAGEMENT_TITLE, INSERT_MENU, DELETE_MENU, BACK);
    }
}
