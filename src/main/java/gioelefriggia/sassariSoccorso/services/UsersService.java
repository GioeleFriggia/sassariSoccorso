package gioelefriggia.sassariSoccorso.services;

import gioelefriggia.sassariSoccorso.entities.Role;
import gioelefriggia.sassariSoccorso.entities.User;
import gioelefriggia.sassariSoccorso.exceptions.BadRequestException;
import gioelefriggia.sassariSoccorso.exceptions.NotFoundException;
import gioelefriggia.sassariSoccorso.payloads.UserRegistrationDTO;
import gioelefriggia.sassariSoccorso.repositories.UsersDAO;
import gioelefriggia.sassariSoccorso.tools.MailgunSender;
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

    public User save(UserRegistrationDTO registrationDTO) throws BadRequestException {
        usersDAO.findByEmail(registrationDTO.getEmail()).ifPresent(user -> {
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

        newUser.setRole(registrationDTO.getRole() != null ? registrationDTO.getRole() : Role.USER);

        mailgunSender.sendRegistrationEmail(newUser);
        return usersDAO.save(newUser);
    }

    public User findById(UUID userId) {
        return usersDAO.findById(userId).orElseThrow(() -> new NotFoundException(userId));
    }

    public User findByIdAndUpdate(UUID userId, User modifiedUser) {
        User found = this.findById(userId);
        found.setName(modifiedUser.getName());
        found.setSurname(modifiedUser.getSurname());
        found.setEmail(modifiedUser.getEmail());
        found.setPassword(bcrypt.encode(modifiedUser.getPassword()));
        found.setAvatarURL(modifiedUser.getAvatarURL());
        return usersDAO.save(found);
    }

    public void findByIdAndDelete(UUID userId) {
        User found = this.findById(userId);
        this.usersDAO.delete(found);
    }

    public User updateUserAvatar(UUID userId, String imageUrl) {
        User user = findById(userId);
        user.setAvatarURL(imageUrl);
        return usersDAO.save(user);
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
