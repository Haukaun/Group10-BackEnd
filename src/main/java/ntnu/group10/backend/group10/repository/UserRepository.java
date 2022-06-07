package ntnu.group10.backend.group10.repository;


import ntnu.group10.backend.group10.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface User repository.
 * JpaRepository is a JPA specific extension.
 * Full API of CrudRepository.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * Finds user by Username.
     *
     * @param userName, the username
     * @return optional user.
     */
    Optional<User> findByUserName(String userName);

    /**
     * Finds user by email.
     *
     * @param email, the email
     * @return optional user.
     */
    Optional<User> findByEmail(String email);

}
