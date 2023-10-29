package pe.edu.cibertec.veterinaria;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("mascotas")
public class MascotaController {

    MascotaRepository mascotaRepository;

    @GetMapping
    public List<Mascota> findAll() {
        return mascotaRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Mascota> findById(@PathVariable Long id) {
        // Optional<Mascota> mascotaOptional = mascotaRepository.findById(id);
        // if (mascotaOptional.isPresent()) {
        // Mascota mascota = mascotaOptional.get();
        // return ResponseEntity.ok(mascota);
        // }

        // return ResponseEntity.notFound().build();

        return ResponseEntity.of(mascotaRepository.findById(id));
    }

    // @PostMapping("mascotas")
    // public ResponseEntity<Long> register(@RequestBody MascotaRequest
    // mascotaRequest) {
    // Mascota mascota = new Mascota();
    // mascota.nombre = mascotaRequest.nombre;
    // mascota.dueño = mascotaRequest.dueño;
    // Mascota mascotaGuardada = mascotaRepository.save(mascota);
    // return ResponseEntity.status(HttpStatus.CREATED).body(mascotaGuardada.id);
    // }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Long register(@RequestBody @Valid MascotaRequest mascotaRequest) {
        Mascota mascota = new Mascota();
        mascota.nombre = mascotaRequest.nombre;
        mascota.dueño = mascotaRequest.dueño;
        Mascota mascotaGuardada = mascotaRepository.save(mascota);
        return mascotaGuardada.id;
    }
}
