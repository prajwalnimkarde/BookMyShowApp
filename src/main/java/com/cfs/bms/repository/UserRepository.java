package com.cfs.bms.repository;

import com.cfs.bms.model.Theatre;
import com.cfs.bms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<Theatre> findByEmail(String email);
    User findByName(String name);
    Boolean existsByEmail(String email);
}
