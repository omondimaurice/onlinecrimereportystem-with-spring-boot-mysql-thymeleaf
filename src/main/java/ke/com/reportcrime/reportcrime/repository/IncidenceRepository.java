package ke.com.reportcrime.reportcrime.repository;

import ke.com.reportcrime.reportcrime.model.Incidence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidenceRepository extends JpaRepository<Incidence, Long> {
}
