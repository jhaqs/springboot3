package com.nttdata.demojpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Empleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emplId;

    private String nombre;

    private String email;

    private String direccion;

    private String telefono;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    @JsonIgnoreProperties("empleadoList")
    private Empresa empresa;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("empleados")
    @JoinTable(
            name = "Empleado_Rol",
            joinColumns = {@JoinColumn(name = "empleado_id")},
            inverseJoinColumns = {@JoinColumn(name = "rol_id")})
    private List<Rol> roles;

    @OneToOne(mappedBy = "empleado")
    @JsonIgnoreProperties("empleado")
    Usuario usuario;
}
