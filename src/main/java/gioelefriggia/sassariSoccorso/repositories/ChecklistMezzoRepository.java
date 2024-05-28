package gioelefriggia.sassariSoccorso.repositories;

import gioelefriggia.sassariSoccorso.entities.ChecklistMezzo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChecklistMezzoRepository extends JpaRepository<ChecklistMezzo, Long> {
}
