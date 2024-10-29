package com.nttdata.demojpa.dto;

import java.util.Date;

import lombok.Data;

@Data
public class EmpresaDto {
  private String razonSocial;

  private String ruc;

  private String representante;

  private Date fechaCreacion;
}
