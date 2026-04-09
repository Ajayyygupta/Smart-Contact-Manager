package com.scm.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserForm {

    @NotBlank(message="Name is required")
    @Size(min=3, message="Minimum size 3 character is required")
    private String name;
    @NotBlank(message="email is required")
    private String email;
    @NotBlank(message="passwrod is required")
    @Size(min=6, message="minimum 6 character is required")
    private String password;
    private String about;
    @Size(min=8, max=12, message="Invalid phone number")
    private String phoneNumber;
    


}
