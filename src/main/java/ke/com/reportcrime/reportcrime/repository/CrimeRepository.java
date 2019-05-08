package ke.com.reportcrime.reportcrime.repository;

import ke.com.reportcrime.reportcrime.model.Crime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrimeRepository extends JpaRepository<Crime,Long> {

}
