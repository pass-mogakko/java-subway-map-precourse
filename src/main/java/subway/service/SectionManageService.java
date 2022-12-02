package subway.service;

import subway.constant.ErrorMessage;
import subway.domain.section.SectionRepository;

public class SectionManageService {

    public void validateIsPossibleOrder(String lineName, int order) {
        int sectionSize = SectionRepository.findSectionSizeByLineName(lineName);
        if (sectionSize + 1 < order) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_SECTION_ORDER);
        }
    }
}
