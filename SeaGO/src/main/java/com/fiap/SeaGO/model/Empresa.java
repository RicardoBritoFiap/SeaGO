package com.fiap.SeaGO.model;

import org.hibernate.validator.constraints.br.CNPJ;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
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
public class Empresa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @CNPJ
    private String cnpj;

    @Email
    private String email;

    @NotBlank
    public String senha;
        
    @NotBlank
    private String nome;

    @NotBlank
    private String setor_de_atuacao;

    @NotBlank
    private String tipo_de_carga;

}
    
