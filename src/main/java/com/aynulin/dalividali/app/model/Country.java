package com.aynulin.dalividali.app.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Aynulin on 03.03.2017.
 */

@Entity
@Table(name = "country")
public class Country {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "default_name")
    private String defaultName;

    @Column(name = "russian_name")
    private String russianName;

    @OneToMany(mappedBy = "primaryKey.country",
            cascade = CascadeType.ALL)
    private Set<UserCountry> userCountries = new HashSet<>();

    public Country() {
    }

    public Country(String defaultName, String russianName) {
        this.defaultName = defaultName;
        this.russianName = russianName;
    }

    public Country(String id, String defaultName, String russianName) {
        this.id = id;
        this.defaultName = defaultName;
        this.russianName = russianName;
    }

    public String getId() {
        return id;
    }

    public String getDefaultName() {
        return defaultName;
    }

    public String getRussianName() {
        return russianName;
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
        return "Country{" +
                "id='" + id + '\'' +
                ", defaultName='" + defaultName + '\'' +
                ", russianName='" + russianName + '\'' +
                '}';
    }
}
