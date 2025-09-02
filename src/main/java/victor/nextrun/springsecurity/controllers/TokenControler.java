package victor.nextrun.springsecurity.controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import victor.nextrun.springsecurity.controllers.dtos.LoginRequestDTO;
import victor.nextrun.springsecurity.controllers.dtos.LoginResponseDTO;
import victor.nextrun.springsecurity.repository.UserRepository;

import java.time.Instant;

@RestController
@AllArgsConstructor
public class TokenControler {
    private final JwtEncoder jwtEncoder;
    private final UserRepository repository;
    public final BCryptPasswordEncoder PasswordEncoder;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO){
        var user = repository.findByUsername(loginRequestDTO.username());

        if(user.isEmpty() || user.get().isLoginCorrect(loginRequestDTO, PasswordEncoder)) {
            throw new BadCredentialsException("User or password invalid");
        }

    var now = Instant.now();
        var expiresIn = 300L;
        var claims = JwtClaimsSet.builder()
                .issuer("mybackend")
                .subject(user.get().getUuid().toString())
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiresIn))
                .build();

        var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return ResponseEntity.ok(new LoginResponseDTO(jwtValue, expiresIn));

    }



}
