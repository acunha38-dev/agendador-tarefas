package com.javanauta.agendadortarefas.infrastructure.client;

import com.javanauta.agendadortarefas.business.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

// chamar a api de usuario, vou dar o nome de usuario mesmo
// url eu jogo em uma variável que fica no application.properties
@FeignClient(name = "usuario" , url = "${usuario.url}" )

public interface UsuarioClient {

    @GetMapping("/usuario")
    UsuarioDTO buscaUsuarioPorEmail(@RequestParam("email") String email,
                                    @RequestHeader("Authorization") String token );


}
