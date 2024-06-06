package com.fiap.SeaGO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fiap.SeaGO.model.Empresa;


public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
    public Empresa findByCnpjAndSenha(String cnpj, String senha);
} 