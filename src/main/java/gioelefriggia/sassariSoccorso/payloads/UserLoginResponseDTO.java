package gioelefriggia.sassariSoccorso.payloads;

import gioelefriggia.sassariSoccorso.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginResponseDTO {
    private String token;
    private User user;
}