package com.example.lecture07task;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class CreateForm {
    @NotBlank
    @Length(max = 20)
    private String name;

    @NotBlank
    private String dateOfBirth;

    @NotBlank
    private String country;

}
