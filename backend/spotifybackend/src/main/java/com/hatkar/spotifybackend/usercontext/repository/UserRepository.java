package com.hatkar.spotifybackend.usercontext.repository;

import com.hatkar.spotifybackend.usercontext.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
