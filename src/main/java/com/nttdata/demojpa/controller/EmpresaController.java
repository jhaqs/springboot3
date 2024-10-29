package com.nttdata.demojpa.controller;

import com.nttdata.demojpa.dto.EmpresaDto;
import com.nttdata.demojpa.dto.ResponseDTO;
import com.nttdata.demojpa.entity.Empresa;
import com.nttdata.demojpa.service.IEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
@CrossOrigin
public class EmpresaController {

    @Autowired
    private IEmpresaService empresaService;

    @GetMapping("/listar")
    List<Empresa> listarEmpresa() {
        return empresaService.buscarEmpresas();
    }

    @GetMapping("/buscar/razonsocial")
    List<Empresa> findAllEmpresasByRazonSocial(@RequestParam("razonsoc") String razonsocial) {
        return empresaService.buscarEmpresasPorRazonSocial(razonsocial);
    }

    @GetMapping("/buscar/ruc")
    Empresa buscarEmpresaRuc(@RequestParam("ruc") String ruc) {
        return empresaService.buscarEmpresasPorRUC(ruc).stream().findFirst().orElse(new Empresa());
    }

    @GetMapping("/buscar/{id}")
    Empresa buscarPorId(@PathVariable("id") Long id) {
        return empresaService.buscarPorId(id);
    }

    @PostMapping("/crear")
    Empresa crear(@RequestBody Empresa empresa) {
        return empresaService.crearEmpresa(empresa);
    }

    @PutMapping("/actualizar/{id}")
    Empresa actualizar(@RequestHeader HttpHeaders headers, @PathVariable("id") Long id, @RequestBody Empresa empresa) {

        System.out.println(headers.toString());
        return empresaService.actualizarEmpresa(id, empresa);
    }

    @DeleteMapping("/eliminar/{id}")
    ResponseEntity<?> eliminar(@PathVariable("id") Long id) {
        empresaService.eliminarEmpresa(id);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setSuccess(Boolean.TRUE);
        return  new ResponseEntity<>(responseDTO, HttpStatus.OK) ;
    }

}
