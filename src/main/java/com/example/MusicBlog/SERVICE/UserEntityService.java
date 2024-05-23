package com.example.MusicBlog.SERVICE;

import com.example.MusicBlog.DTO.RegistrationDTO;
import com.example.MusicBlog.MODELS.UserEntity;

public interface UserEntityService {
    void saveUser(RegistrationDTO registrationDTO);

    UserEntity findByEmail(String email);

    UserEntity findByUserName(String userName);
}
