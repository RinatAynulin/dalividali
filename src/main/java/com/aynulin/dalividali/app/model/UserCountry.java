package com.aynulin.dalividali.app.model;

import com.aynulin.dalividali.user.model.User;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Aynulin on 03.03.2017.
 */

@Entity
@Table(name = "user_country")
@AssociationOverrides({
        @AssociationOverride(name = "primaryKey.user",
                joinColumns = @JoinColumn(name = "user_id")),
        @AssociationOverride(name = "primaryKey.country",
                joinColumns = @JoinColumn(name = "country_id")) })
public class UserCountry {
    @EmbeddedId
    private UserCountryId primaryKey = new UserCountryId();
    @Column(name = "was_here")
    private boolean wasHere;
    @Column(name = "travel_date")
    private Timestamp travelDate;

    public UserCountryId getPrimaryKey() {
        return primaryKey;
    }

    public boolean isWasHere() {
        return wasHere;
    }

    public Timestamp getTravelDate() {
        return travelDate;
    }

    @Transient
    public User getUser() {
        return primaryKey.getUser();
    }

    @Transient
    public Country getCountry() {
        return primaryKey.getCountry();
    }

    public void setPrimaryKey(UserCountryId primaryKey) {
        this.primaryKey = primaryKey;
    }

    public void setWasHere(boolean wasHere) {
        this.wasHere = wasHere;
    }

    public void setTravelDate(Timestamp travelDate) {
        this.travelDate = travelDate;
    }

    public void setUser(User user) {
        primaryKey.setUser(user);
    }

    public void setCountry(Country country) {
        primaryKey.setCountry(country);
    }
}
