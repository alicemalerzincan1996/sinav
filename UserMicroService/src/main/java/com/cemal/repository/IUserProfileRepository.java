package com.cemal.repository;

import com.cemal.repository.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserProfileRepository extends JpaRepository<UserProfile,Long> {
    Optional<UserProfile> findOptionalByUsernameAndPassword(String username, String password);
}
