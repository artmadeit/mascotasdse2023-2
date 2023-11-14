package pe.edu.cibertec.veterinaria;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("mascotas")
// Forma a cada controlller pooner esto
// @CrossOrigin(origins = { "http://localhost:4200/", "https://mipagina.com" })
public class MascotaController {

    MascotaRepository mascotaRepository;

    @GetMapping
    public List<Mascota> findAll(String nombre) {
        if (nombre != null) {
            return mascotaRepository.searchByNombreContains(nombre);
        }

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

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        // Optional<Mascota> mascotaOptional = mascotaRepository.findById(id);
        // if(mascotaOptional.isPresent()) {
        // mascotaRepository.delete(mascotaOptional.get());
        // }

        mascotaRepository.deleteById(id); // DELETE FROM mascota where id = ?; -- hard delete
    }

    @PutMapping("{id}")
    public ResponseEntity<Mascota> update(@PathVariable Long id, @RequestBody @Valid MascotaRequest mascotaRequest) {
        // Optional<Mascota> mascotaOptional = mascotaRepository.findById(id);
        // if (mascotaOptional.isPresent()) {
        // Mascota mascota = mascotaOptional.get();
        // mascota.nombre = mascotaRequest.nombre;
        // mascota.dueño = mascotaRequest.dueño;
        // mascotaRepository.save(mascota);

        // return ResponseEntity.ok(mascota);
        // }

        // return ResponseEntity.notFound().build();

        return mascotaRepository.findById(id).map(mascota -> {
            mascota.nombre = mascotaRequest.nombre;
            mascota.dueño = mascotaRequest.dueño;
            mascotaRepository.save(mascota);

            return ResponseEntity.ok(mascota);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("{id}")
    public ResponseEntity<Mascota> updatePartial(@PathVariable Long id, @RequestBody MascotaRequest mascotaRequest) {
        // Optional<Mascota> mascotaOptional = mascotaRepository.findById(id);
        // if (mascotaOptional.isPresent()) {
        // Mascota mascota = mascotaOptional.get();
        // mascota.nombre = mascotaRequest.nombre;
        // mascota.dueño = mascotaRequest.dueño;
        // mascotaRepository.save(mascota);

        // return ResponseEntity.ok(mascota);
        // }

        // return ResponseEntity.notFound().build();

        return mascotaRepository.findById(id).map(mascota -> {
            if (mascotaRequest.dueño != null) {
                mascota.dueño = mascotaRequest.dueño;
            }

            if (mascotaRequest.nombre != null) {
                mascota.nombre = mascotaRequest.nombre;
            }

            mascotaRepository.save(mascota);

            return ResponseEntity.ok(mascota);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
