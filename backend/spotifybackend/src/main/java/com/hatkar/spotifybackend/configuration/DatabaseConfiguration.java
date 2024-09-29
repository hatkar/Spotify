package com.hatkar.spotifybackend.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaAuditing
@EnableJpaRepositories({"com.hatkar.spotifybackend.catalogueContext.Repository",
        "com.hatkar.spotifybackend.usercontext.repository"})
public class DatabaseConfiguration {
}
