package pe.edu.cibertec.veterinaria;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// GET /boletas
// GET /boleta <= malo, debe ser plural
// DELETE /boletas
// DELETE /boletas/{id}
// DELETE /boletas/eliminar/{id} <= malo

@RestController
@RequestMapping("boletas")
// @AllArgsConstructor
public class BoletaController {

    // @Autowired
    // BoletaRepository boletaRepository;

    @GetMapping
    public List<Boleta> findAll() {
        return new ArrayList<>();
    }

    @GetMapping("/{id}")
    public Boleta findById(Long id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public Boleta eliminar(Long id) {
        return null;
    }

}
