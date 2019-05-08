package ke.com.reportcrime.reportcrime.service;

import ke.com.reportcrime.reportcrime.repository.IncidenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidenceService {

    @Autowired
    private IncidenceRepository incidenceRepository;

    public List getAllincidence(){
        return incidenceRepository.findAll();
    }
}
