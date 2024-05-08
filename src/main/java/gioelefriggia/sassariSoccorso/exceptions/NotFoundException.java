package gioelefriggia.sassariSoccorso.exceptions;


import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(UUID id) {
        super("The record with ID: " + id + " was not found!");
    }

    public NotFoundException(String message) {
        super(message);
    }
}
