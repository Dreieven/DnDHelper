package com.org.DnDHelper.messages;

import com.org.DnDHelper.configurations.annotations.ValidEmail;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterUserRequest {
    @NotBlank
    @NotNull
    private String name;
    @NotEmpty
    @NotNull
    @ValidEmail
    private String email;
    @NotEmpty
    @NotNull
    private String password;
}
