package com.nttdata.demojpa.service;

import com.nttdata.demojpa.entity.Rol;

import java.util.List;

public interface IRolService {
    List<Rol> listarRoles();

    Rol crearRol(Rol rol);

    Rol modificarRol(Long id, Rol rol);

    Rol buscarRol(Long id);

    String eliminarRol(Long id);
}
