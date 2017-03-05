package com.aynulin.dalividali.user.model;

/**
 * Created by Aynulin on 30.01.2017.
 */


import com.aynulin.dalividali.app.model.UserCountry;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_accounts")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "first_name", length = 100,nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 100, nullable = false)
    private String lastName;

    @Column(name = "password", length = 255)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", length = 20, nullable = false)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(name = "sign_in_provider", length = 20)
    private SocialMediaService signInProvider;

    @OneToMany(mappedBy = "primaryKey.user",
            cascade = CascadeType.ALL)
    private Set<UserCountry> userCountries = new HashSet<>();

    public User() {

    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public SocialMediaService getSignInProvider() {
        return signInProvider;
    }

    public Set<UserCountry> getUserCountries() {
        return userCountries;
    }

    public void setUserCountries(Set<UserCountry> userCountries) {
        this.userCountries = userCountries;
    }

    public void addUserCountry(UserCountry userCountry) {
        this.userCountries.add(userCountry);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", signInProvider=" + signInProvider +
                '}';
    }

    public static class Builder {

        private User user;

        public Builder() {
            user = new User();
            user.role = Role.ROLE_USER;
        }

        public Builder email(String email) {
            user.email = email;
            return this;
        }

        public Builder firstName(String firstName) {
            user.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            user.lastName = lastName;
            return this;
        }

        public Builder password(String password) {
            user.password = password;
            return this;
        }

        public Builder signInProvider(SocialMediaService signInProvider) {
            user.signInProvider = signInProvider;
            return this;
        }

        public User build() {
            return user;
        }
    }

}
