package subway.view;

import java.util.Arrays;
import subway.constant.ErrorMessage;
import subway.constant.Message;

public enum MainScreenSelection {
    ONE("1", "역 관리"),
    TWO("2", "노선 관리"),
    THREE("3", "구간 관리"),
    FOUR("4", "지하철 노선도 출력"),
    QUIT("Q", "종료");

    private final String selection;
    private final String content;

    MainScreenSelection(String selection, String content) {
        this.selection = selection;
        this.content = content;
    }

    public static void validate(String selection) {
        boolean isAnyMatch = Arrays.stream(MainScreenSelection.values())
                .anyMatch(mainScreenSelection -> mainScreenSelection.selection.equals(selection));
        if (!isAnyMatch) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_SELECTION);
        }
    }

    @Override
    public String toString() {
        return String.format(Message.SELECTION_MESSAGE_FROM, selection, content);
    }

    public String getSelection() {
        return selection;
    }

}
