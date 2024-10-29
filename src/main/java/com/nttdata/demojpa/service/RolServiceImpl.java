package com.nttdata.demojpa.service;

import com.nttdata.demojpa.entity.Rol;
import com.nttdata.demojpa.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolServiceImpl implements IRolService {

    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<Rol> listarRoles() {
        return rolRepository.findAll();
    }

    @Override
    public Rol crearRol(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public Rol modificarRol(Long id, Rol rol) {
        rol.setId(id);
        return rolRepository.save(rol);
    }

    @Override
    public Rol buscarRol(Long id) {
        return rolRepository.findById(id).orElse(null);
    }

    @Override
    public String eliminarRol(Long id) {
        try {
            rolRepository.deleteById(id);
            return "Eliminacion Correcta";
        } catch (Exception ex) {
            return "Error durante la eliminacion";
        }
    }
}
