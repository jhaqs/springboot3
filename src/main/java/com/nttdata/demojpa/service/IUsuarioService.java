package com.nttdata.demojpa.service;

import com.nttdata.demojpa.entity.Usuario;

import java.util.List;

public interface IUsuarioService {
    List<Usuario> listarUsuario();

    Usuario crearUsuario(Usuario usuario);

    Usuario buscarUsuario(Long id);

    Usuario modificarUsuario(Long id, Usuario usuario);

    String eliminarUsuario(Long id);
}
