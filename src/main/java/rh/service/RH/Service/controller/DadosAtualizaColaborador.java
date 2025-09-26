package rh.service.RH.Service.controller;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import rh.service.RH.Service.domain.Colaborador.TipoContratacao;
import rh.service.RH.Service.domain.Endereco.DadosEndereco;

public record DadosAtualizaColaborador(
        @NotNull
        Long id,
        Boolean status,
        String nomeCompleto,
        String primeiroNome,
        String ultimoNome,
        String cpf,
        String rg,
        @Email
        String emailPessoal,
        String telefoneCelular,
        String matricula,
        String cargo,
        String departamento,
        TipoContratacao tipoContratacao,
        DadosEndereco endereco
){
}
