package com.Nima.myai.repository;

import com.Nima.myai.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.Nima.myai.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

//    @Query("SELECT c FROM User c WHERE c.email = :email2")
    User getUserByEmail(String email);
}
