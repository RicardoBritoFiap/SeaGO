package com.fiap.SeaGO.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Navio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String capacidade_carga;

    @NotBlank
    private String comprimento_navio;

    @NotBlank
    private String largura_navio;

    @NotBlank
    private String profundidade_navio;

    @NotBlank
    private String altura_navio;

    @NotBlank
    private String ultima_manutencao;

}