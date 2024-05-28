package gioelefriggia.sassariSoccorso.payloads;

import gioelefriggia.sassariSoccorso.entities.Role;
import lombok.Data;

@Data
public class UserRegistrationDTO {
    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;
    private String birthdate;
    private String residence;
    private String city;
    private String membershipNumber;
    private Role role;
}
