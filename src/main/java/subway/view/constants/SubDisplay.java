package subway.view.constants;

public enum SubDisplay {

    STATION_CREATE("역 등록"),
    STATION_DELETE("역 삭제"),
    STATION_READ("역 조회"),

    LINE_CREATE("노선 등록"),
    LINE_DELETE("노선 삭제"),
    LINE_READ("노선 조회"),

    PATH_CREATE("구간 등록"),
    PATH_DELETE("구간 삭제"),

    BACK("돌아가기")
    ;

    private final String menu;

    SubDisplay(String menu) {
        this.menu = menu;
    }

    public String getMenu() {
        return menu;
    }
}
