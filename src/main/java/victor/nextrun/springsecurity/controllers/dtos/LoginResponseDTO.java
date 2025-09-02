package victor.nextrun.springsecurity.controllers.dtos;

public record LoginResponseDTO(
        String acessToken,
        Long expiresIn
) {
}
