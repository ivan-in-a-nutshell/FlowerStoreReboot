package com.example.demo.service;

import com.example.demo.entity.AppUser;
import com.example.demo.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserService {
    private final AppUserRepository appUserRepository;

    @Autowired
    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public List<AppUser> getUsers() {
        return appUserRepository.findAll();
    }

    public void addNewUser(AppUser appUser) {
        Optional<AppUser> userOptional = appUserRepository.findUserByEmail(appUser.getEmail());

        if (userOptional.isPresent()) {
            throw new IllegalStateException("Email already taken");
        }

        appUserRepository.save(appUser);
    }
}
