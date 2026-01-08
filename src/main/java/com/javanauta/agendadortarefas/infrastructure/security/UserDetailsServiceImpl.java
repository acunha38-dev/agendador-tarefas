package com.javanauta.agendadortarefas.infrastructure.security;



import com.javanauta.agendadortarefas.business.dto.UsuarioDTO;
import com.javanauta.agendadortarefas.infrastructure.client.UsuarioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
// vamos retirar a interface UserDetailsService e criar nosso método para poder receber o token

//public class UserDetailsServiceImpl implements UserDetailsService {
public class UserDetailsServiceImpl {

    @Autowired
//    // Construtor (injeção por construtor)
//    public UserDetailsServiceImpl(UsuarioClient client) {
//        this.client = client;
//    }
    private UsuarioClient client;

    // Implementação do método para carregar detalhes do usuário pelo e-mail

    public UserDetails carregaDadosUsuario (String email , String token) {
        UsuarioDTO usuarioDTO = client.buscaUsuarioPorEmail(email, token);
        // Cria e retorna um objeto UserDetails com base no usuário encontrado
        return User
                .withUsername(usuarioDTO.getEmail()) // Define o nome de usuário como o e-mail
                .password(usuarioDTO.getSenha()) // Define a senha do usuário
                .build(); // Constrói o objeto UserDetails
    }
}
