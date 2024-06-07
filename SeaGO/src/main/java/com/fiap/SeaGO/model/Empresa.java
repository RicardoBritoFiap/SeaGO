package com.fiap.SeaGO.model;

import org.hibernate.validator.constraints.br.CNPJ;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Empresa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @CNPJ
    private String cnpj;

    @Email
    @Size(min = 3, max = 255)
    private String email;

    @NotBlank
    @Size(min = 3, max = 255)
    public String senha;
        
    @NotBlank
    @Size(min = 3, max = 255)
    private String nome;

    @NotBlank
    @Size(min = 3, max = 255)
    private String setor_de_atuacao;

    @NotBlank
    @Size(min = 3, max = 255)
    private String tipo_de_carga;

}
    
