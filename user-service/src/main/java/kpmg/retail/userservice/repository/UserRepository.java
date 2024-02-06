package kpmg.retail.userservice.repository;

import kpmg.retail.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findById(long id);
    User findByEncryptedMobile(String encryptedMobile);

    void deleteById(long id);
}