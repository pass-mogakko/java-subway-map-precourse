package subway.controller;

import subway.domain.Function;
import subway.view.InputView;
import subway.view.OutputView;

public class MainController {

    public void view(){
        OutputView.printMainView();
        final String function = readFunction();
    }

    private String readFunction(){
        try{
            String function = InputView.inputFunction();
            return Function.get(function);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readFunction();
        }
    }
}
