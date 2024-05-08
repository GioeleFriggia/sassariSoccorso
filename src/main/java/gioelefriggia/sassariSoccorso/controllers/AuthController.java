package gioelefriggia.sassariSoccorso.controllers;

import gioelefriggia.sassariSoccorso.exceptions.BadRequestException;
import gioelefriggia.sassariSoccorso.payloads.NewUserDTO;
import gioelefriggia.sassariSoccorso.payloads.NewUserRespDTO;
import gioelefriggia.sassariSoccorso.payloads.UserLoginDTO;
import gioelefriggia.sassariSoccorso.payloads.UserLoginResponseDTO;
import gioelefriggia.sassariSoccorso.services.AuthService;
import gioelefriggia.sassariSoccorso.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    private UsersService usersService;

    @PostMapping("/login")
    public UserLoginResponseDTO login(@RequestBody UserLoginDTO payload) {
        return new UserLoginResponseDTO(this.authService.authenticateUserAndGenerateToken(payload));
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public NewUserRespDTO saveUser(@RequestBody @Validated NewUserDTO body, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        }
        return new NewUserRespDTO(this.usersService.save(body).getId());
    }
}