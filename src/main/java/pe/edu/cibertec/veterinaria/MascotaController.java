package pe.edu.cibertec.veterinaria;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
    public Page<Mascota> findAll(Pageable pageable, String nombre) {
        // opcion 1. usar dto
        // return mascotaRepository.findAll(pageable).map(mascota -> {
        // var dto = new MascotaDto();
        // dto.id = mascota.id;
        // dto.dueño = mascota.dueño;
        // dto.nombre = mascota.nombre;
        // return dto;
        // });

        // opcion 2. ignorar el campo al momento de ser serializado
        if (nombre != null) {
            return mascotaRepository.findByNombreContains(nombre, pageable);
        }

        return mascotaRepository.findAll(pageable);
    }

    @GetMapping("{id}")
    public ResponseEntity<Mascota> findById(@PathVariable Long id) {
        return ResponseEntity.of(mascotaRepository.findById(id));
    }

    @DeleteMapping("{id}")
    @Transactional
    public void deleteById(@PathVariable Long id) {
        // mascotaRepository.deleteById(id);

        // 1ra. opcion
        // select
        // update
        // mascotaRepository.findById(id).ifPresent(mascota -> {
        // mascota.isDeleted = true;
        // mascotaRepository.save(mascota);
        // });

        // 2da. opcion
        // update
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
