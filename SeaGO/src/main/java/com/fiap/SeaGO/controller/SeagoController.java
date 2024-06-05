package com.fiap.SeaGO.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.fiap.SeaGO.model.Seago;
import com.fiap.SeaGO.repository.SeagoRepository;
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
@RequestMapping(path = "/Seago")
public class SeagoController {
    @Autowired
    private SeagoRepository repository;

    @GetMapping("{id}")
    public ResponseEntity<Seago> getSeago(@PathVariable Long id) {

        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Seago>> getSeago() {
        List<Seago> seagos = repository.findAll();
        return ResponseEntity.ok(seagos);
    }

    @PostMapping
    public ResponseEntity<Seago> createSeago(@RequestBody @Valid Seago seagos) {
        repository.save(seagos);
        return ResponseEntity.ok(seagos);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSeago(@PathVariable Long id) {
        verificarseexisteseago(id);
        repository.deleteById(id);

        return ResponseEntity.ok("Seago deletada com sucesso");
    }

    @PutMapping("{id}")
    public ResponseEntity<Seago> updateSeago(@PathVariable Long id, @RequestBody Seago seago) {
        verificarseexisteseago(id);
        seago.setId(id);
        repository.save(seago);

        return ResponseEntity.ok(seago);
    }

    private void verificarseexisteseago(Long id) {
        repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        NOT_FOUND,
                        "id da Seago não encontrado"));
    }
}