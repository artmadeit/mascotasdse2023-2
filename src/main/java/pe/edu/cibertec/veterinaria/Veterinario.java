package pe.edu.cibertec.veterinaria;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nombre;
    String dni;
    String carnet;
    BigDecimal salario;

    @ManyToOne
    Especialidad especialidad;
}
