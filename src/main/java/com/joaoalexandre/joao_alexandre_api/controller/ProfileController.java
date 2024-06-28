package com.joaoalexandre.joao_alexandre_api.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.joaoalexandre.joao_alexandre_api.service.ProfileService;
import com.joaoalexandre.model.Profile;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/{document}")
    public ResponseEntity<Profile> findByDocument(@PathVariable String document) {
        var user = profileService.findByDocument(document);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<Profile> create(@RequestBody Profile userToCreate) {
        var userCreated = profileService.create(userToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(userCreated);
    }
}