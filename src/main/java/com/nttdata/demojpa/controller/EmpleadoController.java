package com.nttdata.demojpa.controller;

import com.nttdata.demojpa.entity.Empleado;
import com.nttdata.demojpa.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleado")
@CrossOrigin
public class EmpleadoController {

    @Autowired
    private IEmpleadoService iEmpleadoService;

    @GetMapping("/listar")
    List<Empleado> listar() {
        return iEmpleadoService.listarEmpleado();
    }

    @GetMapping("/buscar/{id}")
    Empleado buscar(@PathVariable("id") Long id) {
        return iEmpleadoService.buscarEmpleado(id);
    }

    @PostMapping("/crear")
    Empleado crear(@RequestBody Empleado empleado) {
        return iEmpleadoService.crearEmpleado(empleado);
    }

    @PutMapping("/modificar/{id}")
    Empleado modificar(@PathVariable("id") Long id, @RequestBody Empleado empleado) {
        return iEmpleadoService.modificarEmpleado(id, empleado);
    }


    @DeleteMapping("/eliminar/{id}")
    String eliminar(@PathVariable("id") Long id) {
        return iEmpleadoService.eliminarEmpleado(id);
    }

}
