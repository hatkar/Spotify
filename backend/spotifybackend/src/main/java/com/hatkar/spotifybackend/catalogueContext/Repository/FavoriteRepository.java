package com.hatkar.spotifybackend.catalogueContext.Repository;

import com.hatkar.spotifybackend.catalogueContext.domain.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {
}
