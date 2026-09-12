package br.simba.bem_estar.user;

import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/")
    public UserModel createUser(@RequestBody UserModel userModel) {
        return userRepository.save(userModel);
    }

    @GetMapping("/")
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/me")
    public UserDto getCurrentUser(Authentication authentication) {
        UserModel user = userRepository.findByUsername(authentication.getName())
            .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        return new UserDto(user.getId(), user.getName(), user.getUsername(), user.getEmail(), null);
    }

    @GetMapping("/{id}")
    public UserModel getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
