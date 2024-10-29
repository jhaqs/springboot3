package com.nttdata.demojpa.service;

import com.nttdata.demojpa.entity.Empresa;
import com.nttdata.demojpa.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaServiceImpl implements IEmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public List<Empresa> buscarEmpresas() {

        return empresaRepository.findAll();
    }

    @Override
    public Empresa buscarPorId(Long id) {
        return empresaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Empresa> buscarEmpresasPorRazonSocial(String razonSocial) {
        return empresaRepository.bucarPorRazonSocialSQl(razonSocial);
    }

    @Override
    public List<Empresa> buscarEmpresasPorRUC(String ruc) {
        return empresaRepository.findByRuc(ruc);
    }

    @Override
    public Empresa crearEmpresa(Empresa empresa) {

        return empresaRepository.save(empresa);
    }

    @Override
    public Empresa actualizarEmpresa(Long id, Empresa empresa) {
        empresa.setEmprId(id);
        return empresaRepository.save(empresa);
    }


    @Override
    public String eliminarEmpresa(Long id) {
        try {
            empresaRepository.deleteById(id);
            return "Eliminacion Correcta";
        } catch (Exception ex) {
            return "Error durante la eliminacion";
        }
    }
}
