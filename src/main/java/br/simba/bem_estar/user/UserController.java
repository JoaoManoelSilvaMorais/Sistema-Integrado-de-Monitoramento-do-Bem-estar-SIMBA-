package br.simba.bem_estar.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired 
    private UserRepository userRepository;

    @PostMapping("/users")
    public UserModel createUser(@RequestBody UserModel userModel){
    return userRepository.save(userModel);
    }



    @GetMapping ("/users")

    public List<UserModel> getAllUsers(){
        return  userRepository.findAll();


    }

    @GetMapping("/users/{id}")
    public UserModel getUserById(@PathVariable Long id){

        return userRepository.findById(id)
            .orElseThrow(()->new RuntimeException("Usuario não encontrado"));
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id){
    
        userRepository.deleteById(id);
    }



}
