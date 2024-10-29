package com.nttdata.demojpa.repository;

import com.nttdata.demojpa.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

}
