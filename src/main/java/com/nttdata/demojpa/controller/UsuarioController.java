package com.nttdata.demojpa.controller;

import com.nttdata.demojpa.entity.Usuario;
import com.nttdata.demojpa.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioController {

    @Autowired
    private IUsuarioService iUsuarioService;

    @GetMapping("/listar")
    List<Usuario> listar() {
        return iUsuarioService.listarUsuario();
    }

    @GetMapping("/buscar/{id}")
    Usuario buscar(@PathVariable("id") Long id) {
        return iUsuarioService.buscarUsuario(id);
    }

    @PostMapping("/crear")
    Usuario crear(@RequestBody Usuario usuario) {
        return iUsuarioService.crearUsuario(usuario);
    }

    @PutMapping("/modificar/{id}")
    Usuario modificar(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
        return iUsuarioService.modificarUsuario(id, usuario);
    }

    @DeleteMapping("/eliminar/{id}")
    String eliminar(@PathVariable("id") Long id) {
        return iUsuarioService.eliminarUsuario(id);
    }

}
