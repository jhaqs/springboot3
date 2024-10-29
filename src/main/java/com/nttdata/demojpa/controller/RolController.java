package com.nttdata.demojpa.controller;

import com.nttdata.demojpa.entity.Rol;
import com.nttdata.demojpa.service.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rol")
@CrossOrigin
public class RolController {

    @Autowired
    private IRolService iRolService;

    @GetMapping("/listar")
    List<Rol> listar() {
        return iRolService.listarRoles();
    }

    @GetMapping("/buscar/{id}")
    Rol buscar(@PathVariable("id") Long id) {
        return iRolService.buscarRol(id);
    }

    @PostMapping("/crear")
    Rol crear(@RequestBody Rol rol) {
        return iRolService.crearRol(rol);
    }

    @PutMapping("/modificar/{id}")
    Rol modificar(@PathVariable("id") Long id, @RequestBody Rol rol) {
        return iRolService.modificarRol(id, rol);
    }

    @DeleteMapping("/eliminar/{id}")
    String eliminar(@PathVariable("id") Long id) {
        return iRolService.eliminarRol(id);
    }
}
