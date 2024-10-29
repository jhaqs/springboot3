package com.nttdata.demojpa.repository;

import java.io.Serializable;
import java.util.List;

import com.nttdata.demojpa.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

  List<Empresa> findByRazonSocialContaining(String razonSocial);
  
  List<Empresa> findByRuc(String ruc);

  @Query(value = "SELECT e FROM Empresa e WHERE e.razonSocial LIKE CONCAT('%',?1, '%')")
  List<Empresa> bucarPorRazonSocial(String razonSocial);

  @Query(value = "SELECT * FROM empresa e WHERE e.razon_social LIKE CONCAT('%',?1, '%')",nativeQuery = true)
  List<Empresa> bucarPorRazonSocialSQl(String razonSocial);
}
