package com.fiap.SeaGO.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Seago {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Email
    @Size(min = 3, max = 255)
    private String email;

    @NotBlank
    @Size(min = 3, max = 255)
    private String site;

    @NotBlank
    @Size(min = 15, max = 17)
    private String telefone;

    @NotBlank
    @Size(min = 3, max = 255)
    private String status;

    @NotBlank
    @Size(min = 3, max = 255)
    private String descricao;

    @ManyToOne
    private Empresa empresa;
}