package rs.ac.singidunum.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.singidunum.model.User;
import rs.ac.singidunum.model.enums.UserType;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByUsername(String username);
    
    List<User> findByJmbg(String jmbg);
    
    List<User> findByType(UserType type);

    boolean existsByUsername(String username);


}