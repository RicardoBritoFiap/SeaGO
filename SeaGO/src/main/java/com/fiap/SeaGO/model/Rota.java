package com.fiap.SeaGO.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Rota {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    private String descricao;

    @NotBlank
    private String porto_origem;

    @NotBlank
    private String porto_destino;

    @NotBlank
    private String duracao;
    
    @NotBlank
    private String distancia;
    
    @NotBlank
    private String condicao_meteorologica;
}