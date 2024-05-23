package gioelefriggia.sassariSoccorso.exceptions;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }

    // Aggiungi questo costruttore se vuoi passare anche l'eccezione
    public UnauthorizedException(String message, Throwable cause) {
        super(message, cause);
    }
}