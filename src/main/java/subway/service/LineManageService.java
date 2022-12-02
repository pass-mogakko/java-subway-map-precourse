package subway.service;

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
}
