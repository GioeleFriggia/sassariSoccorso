package gioelefriggia.sassariSoccorso.controllers;

import gioelefriggia.sassariSoccorso.entities.ChecklistMezzo;
import gioelefriggia.sassariSoccorso.services.ChecklistMezzoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ChecklistMezzoController {

    @Autowired
    private ChecklistMezzoService checklistMezzoService;

    @PostMapping("/checklistMezzo")
    public ResponseEntity<?> createChecklistMezzo(@RequestBody ChecklistMezzo checklistMezzo) {
        try {
            checklistMezzoService.save(checklistMezzo);
            return ResponseEntity.ok().body("{\"message\": \"ChecklistMezzo created successfully\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\": \"An error occurred while creating the checklistMezzo\"}");
        }
    }
}
