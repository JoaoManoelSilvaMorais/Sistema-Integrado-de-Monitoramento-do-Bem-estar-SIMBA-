package br.simba.bem_estar.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@ExtendWith(MockitoExtension.class)
class UserDetailsServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserDetailsServiceImpl service;

    @Test
    void carregaUsuarioExistenteComAutoridadeUser() {
        UserModel usuario = new UserModel();
        usuario.setUsername("joao");
        usuario.setPassword("hash-senha");

        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));

        UserDetails details = service.loadUserByUsername("joao");

        assertEquals("joao", details.getUsername());
        assertEquals("hash-senha", details.getPassword());
        assertTrue(details.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("USER")));
    }

    @Test
    void usuarioInexistenteLancaUsernameNotFoundException() {
        when(userRepository.findByUsername("inexistente")).thenReturn(Optional.empty());

        assertThrows(UsernameNotFoundException.class, () -> service.loadUserByUsername("inexistente"));
    }
}
