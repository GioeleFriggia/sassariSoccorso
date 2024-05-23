package gioelefriggia.sassariSoccorso.services;

import gioelefriggia.sassariSoccorso.entities.ChecklistMezzo;
import gioelefriggia.sassariSoccorso.repositories.ChecklistMezzoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ChecklistMezzoService {

    @Autowired
    private ChecklistMezzoRepository checklistMezzoRepository;

    public void save(ChecklistMezzo checklistMezzo) {
        checklistMezzoRepository.save(checklistMezzo);
    }

    public Page<ChecklistMezzo> getChecklists(int page, int size, String sortBy) {
        if (size > 100) size = 100;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return checklistMezzoRepository.findAll(pageable);
    }
}