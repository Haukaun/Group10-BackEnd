package ntnu.group10.backend.group10.repository;

import ntnu.group10.backend.group10.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Role repository.
 * JpaRepository is a JPA specific extension.
 * Full API of CrudRepository.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
