package subway.controller;

public class SubwayController {

    private static final SubwayController subwayController = new SubwayController();

    private SubwayController() {

    }

    public static SubwayController getInstance() {
        return subwayController;
    }

    public void run() {

    }
}
