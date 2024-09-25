package com.hatkar.spotifybackend.catalogueContext.application.dto;

import com.hatkar.spotifybackend.catalogueContext.application.vo.SongAuthorVO;
import com.hatkar.spotifybackend.catalogueContext.application.vo.SongTitleVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record SaveSongDTO(@Valid SongTitleVO songTitleVO,
                          @Valid SongAuthorVO songAuthorVO,
                          @NotNull byte[] cover,
                          @NotNull String coverContentType,
                          @NotNull byte[] file,
                          @NotNull String fileContentType) {
}
