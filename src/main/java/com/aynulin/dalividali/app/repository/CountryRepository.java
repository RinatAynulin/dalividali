package com.aynulin.dalividali.app.repository;

import com.aynulin.dalividali.app.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Aynulin on 05.03.2017.
 */
public interface CountryRepository extends JpaRepository<Country, String> {
}
