package com.fiap.SeaGO.model;


import org.springframework.format.annotation.NumberFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Seago {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Email
    private String email;

    @NotBlank
    private String site;

    @NumberFormat
    private String telefone;

    @NotBlank
    private String status;

    @NotBlank
    private String descricao;

    @ManyToOne
    private Empresa empresa;
}