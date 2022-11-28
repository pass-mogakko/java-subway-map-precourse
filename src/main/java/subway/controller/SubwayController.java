package subway.controller;

import subway.service.SubwayService;

public class SubwayController {

    private static final SubwayController subwayController = new SubwayController();
    private static final SubwayService subwayService = SubwayService.getInstance();

    private SubwayController() {

    }

    public static SubwayController getInstance() {
        return subwayController;
    }

    public void run() {

    }
}
