package ke.com.reportcrime.reportcrime.service;

import ke.com.reportcrime.reportcrime.model.Crime;
import ke.com.reportcrime.reportcrime.repository.CrimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrimeService {
    @Autowired
    private CrimeRepository crimeRepository;

    public Iterable<Crime> allCrimes() {


        return crimeRepository.findAll();
    }


}
