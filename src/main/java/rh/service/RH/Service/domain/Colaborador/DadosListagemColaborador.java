package rh.service.RH.Service.domain.Colaborador;
public record DadosListagemColaborador(
        Long Id,
        Boolean status,
        String situacao,
        String nomeCompleto,
        String primeiroNome,
        String ultimoNome,
        String cpf,
        String rg,
        String emailPessoal,
        String emailOrganizacional,
        String telefoneCelular,
        String matricula,
        String cargo,
        String departamento,
        TipoContratacao tipoContratacao,
        String salario) {
    public DadosListagemColaborador(Colaborador colaborador){
        this(colaborador.getId(), colaborador.getStatus(), colaborador.getSituacao(), colaborador.getPrimeiroNome(), colaborador.getUltimoNome(), colaborador.getNomeCompleto(),
                colaborador.getCPF(), colaborador.getRG(), colaborador.getEmailPessoal(), colaborador.getEmailOrganizacional(),
                colaborador.getTelefoneCelular(), colaborador.getMatricula(), colaborador.getCargo(),
                colaborador.getDepartamento(), colaborador.getTipoContratacao(),colaborador.getSalario());
    }
}
