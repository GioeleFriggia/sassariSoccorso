package gioelefriggia.sassariSoccorso.controllers;

import gioelefriggia.sassariSoccorso.exceptions.UnauthorizedException;
import gioelefriggia.sassariSoccorso.payloads.UserLoginDTO;
import gioelefriggia.sassariSoccorso.payloads.UserRegistrationDTO;
import gioelefriggia.sassariSoccorso.services.AuthService;
import gioelefriggia.sassariSoccorso.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UsersService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationDTO registrationDTO) {
        try {
            userService.save(registrationDTO);
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error registering user");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginDTO loginDTO) {
        try {
            String token = authService.authenticateUserAndGenerateToken(loginDTO);
            return ResponseEntity.ok(new UserLoginResponseDTO(token));
        } catch (UnauthorizedException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error logging in");
        }
    }

    public static class UserLoginResponseDTO {
        private String token;

        public UserLoginResponseDTO(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }
    }
}
