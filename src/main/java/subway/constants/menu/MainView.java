package subway.constants.menu;

public class MainView implements View {

    public final static String MANAGEMENT_TITLE = "## 메인 화면";

    public static final String STATION_MANAGEMENT = "1. 역 관리";
    public static final String LINE_MANAGEMENT = "2. 노선 관리";
    public static final String SECTION_MANAGEMENT = "3. 구간 관리";
    public static final String PRINT_SUBWAY_MAP = "4. 지하철 노선도 출력";
    public static final String EXIT = "Q. 종료";

    @Override
    public String getMenu() {
       return String.join("\n",MANAGEMENT_TITLE, STATION_MANAGEMENT,
               LINE_MANAGEMENT, SECTION_MANAGEMENT, PRINT_SUBWAY_MAP, EXIT);
    }
}
