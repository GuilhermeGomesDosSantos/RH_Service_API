package rh.service.RH.Service.Colaborador;

import rh.service.RH.Service.Endereco.DadosEndereco;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DadosCadastroColaborador(
        String nomeCompleto,
        String primeiroNome,
        String ultimoNome,
        LocalDate dataNascimento,
        String cpf,
        String rg,
        String emailPessoal,
        String telefoneCelular,
        DadosEndereco endereco,
        String matricula,
        String cargo,
        String departamento,
        TipoContratacao tipoContratacao,
        String salario
){
}
