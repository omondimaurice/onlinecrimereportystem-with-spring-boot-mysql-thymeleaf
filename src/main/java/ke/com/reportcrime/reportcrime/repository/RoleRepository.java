package ke.com.reportcrime.reportcrime.repository;

import ke.com.reportcrime.reportcrime.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("roleRepository")
public interface  RoleRepository  extends JpaRepository<Role,Long> {

    Role findByRole(String role);
}
