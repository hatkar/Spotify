package com.hatkar.spotifybackend.usercontext.repository;

import com.hatkar.spotifybackend.usercontext.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
Optional<User> findByEmail(String email);
}
