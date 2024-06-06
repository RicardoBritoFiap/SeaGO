package com.fiap.SeaGO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fiap.SeaGO.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
    public Empresa findByCnpjAndSenha(String cnpj, String senha);

    @Query("SELECT m FROM Empresa m WHERE m.cnpj = ?1")
        Empresa findByCNPJ(String cnpj);
    @Query("SELECT m FROM Empresa m WHERE m.senha = ?1")
        Empresa findBySenha(String senha);

} 