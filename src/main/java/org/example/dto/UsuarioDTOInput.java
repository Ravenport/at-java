package org.example.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.example.model.Login;
import org.example.model.Name;
import org.example.model.UserDate;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioDTOInput {
    private Integer id;
    private Name name;
    private Login login;
    private String email;
    private UserDate dob;
    private UserDate registered;
    private String phone;
    private String cell;
}
