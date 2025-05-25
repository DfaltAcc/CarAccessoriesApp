package za.ac.cput.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    User findByName(String name);

    Optional<User> findByPhoneNumber(String PhoneNumber);

    Optional<User> findByEmail(String email);

    List<User> findAllByUserID(String userID);


}
