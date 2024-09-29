package com.hatkar.spotifybackend.usercontext.domain;

import com.hatkar.spotifybackend.sharedkernel.domain.AbstractAuditingEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@Table(name = "spotify_user")


public class User extends AbstractAuditingEntity<Long> {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE,generator = "userSequenceGen")
    @SequenceGenerator(name = "userSequenceGenerator", sequenceName = "user_generator", allocationSize = 1)
    @Column(name ="id")
    private Long id;

   // @NotEmpty

    @Column(name="first_name",nullable = false)
    private String firstName;


    //@NotEmpty

    @Column(name="last_name",nullable = false)
    private String lastName;

    //@NotEmpty
    @Column(name = "email",nullable = false)
    @Email
    private String email;


    private String imageUrl;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

}
