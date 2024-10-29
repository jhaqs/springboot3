package com.nttdata.demojpa.service;

import java.util.List;

import com.nttdata.demojpa.dto.EmpresaDto;
import com.nttdata.demojpa.entity.Empresa;

public interface IEmpresaService {

  List<Empresa> buscarEmpresas();

  List<Empresa> buscarEmpresasPorRazonSocial(String razonSocial);

  List<Empresa> buscarEmpresasPorRUC(String ruc);

  Empresa crearEmpresa(Empresa empresa);

  Empresa actualizarEmpresa(Long id, Empresa empresa);

  String eliminarEmpresa(Long id);

  Empresa buscarPorId(Long id);
}
