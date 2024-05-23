package gioelefriggia.sassariSoccorso.services;

import gioelefriggia.sassariSoccorso.entities.Role;
import gioelefriggia.sassariSoccorso.entities.User;
import gioelefriggia.sassariSoccorso.exceptions.BadRequestException;
import gioelefriggia.sassariSoccorso.exceptions.NotFoundException;
import gioelefriggia.sassariSoccorso.payloads.UserRegistrationDTO;
import gioelefriggia.sassariSoccorso.repositories.UsersDAO;
import gioelefriggia.sassariSoccorso.tools.MailgunSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsersService {
    @Autowired
    private UsersDAO usersDAO;
    @Autowired
    private PasswordEncoder bcrypt;
    @Autowired
    private MailgunSender mailgunSender;
    private static final Logger log = LoggerFactory.getLogger(UsersService.class);

    public User save(UserRegistrationDTO registrationDTO) throws BadRequestException {
        try {
            this.usersDAO.findByEmail(registrationDTO.getEmail()).ifPresent(user -> {
                throw new BadRequestException("L'email " + user.getEmail() + " è già in uso!");
            });

            User newUser = new User();
            newUser.setName(registrationDTO.getName());
            newUser.setSurname(registrationDTO.getSurname());
            newUser.setEmail(registrationDTO.getEmail());
            newUser.setPassword(bcrypt.encode(registrationDTO.getPassword()));
            newUser.setBirthdate(registrationDTO.getBirthdate());
            newUser.setResidence(registrationDTO.getResidence());
            newUser.setCity(registrationDTO.getCity());
            newUser.setMembershipNumber(registrationDTO.getMembershipNumber());

            // Imposta il ruolo in base al DTO
            if (registrationDTO.getRole() != null) {
                newUser.setRole(registrationDTO.getRole());
            } else {
                newUser.setRole(Role.USER);  // Imposta sempre il ruolo a USER se non specificato
            }

            mailgunSender.sendRegistrationEmail(newUser);
            return usersDAO.save(newUser);
        } catch (Exception e) {
            log.error("Error saving user: ", e);
            throw e;
        }
    }

    public User findById(UUID userId) {
        return this.usersDAO.findById(userId).orElseThrow(() -> new NotFoundException(userId));
    }

    public User findByIdAndUpdate(UUID userId, User modifiedUser) {
        User found = this.findById(userId);
        found.setName(modifiedUser.getName());
        found.setSurname(modifiedUser.getSurname());
        found.setEmail(modifiedUser.getEmail());
        found.setPassword(modifiedUser.getPassword());
        found.setAvatarURL("https://ui-avatars.com/api/?name=" + modifiedUser.getName() + "+" + modifiedUser.getSurname());
        return this.usersDAO.save(found);
    }

    public void findByIdAndDelete(UUID userId) {
        User found = this.findById(userId);
        this.usersDAO.delete(found);
    }

    public Page<User> getUsers(int page, int size, String sortBy) {
        if (size > 100) size = 100;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return this.usersDAO.findAll(pageable);
    }

    public User promoteToAdmin(UUID userId) {
        User user = this.findById(userId);
        user.setRole(Role.ADMIN);
        return usersDAO.save(user);
    }
}
