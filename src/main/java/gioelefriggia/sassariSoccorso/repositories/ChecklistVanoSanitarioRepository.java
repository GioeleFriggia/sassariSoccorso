package gioelefriggia.sassariSoccorso.repositories;

import gioelefriggia.sassariSoccorso.entities.ChecklistVanoSanitario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChecklistVanoSanitarioRepository extends JpaRepository<ChecklistVanoSanitario, Long> {
}
