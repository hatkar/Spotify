package com.hatkar.spotifybackend.catalogueContext.application.dto;

import com.hatkar.spotifybackend.catalogueContext.application.vo.SongAuthorVO;
import com.hatkar.spotifybackend.catalogueContext.application.vo.SongTitleVO;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ReadSongInfoDTO(SongTitleVO title,
                              SongAuthorVO author,
                              @NotNull byte[] cover,
                              @NotNull String coverContentType,
                              @NotNull boolean isFavorite,
                              @NotNull UUID publicID) {
}
