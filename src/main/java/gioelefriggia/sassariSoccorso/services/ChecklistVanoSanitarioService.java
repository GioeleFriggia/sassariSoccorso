package gioelefriggia.sassariSoccorso.services;

import gioelefriggia.sassariSoccorso.entities.ChecklistVanoSanitario;
import gioelefriggia.sassariSoccorso.repositories.ChecklistVanoSanitarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ChecklistVanoSanitarioService {

    @Autowired
    private ChecklistVanoSanitarioRepository checklistVanoSanitarioRepository;

    public void save(ChecklistVanoSanitario checklistVanoSanitario) {
        checklistVanoSanitarioRepository.save(checklistVanoSanitario);
    }

    public Page<ChecklistVanoSanitario> getChecklists(int page, int size, String sortBy) {
        if (size > 100) size = 100;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return checklistVanoSanitarioRepository.findAll(pageable);
    }
}
