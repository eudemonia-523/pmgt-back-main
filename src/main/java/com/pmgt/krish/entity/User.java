package com.pmgt.krish.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "pmgt_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "display_name", nullable = false)
    private String displayName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "photo_url", nullable = true)
    private String photoUrl;

    @Column(name = "phone_number", nullable = true)
    private String phoneNumber;

    @Column(name = "country", nullable = true)
    private String country;

    @Column(name = "address", nullable = true)
    private String address;

    @Column(name = "state", nullable = true)
    private String state;

    @Column(name = "city", nullable = true)
    private String city;

    @Column(name = "zip_code", nullable = true)
    private String zipCode;

    @Column(name = "about", nullable = true, columnDefinition = "TEXT")
    private String about;

    @Column(name = "role", nullable = true)
    private String role;

    @Column(name = "is_public", nullable = false)
    private boolean isPublic;

}
