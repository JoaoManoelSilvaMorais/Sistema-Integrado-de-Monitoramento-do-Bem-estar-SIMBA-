package br.simba.bem_estar.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;

class JWTServiceTest {

    private static final String CHAVE = "simba-chave-secreta-para-testes-unitarios-2026";
    private JWTService jwtService;
    private UserDetails userDetails;

    @BeforeEach
    void preparar() {
        jwtService = new JWTService(CHAVE);
        userDetails = User.withUsername("joao").password("123").authorities("USER").build();
    }

    @Test
    void geraTokenValidoEExtraiUsernameEClaims() {
        String token = jwtService.generateToken(userDetails);

        assertNotNull(token);
        assertEquals("joao", jwtService.extractUsername(token));
        Date expiracao = jwtService.extractClaim(token, Claims::getExpiration);
        assertTrue(expiracao.after(new Date()));
        assertTrue(jwtService.isTokenValid(token, userDetails));
    }

    @Test
    void retornaFalsoQuandoUsernameDoTokenNaoCorrespondeAoUsuario() {
        String token = jwtService.generateToken(userDetails);
        UserDetails outroUsuario = User.withUsername("maria").password("123").authorities("USER").build();

        assertFalse(jwtService.isTokenValid(token, outroUsuario));
    }

    @Test
    void lancaExcecaoParaTokenExpiradoOuAdulterado() {
        String expirado = Jwts.builder()
                .setSubject("joao")
                .setIssuedAt(new Date(System.currentTimeMillis() - 60_000))
                .setExpiration(new Date(System.currentTimeMillis() - 1_000))
                .signWith(Keys.hmacShaKeyFor(CHAVE.getBytes(StandardCharsets.UTF_8)))
                .compact();

        assertThrows(ExpiredJwtException.class, () -> jwtService.isTokenValid(expirado, userDetails));

        String valido = jwtService.generateToken(userDetails);
        String adulterado = valido.substring(0, valido.length() - 4) + "abcd";
        assertThrows(SignatureException.class, () -> jwtService.extractUsername(adulterado));
    }
}
