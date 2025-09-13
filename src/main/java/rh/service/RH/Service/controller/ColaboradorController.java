package rh.service.RH.Service.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rh.service.RH.Service.Colaborador.Colaborador;
import rh.service.RH.Service.Colaborador.ColaboradorRepository;
import rh.service.RH.Service.Colaborador.DadosCadastroColaborador;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {
    @Autowired
    ColaboradorRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroColaborador dados){
        repository.save(new Colaborador(dados));
    }

}
