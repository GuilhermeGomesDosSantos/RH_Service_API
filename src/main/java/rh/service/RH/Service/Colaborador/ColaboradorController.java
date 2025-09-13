package rh.service.RH.Service.Colaborador;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import rh.service.RH.Service.Colaborador.Colaborador;
import rh.service.RH.Service.Colaborador.ColaboradorRepository;
import rh.service.RH.Service.Colaborador.DadosCadastroColaborador;
import rh.service.RH.Service.Colaborador.DadosListagemColaborador;
import rh.service.RH.Service.controller.DadosAtualizaColaborador;

import java.util.List;

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

    @GetMapping("/listAll")
    public List<DadosListagemColaborador> listar(@PageableDefault(sort = {"id"}) Pageable pageable){
        return repository.findAll(pageable).stream().map(DadosListagemColaborador::new).toList();
    }

    @GetMapping("/listActives")
    public Page<DadosListagemColaborador> listarAtivos(@PageableDefault(size = 20, sort = {"nomeCompleto"}) Pageable pageable){
        return repository.findAllByStatusTrue(pageable).map(DadosListagemColaborador::new);
    }

    @PutMapping("/update")
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizaColaborador dados){
        var colaborador = repository.getReferenceById(dados.id());
        colaborador.atualarInformacoes(dados);
    }
}

