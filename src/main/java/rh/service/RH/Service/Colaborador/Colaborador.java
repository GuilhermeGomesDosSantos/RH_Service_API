package rh.service.RH.Service.Colaborador;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import rh.service.RH.Service.Endereco.Endereco;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name="Colaborador")
@Table(name = "colaboradores")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Colaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean status;
    private String nomeCompleto;
    private String primeiroNome;
    private String ultimoNome;
    private String CPF;
    private String RG;
    private String emailPessoal;
    private String emailOrganizacional;
    private String telefoneCelular;
    @Embedded
    private Endereco endereco;
    private String matricula;
    private String cargo;
    private String departamento;
    @Enumerated(EnumType.STRING)
    private TipoContratacao tipoContratacao;
    private String salario;
    private String situacao;

//    public Colaborador(){};

    public Colaborador(DadosCadastroColaborador dados) {
        this.status = true;
        this.nomeCompleto = dados.nomeCompleto();
        this.primeiroNome = dados.primeiroNome();
        this.ultimoNome = dados.ultimoNome();
        this.CPF = dados.cpf();
        this.RG = dados.rg();
        this.emailPessoal = dados.emailPessoal();
        this.emailOrganizacional =  dados.primeiroNome().toLowerCase() + "." + dados.ultimoNome().toLowerCase() + "@gmail.com.br";
        this.telefoneCelular = dados.telefoneCelular();
        this.endereco = new Endereco(dados.endereco());
        this.matricula = dados.matricula();
        this.cargo = dados.cargo();
        this.departamento = dados.departamento();
        this.tipoContratacao = dados.tipoContratacao();
        this.salario = dados.salario();
        this.situacao = "Em situação Normal";
    }
}
