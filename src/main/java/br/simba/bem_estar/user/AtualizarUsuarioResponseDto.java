package br.simba.bem_estar.user;

public class AtualizarUsuarioResponseDto {

    private UserDto usuario;
    private String token;

    public AtualizarUsuarioResponseDto(
            UserDto usuario,
            String token) {

        this.usuario = usuario;
        this.token = token;
    }

    public UserDto getUsuario() {
        return usuario;
    }

    public String getToken() {
        return token;
    }
}