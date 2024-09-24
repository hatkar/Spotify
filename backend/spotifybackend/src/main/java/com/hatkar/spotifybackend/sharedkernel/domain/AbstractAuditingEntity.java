package com.hatkar.spotifybackend.sharedkernel.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;
@Data
@Getter
@Setter
//hibernate comprend que a la persistence de lune de deux entite il allimente ses 2 champs si besoin
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditingEntity<T> implements Serializable {

    //public abstract T getId();
    @CreatedDate
    @Column(name = "Created_Date",updatable = false)
    private Instant CreateData = Instant.now();

    @LastModifiedDate
    @Column(name = "LastModified")
    private Instant LastModified = Instant.now();

}
