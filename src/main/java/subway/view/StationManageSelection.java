package subway.view;

import java.util.Arrays;
import subway.constant.ErrorMessage;
import subway.constant.Message;

public enum StationManageSelection {
    ONE("1", "역 등록"),
    TWO("2", "역 삭제"),
    THREE("3", "역 조회"),
    BACK("B", "돌아가기");

    private final String selection;
    private final String content;

    StationManageSelection(String selection, String content) {
        this.selection = selection;
        this.content = content;
    }

    public static void validate(String selection) {
        boolean isAnyMatch = Arrays.stream(StationManageSelection.values())
                .anyMatch(stationManageSelection -> stationManageSelection.selection.equals(selection));
        if (!isAnyMatch) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_SELECTION);
        }
    }

    public String toKorean() {
        return String.format(Message.SELECTION_MESSAGE_FORM, selection, content);
    }

    public String getSelection() {
        return selection;
    }
}
