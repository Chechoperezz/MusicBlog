package com.example.MusicBlog.CONTROLLERS;

import com.example.MusicBlog.DTO.RegistrationDTO;
import com.example.MusicBlog.MODELS.UserEntity;
import com.example.MusicBlog.SERVICE.UserEntityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private final UserEntityService userEntityService;

    @Autowired
    public AuthController(UserEntityService userEntityService) {
        this.userEntityService = userEntityService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/auth/register")
    public String getRegisterForm(Model model) {
        RegistrationDTO user = new RegistrationDTO();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register/save")
    public String register(@Valid @ModelAttribute("user") RegistrationDTO user, BindingResult result, Model model) {

        System.out.println("Datos del formulario recibidos:");
        System.out.println("Nombre de usuario: " + user.getUserName());
        System.out.println("Nombre: " + user.getName());
        System.out.println("Apellido: " + user.getLastName());
        System.out.println("Correo electrónico: " + user.getEmail());
        System.out.println("Número de teléfono: " + user.getPhoneNumber());
        System.out.println("Contraseña: " + user.getPassword());

        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }

        UserEntity existingUserEmail = userEntityService.findByEmail(user.getEmail());
        if (existingUserEmail != null && existingUserEmail.getEmail() != null && !existingUserEmail.getEmail().isEmpty()) {
            return "redirect:/register?fail";
        }

        UserEntity existingUserName = userEntityService.findByUserName(user.getUserName());
        if (existingUserName != null && existingUserName.getUserName() != null && !existingUserName.getUserName().isEmpty()) {
            return "redirect:/register?fail";
        }

        userEntityService.saveUser(user);
        return "redirect:/blog";
    }

}
