package com.example.MusicBlog.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class RegistrationDTO {
    @NotEmpty(message = "El nombre de usuario es obligatorio")
    private String userName;

    @NotEmpty(message = "El nombre es obligatorio")
    private String name;

    @NotEmpty(message = "El apellido es obligatorio")
    private String lastName;

    @NotEmpty(message = "El correo electrónico es obligatorio")
    private String email;

    @NotEmpty(message = "El número de teléfono es obligatorio")
    private String phoneNumber;

    @NotEmpty(message = "La contraseña es obligatoria")
    private String password;

}
