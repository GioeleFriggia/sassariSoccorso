package gioelefriggia.sassariSoccorso.controllers;

import gioelefriggia.sassariSoccorso.entities.User;
import gioelefriggia.sassariSoccorso.exceptions.UnauthorizedException;
import gioelefriggia.sassariSoccorso.payloads.UserLoginDTO;
import gioelefriggia.sassariSoccorso.payloads.UserRegistrationDTO;
import gioelefriggia.sassariSoccorso.services.AuthService;
import gioelefriggia.sassariSoccorso.services.CloudinaryService;
import gioelefriggia.sassariSoccorso.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private CloudinaryService cloudinaryService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationDTO registrationDTO) {
        try {
            User user = usersService.save(registrationDTO);
            String token = authService.generateToken(user);

            Map<String, Object> response = new HashMap<>();
            response.put("user", user);
            response.put("token", token);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error registering user");
        }
    }

    @GetMapping("/me")
    public ResponseEntity<?> getCurrentUser(@AuthenticationPrincipal User currentUser) {
        if (currentUser == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not authenticated");
        }
        return ResponseEntity.ok(currentUser);
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

    @PostMapping("/upload-avatar/{userId}")
    public ResponseEntity<?> uploadAvatar(@PathVariable UUID userId, @RequestParam("file") MultipartFile file) {
        try {
            String imageUrl = cloudinaryService.uploadImage(file);
            User updatedUser = usersService.updateUserAvatar(userId, imageUrl);
            return ResponseEntity.ok(updatedUser);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading image: " + e.getMessage());
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
