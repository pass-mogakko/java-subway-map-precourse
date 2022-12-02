package subway.service;

import java.util.List;
import subway.domain.line.LineRepository;
import subway.domain.section.SectionRepository;

public class LineManageService {

    public static void registerLine(String registerLine, String firstStation, String lastStation) {
        LineRepository.addLine(registerLine);
        SectionRepository.registerSection(registerLine, firstStation, lastStation);
    }

    public void validateIsUnregisterLine(String lineName) {
        LineRepository.validateIsUnregisterLine(lineName);
    }

    public void deleteLine(String lineName) {
        LineRepository.deleteLineByName(lineName);
    }

    public List<String> lookupLine() {
        return LineRepository.findAllLineNames();
    }
}
