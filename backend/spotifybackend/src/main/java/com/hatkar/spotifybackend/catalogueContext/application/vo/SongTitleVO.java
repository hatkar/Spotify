package com.hatkar.spotifybackend.catalogueContext.application.vo;

import jakarta.validation.constraints.NotBlank;

public record SongTitleVO(@NotBlank String value) {
}
