package com.nttdata.demojpa.service;

import com.nttdata.demojpa.entity.Empleado;
import com.nttdata.demojpa.repository.EmpleadoRepository;
import com.nttdata.demojpa.repository.EmpresaRepository;
import com.nttdata.demojpa.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<Empleado> listarEmpleado() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado buscarEmpleado(Long id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    @Override
    public Empleado crearEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado modificarEmpleado(Long id, Empleado empleado) {
        empleado.setEmplId(id);
        return empleadoRepository.save(empleado);
    }

    @Override
    public String eliminarEmpleado(Long id) {
        try {
            empleadoRepository.deleteById(id);
            return "Eliminacion Correcta";
        } catch (Exception ex) {
            return "Error durante la eliminacion";
        }
    }
}
