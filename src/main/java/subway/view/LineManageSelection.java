package subway.view;

import java.util.Arrays;
import subway.constant.ErrorMessage;
import subway.constant.Message;

public enum LineManageSelection {
    ONE("1", "노선 등록"),
    TWO("2", "노선 삭제"),
    THREE("3", "노선 조회"),
    BACK("B", "돌아가기");

    private final String selection;
    private final String content;

    LineManageSelection(String selection, String content) {
        this.selection = selection;
        this.content = content;
    }

    public static void validate(String selection) {
        boolean isAnyMatch = Arrays.stream(LineManageSelection.values())
                .anyMatch(lineManageSelection -> lineManageSelection.selection.equals(selection));
        if (!isAnyMatch) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_SELECTION);
        }
    }

    @Override
    public String toString() {
        return String.format(Message.SELECTION_MESSAGE_FORM, selection, content);
    }

    public String getSelection() {
        return selection;
    }
}
