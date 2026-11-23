package br.simba.bem_estar.security;

import java.security.Key;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {

    private static final long EXPIRATION_TIME = 86400000; // 1 dia
    private static final int TAMANHO_MINIMO_CHAVE = 32;
    /** Chave padrão antiga que ficou pública no GitHub: nunca pode ser aceita. */
    private static final String CHAVE_ANTIGA_PUBLICA = "simba-development-secret-key-change-in-production-2026";

    private final Key secretKey;

    public JWTService(@Value("${jwt.secret:}") String secret) {
        validarChave(secret);
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Sem uma chave própria qualquer pessoa poderia gerar um login falso; por isso o app nem inicia.
     */
    static void validarChave(String secret) {
        if (secret == null || secret.isBlank()) {
            throw new IllegalStateException(
                    "JWT_SECRET não definido. Coloque JWT_SECRET=<chave aleatória com 32+ caracteres> em "
                    + "config/simba-local.properties (modelo: config/simba-local.example.properties) "
                    + "ou numa variável de ambiente.");
        }
        if (secret.length() < TAMANHO_MINIMO_CHAVE) {
            throw new IllegalStateException(
                    "JWT_SECRET muito curto: use pelo menos " + TAMANHO_MINIMO_CHAVE + " caracteres.");
        }
        if (CHAVE_ANTIGA_PUBLICA.equals(secret)) {
            throw new IllegalStateException(
                    "JWT_SECRET é a chave antiga que está pública no GitHub. Gere uma chave nova.");
        }
    }

    public String extractUsername(String token) {
        final Claims claims = extractAllClaims(token);
        return claims != null ? claims.getSubject() : null;
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(secretKey)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractAllClaims(token).getExpiration();
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody();
    }
}