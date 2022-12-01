package subway.controller;

import subway.view.InputView;

public class SubwayController {

    private final InputView inputView = new InputView();

    public void run() {
        inputView.requestMainScreenSelection();
    }
}
