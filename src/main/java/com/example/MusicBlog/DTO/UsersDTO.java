package com.example.MusicBlog.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UsersDTO {

    private Long id;

    @NotEmpty(message = "UserName should not be Empty")
    private String userName;
    @NotEmpty(message = "Name should not be Empty")
    private String Name;
    @NotEmpty(message = "Last Name should not be Empty")
    private String LastName;
    @NotEmpty(message = "Email should not be Empty")
    private String Email;
    @NotEmpty(message = "Phone Number should not be Empty")
    private String PhoneNumber;
    @NotEmpty(message = "Password should not be Empty")
    private String Password;
    @NotEmpty(message = "Birthday should not be Empty")
    private LocalDate Birthday;
}
