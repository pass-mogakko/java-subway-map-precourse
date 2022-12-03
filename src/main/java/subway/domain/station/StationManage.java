package subway.domain.station;

import subway.message.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public enum StationManage {
    REGISTER("1", "역 등록"),
    DELETE("2", "역 삭제"),
    INQUIRE("3", "역 조회"),
    TURN_BACK("B", "돌아가기");

    private final String key;
    private final String content;

    StationManage(final String key, final String content) {
        this.key = key;
        this.content = content;
    }

    public static List<String> getStationManages() {
        List<String> manages = new ArrayList<>();
        for (StationManage manage : StationManage.values()) {
            manages.add(manage.toString());
        }
        return manages;
    }

    public static String find(String manage) {
        return Arrays.stream(StationManage.values())
                .filter(stationManage -> Objects.equals(stationManage.key, manage))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_EXIST_FUNCTION))
                .key;
    }

    public static boolean isRegister(final String command) {
        return Objects.equals(REGISTER.key, command);
    }

    public static boolean isDelete(final String command) {
        return Objects.equals(DELETE.key, command);
    }

    public static boolean isInquire(final String command) {
        return Objects.equals(INQUIRE.key, command);
    }

    @Override
    public String toString() {
        return key + ". " + content;
    }
}
