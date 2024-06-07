package com.fiap.SeaGO.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Rota {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 255)
    private String descricao;

    @NotBlank
    @Size(min = 3, max = 255)
    private String porto_origem;

    @NotBlank
    @Size(min = 3, max = 255)
    private String porto_destino;

    @NotBlank
    @Size(min = 3, max = 255)
    private String duracao;
    
    @NotBlank
    @Size(min = 3, max = 255)
    private String distancia;
    
    @NotBlank
    @Size(min = 3, max = 255)
    private String condicao_meteorologica;

    @ManyToOne
    private Navio navio;
}