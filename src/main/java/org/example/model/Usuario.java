package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Usuario {
    private Integer id;
    private Name name;
    private Login login;
    private String email;
    private UserDate dob;
    private UserDate registered;
    private String phone;
    private String cell;
}
