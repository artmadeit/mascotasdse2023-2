package pe.edu.cibertec.veterinaria;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface MascotaRepository extends JpaRepository<Mascota, Long> {

    // @Query("update Mascota set isDeleted = true where id = :id")
    @Modifying
    @Query(value = "update mascota set eliminado = true where id = :id", nativeQuery = true)
    void softDelete(Long id);

    Page<Mascota> findAllByIsDeletedFalse(Pageable pageable);

    Optional<Mascota> findByIdAndIsDeletedFalse(Long id);

    Page<Mascota> findByNombreContainsAndIsDeletedFalse(String nombre, Pageable pageable);
}
