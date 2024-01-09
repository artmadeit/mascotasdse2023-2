package pe.edu.cibertec.veterinaria;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("mascotas")
@AllArgsConstructor
public class MascotaController {

    MascotaRepository mascotaRepository;

    @GetMapping
    public Page<Mascota> findAll(Pageable pageable) {
        return mascotaRepository.findAll(pageable);
    }

    @GetMapping("{id}")
    public ResponseEntity<Mascota> findById(@PathVariable Long id) {
        return ResponseEntity.of(mascotaRepository.findById(id));
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        mascotaRepository.deleteById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Mascota register(@RequestBody RegisterMascotaDto registerMascotaDto) {
        Mascota mascota = new Mascota();
        mascota.nombre = registerMascotaDto.nombre;
        mascota.dueño = registerMascotaDto.dueño;
        var mascotaRegistrada = mascotaRepository.save(mascota);
        return mascotaRegistrada;
    }

    // PUT (editar)

}
