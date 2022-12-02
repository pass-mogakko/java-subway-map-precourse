package subway.service;

import java.util.List;
import subway.domain.station.StationRepository;

public class StationManageService {

    public void registerStation(String registerStation) {
        StationRepository.addStation(registerStation);
    }

    public void deleteStation(String deleteStation) {
        StationRepository.deleteStation(deleteStation);
    }

    public List<String> lookupStation() {
        return StationRepository.findAllStationNames();
    }

    public void validateIsRegisterStation(String station) {
        StationRepository.validateIsRegisterStation(station);
    }

}
