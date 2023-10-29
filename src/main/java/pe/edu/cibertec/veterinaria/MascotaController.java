package pe.edu.cibertec.veterinaria;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class MascotaController {

    MascotaRepository mascotaRepository;

    @GetMapping("obtenerMascotas")
    public List<Mascota> listarMascotas() {
        return mascotaRepository.findAll();
    }

}