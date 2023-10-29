package pe.edu.cibertec.veterinaria;

import jakarta.validation.constraints.NotBlank;
import lombok.Setter;

@Setter
public class MascotaRequest {
    @NotBlank
    String nombre;
    @NotBlank
    String dueño;

    // @PositiveOrZero
    // @Max(25)
    // int edad;

    // @Email
    // String email;
}
