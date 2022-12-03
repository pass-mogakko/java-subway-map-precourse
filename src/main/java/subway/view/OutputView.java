package subway.view;

import java.util.List;

public class OutputView {

    public static void printMainView(List<String> functions){
        System.out.print(System.lineSeparator());
        System.out.println("## 메인 화면");
        for(String function : functions){
            System.out.println(function);
        }
    }
}
