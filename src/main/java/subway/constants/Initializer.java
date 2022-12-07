package subway.constants;

import java.util.stream.IntStream;
import subway.service.LineService;
import subway.service.SectionService;
import subway.service.StationService;

public class Initializer {

    private final StationService stationService = new StationService();
    private final LineService lineService = new LineService();
    private final SectionService sectionService = new SectionService();

    private final int INIT_START_INDEX = 1;

    private final String[] initStations = {"교대역","강남역","역삼역","남부터미널역","양재역","양재시민의숲역","매봉역"};

    private final String[] initLines = {"2호선","3호선","신분당선"};

    private final String[] initSections = {"교대역,강남역,역삼역","교대역,남부터미널역,양재역,매봉역","강남역,양재역,양재시민의숲역"};

    public void init() {
        initStations();
        initLines();
        initSections();
    }

    private void initStations() {
        stationService.insertStations(initStations);
    }

    private void initLines() {
        IntStream.rangeClosed(0, initLines.length-1)
                        .forEach(i -> lineService.insert(initLines[i],extractUpStop(initSections[i]), extractDownStop(initSections[i])));
    }

    private void initSections() {
        IntStream.rangeClosed(0, initLines.length-1)
                .forEach(i -> sectionService.insertSections(initLines[i],INIT_START_INDEX,initSections[i].split(",")));
    }

    private String extractUpStop(String section) {
        String[] upStop = section.split(",");
        return upStop[0];
    }

    private String extractDownStop(String section) {
        String[] upStop = section.split(",");
        return upStop[upStop.length - 1];
    }

}
