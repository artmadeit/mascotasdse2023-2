package pe.edu.cibertec.veterinaria;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import pe.edu.cibertec.veterinaria.entidades.Mascota;
import pe.edu.cibertec.veterinaria.repositories.MascotaRepository;

@RestController
@AllArgsConstructor
public class MascotaController {

    MascotaRepository mascotaRepository;

    @GetMapping("obtenerMascotas")
    public List<Mascota> listarMascotas() {
        return mascotaRepository.findAll();
    }
}
