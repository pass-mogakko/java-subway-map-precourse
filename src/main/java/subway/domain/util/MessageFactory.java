package subway.domain.util;

public class MessageFactory {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String INFO_PREFIX = "[INFO]";

    public String makeErrorMessage(ErrorCode errorCode) {
        return ERROR_PREFIX + errorCode.getMessage();
    }

    public String makeInfoMessage(String str) {
        return INFO_PREFIX + str;
    }
}
