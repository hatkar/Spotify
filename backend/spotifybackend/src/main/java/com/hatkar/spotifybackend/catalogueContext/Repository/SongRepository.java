package com.hatkar.spotifybackend.catalogueContext.Repository;

import com.hatkar.spotifybackend.catalogueContext.domain.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
