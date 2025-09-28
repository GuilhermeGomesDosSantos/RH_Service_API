package rh.service.RH.Service.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import rh.service.RH.Service.domain.Usuario.DadosCadastroUsuario;
import rh.service.RH.Service.domain.Usuario.Usuario;
import rh.service.RH.Service.domain.Usuario.UsuarioRepository;

@RestController
@RequestMapping("/cadastrar")
public class CadastroController {

    @Autowired
    UsuarioRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @PostMapping
    @Transactional
    public ResponseEntity cadastrarUsuario(@RequestBody @Valid DadosCadastroUsuario dados, UriComponentsBuilder uriComponentsBuilder){
        var usuario = new Usuario(dados);

        usuario.setSenha(passwordEncoder.encode(dados.senha()));
        repository.save(usuario);

        return ResponseEntity.ok().build();
    }
}
