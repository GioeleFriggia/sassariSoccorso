package gioelefriggia.sassariSoccorso.controllers;

import gioelefriggia.sassariSoccorso.entities.ChecklistVanoSanitario;
import gioelefriggia.sassariSoccorso.services.ChecklistVanoSanitarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ChecklistVanoSanitarioController {

    @Autowired
    private ChecklistVanoSanitarioService checklistVanoSanitarioService;

    @PostMapping("/checklistVanoSanitario")
    public ResponseEntity<?> createChecklistVanoSanitario(@RequestBody ChecklistVanoSanitario checklistVanoSanitario) {
        try {
            checklistVanoSanitarioService.save(checklistVanoSanitario);
            return ResponseEntity.ok().body("{\"message\": \"ChecklistVanoSanitario created successfully\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\": \"An error occurred while creating the checklistVanoSanitario\"}");
        }
    }

    @GetMapping("/checklistVanoSanitario")
    public ResponseEntity<Page<ChecklistVanoSanitario>> getAllChecklists(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "date") String sortBy) {
        Page<ChecklistVanoSanitario> checklists = checklistVanoSanitarioService.getChecklists(page, size, sortBy);
        return ResponseEntity.ok(checklists);
    }
}
