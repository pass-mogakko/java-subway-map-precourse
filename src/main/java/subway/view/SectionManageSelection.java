package subway.view;

import java.util.Arrays;
import subway.constant.ErrorMessage;
import subway.constant.Message;

public enum SectionManageSelection {
    ONE("1", "구간 등록"),
    TWO("2", "구간 삭제"),
    FOUR("B", "돌아가기");

    private final String selection;
    private final String content;

    SectionManageSelection(String selection, String content) {
        this.selection = selection;
        this.content = content;
    }

    public static void validate(String selection) {
        boolean isAnyMatch = Arrays.stream(SectionManageSelection.values())
                .anyMatch(sectionManageSelection -> sectionManageSelection.selection.equals(selection));
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
