package subway.service;

public class SubwayService {

    private static final SubwayService subwayService = new SubwayService();

    private SubwayService() {
    }

    public static SubwayService getInstance() {
        return subwayService;
    }

}
