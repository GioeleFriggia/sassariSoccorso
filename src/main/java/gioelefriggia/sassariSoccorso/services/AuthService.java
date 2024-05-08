package gioelefriggia.sassariSoccorso.services;


import gioelefriggia.sassariSoccorso.entities.User;
import gioelefriggia.sassariSoccorso.exceptions.UnauthorizedException;
import gioelefriggia.sassariSoccorso.payloads.UserLoginDTO;
import gioelefriggia.sassariSoccorso.security.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UsersService usersService;
    @Autowired
    private JWTTools jwtTools;
    @Autowired
    private PasswordEncoder bcrypt;

    public String authenticateUserAndGenerateToken(UserLoginDTO payload) {
        User user = this.usersService.findByEmail(payload.email());
        if (bcrypt.matches(payload.password(), user.getPassword())) {
            return jwtTools.createToken(user);
        } else {
            throw new UnauthorizedException("Invalid credentials! Please log in again.");
        }
    }
}
