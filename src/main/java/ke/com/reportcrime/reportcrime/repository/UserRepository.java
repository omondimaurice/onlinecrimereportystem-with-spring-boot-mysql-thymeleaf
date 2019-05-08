package ke.com.reportcrime.reportcrime.repository;

import ke.com.reportcrime.reportcrime.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String Email);
   List<User> findAll();

}
