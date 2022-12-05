package subway.domain.line;

import subway.message.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public enum LineManage {
    REGISTER("1", "노선 등록"),
    DELETE("2", "노선 삭제"),
    SEARCH_LIST("3", "노선 조회"),
    TURN_BACK("B", "돌아가기");

    private final String key;
    private final String content;

    LineManage(final String key, final String content) {
        this.key = key;
        this.content = content;
    }

    public static List<String> getLineManages() {
        List<String> manages = new ArrayList<>();
        for (LineManage manage : LineManage.values()) {
            manages.add(manage.toString());
        }
        return manages;
    }

    public static String find(String manage) {
        return Arrays.stream(LineManage.values())
                .filter(lineManage -> Objects.equals(lineManage.key, manage))
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

    public static boolean isSearchList(final String command) {
        return Objects.equals(SEARCH_LIST.key, command);
    }

    public static boolean isTurnBack(final String command) {
        return Objects.equals(TURN_BACK.key, command);
    }

    @Override
    public String toString() {
        return key + ". " + content;
    }
}
