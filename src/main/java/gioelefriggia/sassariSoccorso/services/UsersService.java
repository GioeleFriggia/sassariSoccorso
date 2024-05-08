package gioelefriggia.sassariSoccorso.services;


import gioelefriggia.sassariSoccorso.entities.User;
import gioelefriggia.sassariSoccorso.exceptions.BadRequestException;
import gioelefriggia.sassariSoccorso.exceptions.NotFoundException;
import gioelefriggia.sassariSoccorso.payloads.NewUserDTO;
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

    public Page<User> getUsers(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return this.usersDAO.findAll(pageable);
    }

    public User save(NewUserDTO body) {
        this.usersDAO.findByEmail(body.email()).ifPresent(user -> {
            throw new BadRequestException("The email " + user.getEmail() + " is already in use!");
        });
        User newUser = new User(body.name(), body.surname(), body.email(), bcrypt.encode(body.password()),
                "https://ui-avatars.com/api/?name=" + body.name() + "+" + body.surname());
        mailgunSender.sendRegistrationEmail(newUser);
        return usersDAO.save(newUser);
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

    public User findByEmail(String email) {
        return usersDAO.findByEmail(email).orElseThrow(() -> new NotFoundException("User with email " + email + " not found!"));
    }
}

