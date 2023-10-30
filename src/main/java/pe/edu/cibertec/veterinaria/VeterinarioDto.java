package pe.edu.cibertec.veterinaria;

import lombok.Getter;

@Getter
public class VeterinarioDto {
    String nombre;
    String especialidad;

    public VeterinarioDto(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }
}
