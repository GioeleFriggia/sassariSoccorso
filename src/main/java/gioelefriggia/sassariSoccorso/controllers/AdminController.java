package gioelefriggia.sassariSoccorso.controllers;

import gioelefriggia.sassariSoccorso.entities.ChecklistMezzo;
import gioelefriggia.sassariSoccorso.entities.User;
import gioelefriggia.sassariSoccorso.services.ChecklistMezzoService;
import gioelefriggia.sassariSoccorso.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private ChecklistMezzoService checklistMezzoService;

    @PostMapping("/promote/{userId}")
    public ResponseEntity<?> promoteUserToAdmin(@PathVariable UUID userId) {
        try {
            User updatedUser = usersService.promoteToAdmin(userId);
            return ResponseEntity.ok(updatedUser);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error promoting user to admin: " + e.getMessage());
        }
    }

    @GetMapping("/users")
    public ResponseEntity<Page<User>> getAllUsers(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "10") int size,
                                                  @RequestParam(defaultValue = "name") String sortBy) {
        Page<User> users = usersService.getUsers(page, size, sortBy);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/checklists")
    public ResponseEntity<Page<ChecklistMezzo>> getAllChecklists(@RequestParam(defaultValue = "0") int page,
                                                                 @RequestParam(defaultValue = "10") int size,
                                                                 @RequestParam(defaultValue = "date") String sortBy) {
        Page<ChecklistMezzo> checklists = checklistMezzoService.getChecklists(page, size, sortBy);
        return ResponseEntity.ok(checklists);
    }
}