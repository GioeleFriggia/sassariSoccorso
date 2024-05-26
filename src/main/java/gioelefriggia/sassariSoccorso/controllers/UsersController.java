package gioelefriggia.sassariSoccorso.controllers;

import gioelefriggia.sassariSoccorso.entities.User;
import gioelefriggia.sassariSoccorso.services.CloudinaryService;
import gioelefriggia.sassariSoccorso.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private CloudinaryService cloudinaryService;

    @GetMapping("/{userId}")
    public User findById(@PathVariable UUID userId) {
        return this.usersService.findById(userId);
    }

    @PutMapping("/{userId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public User findByIdAndUpdate(@PathVariable UUID userId, @RequestBody User body) {
        return this.usersService.findByIdAndUpdate(userId, body);
    }

    @DeleteMapping("/{userId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable UUID userId) {
        this.usersService.findByIdAndDelete(userId);
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
}
