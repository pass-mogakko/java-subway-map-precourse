package subway.domain;

import subway.message.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public enum Function {
    MANAGE_STATION("1", "역 관리"),
    MANAGE_LINE("2", "노선 관리"),
    MANAGE_SECTION("3", "구간 관리"),
    PRINT_LINE_MAP("4", "지하철 노선도 출력"),
    EXIT("Q", "종료")
    ;

    private final String key;
    private final String content;

    Function(final String key, final String content){
        this.key = key;
        this.content = content;
    }

    public static String find(final String command){
        return Arrays.stream(Function.values())
                .filter(function -> Objects.equals(function.getKey(), command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_EXIST_FUNCTION_KEY))
                .key;
    }

    public static List<String> getFunctions(){
        List<String> functions = new ArrayList<>();
        for(Function function : Function.values()){
            functions.add(function.toString());
        }
        return functions;
    }

    public String getKey(){
        return this.key;
    }

    public String getContent(){
        return this.content;
    }

    @Override
    public String toString(){
        return key + ". " + content;
    }
}
