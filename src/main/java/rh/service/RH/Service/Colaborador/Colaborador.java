package rh.service.RH.Service.Colaborador;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import rh.service.RH.Service.Endereco.Endereco;
import rh.service.RH.Service.controller.DadosAtualizaColaborador;

@Entity(name="Colaborador")
@Table(name = "colaboradores")
@Getter
@AllArgsConstructor
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

    public Colaborador(){};

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

    public Long getId() {
        return id;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public String getCPF() {
        return CPF;
    }

    public String getRG() {
        return RG;
    }

    public String getEmailPessoal() {
        return emailPessoal;
    }

    public String getEmailOrganizacional() {
        return emailOrganizacional;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getCargo() {
        return cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public TipoContratacao getTipoContratacao() {
        return tipoContratacao;
    }

    public String getSalario() {
        return salario;
    }

    public String getSituacao() {
        return situacao;
    }

    public void atualarInformacoes(DadosAtualizaColaborador dados) {
        if(dados.status() != null && dados.status() == false) {
                this.status = false;
        } else if (dados.status() != null && dados.status() == true) {
            this.status = true;
        }
        if(dados.nomeCompleto() != null){
            this.nomeCompleto = dados.nomeCompleto();
        }
        if(dados.primeiroNome() != null){
            this.primeiroNome = dados.primeiroNome();
        }
        if(dados.ultimoNome() != null){
            this.ultimoNome = dados.ultimoNome();
        }
        if(dados.cpf() != null){
            this.CPF = dados.cpf();
        }
        if (dados.rg() != null){
            this.RG = dados.rg();
        }
        if (dados.emailPessoal() != null){
            this.emailPessoal = dados.emailPessoal();
        }
        if(dados.telefoneCelular() != null){
            this.telefoneCelular = telefoneCelular;
        }
        if(dados.matricula() != null){
            this.matricula = dados.matricula();
        }
        if(dados.cargo() != null){
            this.cargo = dados.cargo();
        }
        if(dados.departamento() != null){
            this.departamento = dados.departamento();
        }
        if(dados.tipoContratacao() != null){
            this.tipoContratacao = dados.tipoContratacao();
        }
        if(dados.endereco() != null){
            this.endereco.atualizar(dados.endereco());
        }
    }
}
