package rh.service.RH.Service.Colaborador;

public record DadosDetalhamentoColaboradorInativo(Long id, String nomeCompleto, String emailOrganizacional, String matricula, String cargo, String departamento, TipoContratacao tipoContratacao, String situacao) {
    public DadosDetalhamentoColaboradorInativo(Colaborador colaborador){
        this(colaborador.getId(), colaborador.getNomeCompleto(), colaborador.getEmailOrganizacional(), colaborador.getMatricula(), colaborador.getCargo(), colaborador.getDepartamento(), colaborador.getTipoContratacao(), colaborador.getSituacao());
    }
}
