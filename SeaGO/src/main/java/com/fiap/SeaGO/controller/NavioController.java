package com.fiap.SeaGO.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.fiap.SeaGO.model.Navio;
import com.fiap.SeaGO.repository.NavioRepository;
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
@RequestMapping(path = "/Navio")
public class NavioController {
    @Autowired
    private NavioRepository repository;

    @GetMapping("{id}")
    public ResponseEntity<Navio> getNavio(@PathVariable Long id) {

        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Navio>> getNavio() {
        List<Navio> navios = repository.findAll();
        return ResponseEntity.ok(navios);
    }

    @PostMapping
    public ResponseEntity<Navio> createNavio(@RequestBody @Valid Navio navios) {
        repository.save(navios);
        return ResponseEntity.ok(navios);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteNavio(@PathVariable Long id) {
        verificarseexistenavio(id);
        repository.deleteById(id);

        return ResponseEntity.ok("Navio deletado com sucesso");
    }

    @PutMapping("{id}")
    public ResponseEntity<Navio> updateNavio(@PathVariable Long id, @RequestBody Navio navio) {
        verificarseexistenavio(id);
        navio.setId(id);
        repository.save(navio);

        return ResponseEntity.ok(navio);
    }

    private void verificarseexistenavio(Long id) {
        repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        NOT_FOUND,
                        "id do Navio não encontrado"));
    }
}