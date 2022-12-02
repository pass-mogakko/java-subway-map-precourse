package subway.service;

import subway.domain.line.LineRepository;

public class LineManageService {

    public void validateIsUnregisterLine(String lineName) {
        LineRepository.validateIsUnregisterLine(lineName);
    }
}
