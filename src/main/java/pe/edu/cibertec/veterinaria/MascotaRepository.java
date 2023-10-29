package pe.edu.cibertec.veterinaria;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MascotaRepository extends JpaRepository<Mascota, Long> {

    List<Mascota> searchByNombreContains(String nombre); // es lo mismo al buscarMascotaPorNombre

    @Query("select m from Mascota as m where nombre like CONCAT('%', :nombre, '%')") // jpa + sql = jpql
    List<Mascota> buscarMascotaPorNombre(String nombre);

    // select * from where nombre = ?
    List<Mascota> findByNombre(String nombre);

    List<Mascota> readByNombre(String nombre);

    List<Mascota> queryByNombre(String nombre);

    List<Mascota> searchByNombre(String nombre);

}
