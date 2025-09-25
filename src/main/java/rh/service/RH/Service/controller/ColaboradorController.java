package rh.service.RH.Service.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import rh.service.RH.Service.Colaborador.*;
import rh.service.RH.Service.controller.DadosAtualizaColaborador;

import java.util.List;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {
    @Autowired
    ColaboradorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroColaborador dados, UriComponentsBuilder uriComponentsBuilder){
        var colaborador = new Colaborador(dados);
        repository.save(colaborador);

        var uri = uriComponentsBuilder.path("/colaboradores/{id}").buildAndExpand(colaborador.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoColaborador(colaborador));
    }

    @GetMapping("/listAll")
    public List<DadosListagemColaborador> listar(@PageableDefault(sort = {"id"}) Pageable pageable){
        return repository.findAll(pageable).stream().map(DadosListagemColaborador::new).toList();
    }

    @GetMapping("/listActives")
    public ResponseEntity <Page<DadosListagemColaborador>> listarAtivos(@PageableDefault(size = 20, sort = {"nomeCompleto"}) Pageable pageable){
        var colaboradorLista = repository.findAllByStatusTrue(pageable).map(DadosListagemColaborador::new);

        return ResponseEntity.ok(colaboradorLista);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarColaboradorId(@PathVariable Long id){
        var colaborador = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoColaborador(colaborador));
    }

    @PutMapping("/update")
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizaColaborador dados){
        var colaborador = repository.getReferenceById(dados.id());
        colaborador.atualarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoColaborador(colaborador));
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id){
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/inactive/{id}")
    @Transactional
    public ResponseEntity desativar(@PathVariable Long id){
        var colaborador = repository.getReferenceById(id);
        colaborador.desativar(id);

        return ResponseEntity.ok(new DadosDetalhamentoColaboradorInativo(colaborador));
    }
}

