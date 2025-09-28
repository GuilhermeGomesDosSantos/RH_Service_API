package rh.service.RH.Service.domain.Usuario;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public record DadosCadastroUsuario(String login, String senha) {
}
