package com.aynulin.dalividali.app.service;

import com.aynulin.dalividali.app.model.Country;
import com.aynulin.dalividali.app.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Aynulin on 05.03.2017.
 */
@Service
public class RepositoryCountryService implements CountryService {
    private CountryRepository countryRepository;

    @Autowired
    public RepositoryCountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country getCountryById(String id) {
        return null;
    }
}
