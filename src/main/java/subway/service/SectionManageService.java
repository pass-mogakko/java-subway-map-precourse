package subway.service;

import subway.constant.ErrorMessage;
import subway.domain.section.Section;
import subway.domain.section.SectionRepository;

public class SectionManageService {

    public void validateIsPossibleOrder(String lineName, int order) {
        int sectionSize = SectionRepository.findSectionSizeByLineName(lineName);
        if (sectionSize + 1 < order) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_SECTION_ORDER);
        }
    }

    public void validateIsAlreadySection(String lineName, String stationName) {
        Section section = SectionRepository.findSectionByLineName(lineName);
        boolean isContain = section.contains(stationName);
        if (isContain) {
            throw new IllegalArgumentException(ErrorMessage.ALREADY_SECTION);
        }
    }
}
