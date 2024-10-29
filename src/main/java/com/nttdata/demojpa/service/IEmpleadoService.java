package com.nttdata.demojpa.service;

import java.util.List;

import com.nttdata.demojpa.entity.Empleado;

public interface IEmpleadoService {

  List<Empleado> listarEmpleado();

  Empleado crearEmpleado(Empleado empleado);

  Empleado buscarEmpleado(Long id);

  Empleado modificarEmpleado(Long id, Empleado empleado);

  String eliminarEmpleado(Long id);
}
