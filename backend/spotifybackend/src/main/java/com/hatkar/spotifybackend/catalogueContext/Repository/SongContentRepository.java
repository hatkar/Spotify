package com.hatkar.spotifybackend.catalogueContext.Repository;

import com.hatkar.spotifybackend.catalogueContext.domain.SongContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongContentRepository extends JpaRepository<SongContent, Long> {
}
