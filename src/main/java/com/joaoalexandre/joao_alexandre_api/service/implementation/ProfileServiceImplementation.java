package com.joaoalexandre.joao_alexandre_api.service.implementation;


import com.joaoalexandre.joao_alexandre_api.repository.ProfileRepository;
import com.joaoalexandre.joao_alexandre_api.service.ProfileService;
import com.joaoalexandre.model.Profile;

import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

@Service
public class ProfileServiceImplementation implements ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileServiceImplementation(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Profile findById(Long id) {
        return profileRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Profile findByDocument(String document) {
        //Tratamento de excessão para usuário não encontrado
        if(!profileRepository.existsByDocument(document)) {
            throw  new IllegalArgumentException(("Usuario não encontrado"));
        }
        return profileRepository.findByDocument(document);
    }


    @Override
    public Profile create(Profile profileToCreate) {
            //Tratamento de excessão para usuário existente
            if(profileRepository.existsByDocument(profileToCreate.getDocument())) {
                throw  new IllegalArgumentException(("Usuario ja existe"));
            }
            return profileRepository.save(profileToCreate);
    }

}