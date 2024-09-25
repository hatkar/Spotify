package com.hatkar.spotifybackend.usercontext.domain;

import com.hatkar.spotifybackend.sharedkernel.domain.AbstractAuditingEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@Table(name = "spotify_user")
@Data

public class User extends AbstractAuditingEntity<Long> {
    @Getter
    @Setter
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE,generator = "userSequenceGen")
    @SequenceGenerator(name = "userSequenceGenerator", sequenceName = "user_generator", allocationSize = 1)
    @Column(name ="id")
    private Long id;

   // @NotEmpty
    @Getter
    @Setter
    @Column(name="first_name",nullable = false)
    private String firstName;


    //@NotEmpty
    @Getter
    @Setter
    @Column(name="last_name",nullable = false)
    private String lastName;

    //@NotEmpty
    @Column(name = "email",nullable = false)
    @Email
    private String email;

    @Getter
    @Setter
    private String imageUrl;
    @Getter
    @Setter
    private Subscription subscription = Subscription.FREE;

    public User(Long id, String firstName, String lastName, String email, String imageUrl, Subscription subscription) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.imageUrl = imageUrl;
        this.subscription = subscription;
    }

    public User() {
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

}
