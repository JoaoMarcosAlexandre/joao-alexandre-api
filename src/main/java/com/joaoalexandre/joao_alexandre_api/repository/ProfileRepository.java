package com.joaoalexandre.joao_alexandre_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joaoalexandre.model.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    boolean existsByDocument(String document);

    Profile findByDocument(String document);

}