package subway.service;

import subway.domain.station.StationRepository;

public class StationManageService {


    public void registerStation(String registerStation) {
        StationRepository.addStation(registerStation);
    }

    public void deleteStation(String deleteStation) {
        StationRepository.deleteStation(deleteStation);
    }
}
