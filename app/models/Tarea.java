package models;

import io.ebean.Finder;
import io.ebean.Model;
import jakarta.persistence.*;

@Entity
@Table(name = "tareas")
public class Tarea extends Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    public String nombre;

    @Column(columnDefinition = "TEXT")
    public String descripcion;

    @Column(nullable = false)
    public boolean completada;

    //Construtor
    public Tarea(String nombre, String descripcion, boolean completada) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.completada = completada;
    }

    //Para consultas
    public static Finder<Long, Tarea> find = new Finder<>(Tarea.class);
}
