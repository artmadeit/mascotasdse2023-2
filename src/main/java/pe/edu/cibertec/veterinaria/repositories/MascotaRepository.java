package pe.edu.cibertec.veterinaria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.cibertec.veterinaria.entidades.Mascota;

public interface MascotaRepository extends JpaRepository<Mascota, Long> {
}
