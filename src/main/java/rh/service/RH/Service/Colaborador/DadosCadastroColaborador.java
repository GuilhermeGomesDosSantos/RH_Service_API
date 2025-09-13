package rh.service.RH.Service.Colaborador;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import rh.service.RH.Service.Endereco.DadosEndereco;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DadosCadastroColaborador(
        @NotBlank
        String nomeCompleto,
        @NotBlank
        String primeiroNome,
        @NotBlank
        String ultimoNome,
        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String cpf,
        @NotBlank
        @Pattern(regexp = "\\d{7,8}")
        String rg,
        @NotBlank
        @Email
        String emailPessoal,
        @NotBlank
        String telefoneCelular,
        @NotNull
        @Valid
        DadosEndereco endereco,
        @NotBlank
        String matricula,
        @NotBlank
        String cargo,
        @NotBlank
        String departamento,
        @NotNull
        TipoContratacao tipoContratacao,
        @NotBlank
        String salario
){
}
