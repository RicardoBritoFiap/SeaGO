package com.fiap.SeaGO.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.fiap.SeaGO.model.Rota;
import com.fiap.SeaGO.repository.RotaRepository;
import jakarta.validation.Valid;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping(path = "/Rota")
public class RotaController {
    @Autowired
    private RotaRepository repository;

    @GetMapping("{id}")
    public ResponseEntity<Rota> getRota(@PathVariable Long id) {

        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Rota>> getRota() {
        List<Rota> rotas = repository.findAll();
        return ResponseEntity.ok(rotas);
    }

    @PostMapping
    public ResponseEntity<Rota> createRota(@RequestBody @Valid Rota rotas) {
        repository.save(rotas);
        return ResponseEntity.ok(rotas);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRota(@PathVariable Long id) {
        verificarseexisterota(id);
        repository.deleteById(id);

        return ResponseEntity.ok("Rota deletada com sucesso");
    }

    @PutMapping("{id}")
    public ResponseEntity<Rota> updateRota(@PathVariable Long id, @RequestBody Rota rota) {
        verificarseexisterota(id);
        rota.setId(id);
        repository.save(rota);

        return ResponseEntity.ok(rota);
    }

    private void verificarseexisterota(Long id) {
        repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        NOT_FOUND,
                        "id da Rota não encontrado"));
    }
}