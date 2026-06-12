package pe.edu.upeu.auth_server.services;


import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pe.edu.upeu.auth_server.dtos.TokenDto;
import pe.edu.upeu.auth_server.dtos.UserDto;
import pe.edu.upeu.auth_server.entity.UserEntity;
import pe.edu.upeu.auth_server.helpers.JwtHelper;
import pe.edu.upeu.auth_server.repository.UserRepository;


@Transactional
@Service
public class AuthServiceImpl implements AuthService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtHelper jwtHelper;

    private final Logger log = LoggerFactory.getLogger(AuthServiceImpl.class);

    private static final String USER_EXCEPTION_MSG = "Error to auth user";

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtHelper jwtHelper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtHelper = jwtHelper;
    }

    @Override
    public TokenDto login(UserDto user) {
       final var userFromDB = this.userRepository.findByUsername(user.getUsername())
               .orElseThrow(()-> new ResponseStatusException(HttpStatus.UNAUTHORIZED, USER_EXCEPTION_MSG));
         this.validPassword(user,userFromDB);
         return TokenDto.builder().accessToken(this.jwtHelper.createToken(userFromDB.getUsername())).build();

    }

    @Override
    public TokenDto validateToken(TokenDto token) {
        log.info("AuthServiceImpl:"+token);

        if(this.jwtHelper.validateToken(token.getAccessToken())){
            log.info("ingresa al if de AuthServiceImpl:"+token);
            return TokenDto.builder().accessToken(token.getAccessToken()).build();
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, USER_EXCEPTION_MSG);
    }

    private void validPassword(UserDto userDto, UserEntity userEntity){
        if(!this.passwordEncoder.matches(userDto.getPassword(), userEntity.getPassword())){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,USER_EXCEPTION_MSG);
        }
    }
}
