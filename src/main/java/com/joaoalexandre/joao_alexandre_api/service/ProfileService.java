package com.joaoalexandre.joao_alexandre_api.service;

import com.joaoalexandre.model.Profile;

public interface ProfileService {

    Profile findById(Long id);

    Profile findByDocument(String document);

    Profile create(Profile profileToCreate);

}