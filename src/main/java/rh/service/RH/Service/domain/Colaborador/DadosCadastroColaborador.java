package rh.service.RH.Service.domain.Colaborador;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import rh.service.RH.Service.domain.Endereco.DadosEndereco;

public record DadosCadastroColaborador(
        @NotBlank(message = "nomeCompleto is required")
        String nomeCompleto,
        @NotBlank(message = "primeiroNome is required ")
        String primeiroNome,
        @NotBlank(message = "ultimoNome is required")
        String ultimoNome,
        @NotBlank(message = "cpf is required")
        @Pattern(regexp = "\\d{11}", message = "CPF must contain exactly 11 numeric digits")
        String cpf,
        @NotBlank(message = "RG is required")
        @Pattern(regexp = "\\d{7,8}", message = "RG must contain between 7 and 8 numeric digits")
        String rg,
        @NotBlank(message = "Personal email is required")
        @Email(message = "Invalid email format")
        String emailPessoal,
        @NotBlank(message = "telefoneCelular is required")
        String telefoneCelular,
        @NotNull(message = "Endereco is required")
        @Valid
        DadosEndereco endereco,
        @NotBlank(message = "matricula is required")
        String matricula,
        @NotBlank(message = "cargo is required")
        String cargo,
        @NotBlank(message = "departamento is required")
        String departamento,
        @NotNull(message = "tipoContratacao is required")
        TipoContratacao tipoContratacao,
        @NotBlank(message = "salario is required")
        String salario
){
}
