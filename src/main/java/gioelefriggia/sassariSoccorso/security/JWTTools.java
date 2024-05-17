package gioelefriggia.sassariSoccorso.security;

import gioelefriggia.sassariSoccorso.entities.User;
import gioelefriggia.sassariSoccorso.exceptions.UnauthorizedException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JWTTools {

    @Value("${jwt.secret}")
    private String secret;

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String createToken(User user) {
        String token = Jwts.builder()
                .setIssuedAt(new Date(System.currentTimeMillis())) // Data di emissione del token (IAT - Issued AT) in millisecondi
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7)) // Data di scadenza del token (Expiration Date) in millisecondi
                .setSubject(String.valueOf(user.getId())) // Subject, ovvero a chi appartiene il token (Attenzione a non mettere info sensibili)
                .signWith(getSigningKey()) // Firmo il token con algoritmo HMAC passandogli il SEGRETO
                .compact();
        System.out.println("Generated Token: " + token); // Log del token generato
        return token;
    }

    public void verifyToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token);
            // Il metodo .parseClaimsJws(token) mi lancerà delle eccezioni in caso di token scaduto o token manipolato
        } catch (Exception ex) {
            throw new UnauthorizedException("Problemi col token! Per favore effettua di nuovo il login!");
            // Non importa quale eccezione verrà lanciata da .parse(), a me alla fine interessa che tutte come risultato abbiano 401
        }
    }

    public String extractIdFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject(); // Il subject è l'id dell'utente
    }
}
