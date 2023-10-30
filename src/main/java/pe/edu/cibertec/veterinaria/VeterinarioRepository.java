package pe.edu.cibertec.veterinaria;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {

    @Query("select new pe.edu.cibertec.veterinaria.VeterinarioDto(v.nombre, e.nombre) from Veterinario v join v.especialidad e")
    List<VeterinarioDto> findByResumido();
}
