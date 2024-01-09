package pe.edu.cibertec.veterinaria;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
@SQLDelete(sql = "UPDATE mascota SET eliminado = true WHERE id=?")
@Where(clause = "eliminado = false")
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nombre;
    String dueño;

    // soft delete
    @JsonIgnore
    @Column(name = "eliminado")
    Boolean isDeleted = false;
}
