package com.example.MusicBlog.SERVICE.impl;

import com.example.MusicBlog.DTO.RegistrationDTO;
import com.example.MusicBlog.MODELS.Roles;
import com.example.MusicBlog.MODELS.UserEntity;
import com.example.MusicBlog.REPOSITORY.UserEntityRepository;
import com.example.MusicBlog.SERVICE.UserEntityService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserEntityServiceImp implements UserEntityService {

    private UserEntityRepository userEntityRepository;
    private PasswordEncoder passwordEncoder;

    public UserEntityServiceImp(UserEntityRepository userEntityRepository, PasswordEncoder passwordEncoder) {
        this.userEntityRepository = userEntityRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(RegistrationDTO registrationDTO) {
        UserEntity user = new UserEntity();
        user.setUserName(registrationDTO.getUserName());
        user.setName(registrationDTO.getName());
        user.setLastName(registrationDTO.getLastName());
        user.setEmail(registrationDTO.getEmail());
        user.setPhoneNumber(registrationDTO.getPhoneNumber());
        String encodedPassword = passwordEncoder.encode(registrationDTO.getPassword());
        user.setPassword(encodedPassword);

        System.out.println("Guardando usuario en la base de datos:");
        System.out.println("Nombre de usuario: " + user.getUserName());
        System.out.println("Nombre: " + user.getName());
        System.out.println("Apellido: " + user.getLastName());
        System.out.println("Correo electrónico: " + user.getEmail());
        System.out.println("Número de teléfono: " + user.getPhoneNumber());
        System.out.println("Contraseña: " + user.getPassword());

        user.setRoles(Collections.singleton(Roles.USER));
        userEntityRepository.save(user);
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userEntityRepository.findByEmail(email);
    }

    @Override
    public UserEntity findByUserName(String userName) {
        return userEntityRepository.findByUserName(userName);
    }
}
