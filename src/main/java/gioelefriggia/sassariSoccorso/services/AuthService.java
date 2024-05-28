package gioelefriggia.sassariSoccorso.services;

import gioelefriggia.sassariSoccorso.entities.User;
import gioelefriggia.sassariSoccorso.exceptions.UnauthorizedException;
import gioelefriggia.sassariSoccorso.payloads.UserLoginDTO;
import gioelefriggia.sassariSoccorso.repositories.UsersDAO;
import gioelefriggia.sassariSoccorso.security.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UsersDAO usersDAO;

    @Autowired
    private JWTTools jwtTools;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String authenticateUserAndGenerateToken(UserLoginDTO payload) {
        System.out.println("Attempting to find user by email: " + payload.email());
        User user = usersDAO.findByEmail(payload.email())
                .orElseThrow(() -> {
                    System.out.println("User not found for email: " + payload.email());
                    return new UnauthorizedException("User not found!");
                });

        System.out.println("Found user: " + user.getEmail() + ", checking password.");
        if (!passwordEncoder.matches(payload.password(), user.getPassword())) {
            System.out.println("Password mismatch for user: " + user.getEmail());
            throw new UnauthorizedException("Invalid password!");
        }

        System.out.println("Password matched. Generating token.");
        return jwtTools.createToken(user);
    }

    public String generateToken(User user) {
        return jwtTools.createToken(user);
    }
}
