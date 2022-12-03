package subway.view.constants;

import static subway.view.constants.SubCommand.CREATE;
import static subway.view.constants.SubCommand.DELETE;
import static subway.view.constants.SubCommand.READ;

public enum SubDisplay {

    STATION_CREATE("역 등록", CREATE),
    STATION_DELETE("역 삭제", DELETE),
    STATION_READ("역 조회", READ),

    LINE_CREATE("노선 등록", CREATE),
    LINE_DELETE("노선 삭제", DELETE),
    LINE_READ("노선 조회", READ),

    PATH_CREATE("구간 등록", CREATE),
    PATH_DELETE("구간 삭제", DELETE),

    BACK("돌아가기", SubCommand.BACK)
    ;

    private final String menu;
    private final SubCommand command;

    SubDisplay(String menu, SubCommand command) {
        this.menu = menu;
        this.command = command;
    }

    public String getMenu() {
        return menu;
    }

    public String getCommandKey() {
        return command.getKey();
    }
}
