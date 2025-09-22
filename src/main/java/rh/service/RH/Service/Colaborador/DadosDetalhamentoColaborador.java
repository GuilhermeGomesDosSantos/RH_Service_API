package rh.service.RH.Service.Colaborador;

import rh.service.RH.Service.Endereco.Endereco;

public record DadosDetalhamentoColaborador(Long id, String nomeCompleto, String primeiroNome, String ultimoNome, String rg, String cpf, String emailPessoal, String emailOrganizacional, String telefoneCelular, String matricula, String cargp, String departamento, TipoContratacao tipoContratacao, String salario, String situacao) {
    public DadosDetalhamentoColaborador(Colaborador colaborador){
        this(colaborador.getId(), colaborador.getNomeCompleto(), colaborador.getPrimeiroNome(),
                colaborador.getUltimoNome(), colaborador.getRG(), colaborador.getCPF(), colaborador.getEmailPessoal(),
                colaborador.getEmailOrganizacional(),colaborador.getTelefoneCelular(),
                colaborador.getMatricula(), colaborador.getCargo(), colaborador.getDepartamento(), colaborador.getTipoContratacao(), colaborador.getSalario(), colaborador.getSituacao());
    }
}
