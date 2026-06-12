package pe.edu.upeu.auth_server.services;

import pe.edu.upeu.auth_server.dtos.TokenDto;
import pe.edu.upeu.auth_server.dtos.UserDto;

public interface AuthService {
    TokenDto login(UserDto user);
    TokenDto validateToken(TokenDto token);

}
