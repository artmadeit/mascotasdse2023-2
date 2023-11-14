package pe.edu.cibertec.veterinaria;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("veterinarios")
@AllArgsConstructor
public class VeterinarioController {

    VeterinarioRepository veterinarioRepository;

    // listar toda la informacion
    // @GetMapping
    // public List<Veterinario> list() {
    // return veterinarioRepository.findAll();
    // }

    @GetMapping
    public List<VeterinarioDto> list() {
        // mapstruct
        // dto = data transfer object

        // select nombre, especialidad.nombre from Veterinario join Especialidad;

        // select * from Veterinario;
        // return veterinarioRepository.findAll().stream().map(veterinario -> {
        // VeterinarioDto dto = new VeterinarioDto();
        // dto.nombre = veterinario.getNombre();
        // dto.especialidad = veterinario.getEspecialidad().getNombre();

        // return dto;
        // }).toList();

        return veterinarioRepository.findByResumido();
    }
}
