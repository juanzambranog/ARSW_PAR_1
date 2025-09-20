package edu.eci.arsw.alpha.controllers;

import edu.eci.arsw.alpha.models.Alpha;
import edu.eci.arsw.alpha.services.AlphaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/alphas")
@CrossOrigin(origins = "*")
public class AlphaController {

    @Autowired
    private AlphaServices alphaServices;

    @GetMapping
    public ResponseEntity<List<Alpha>> getAll() {
        try {
            List<Alpha> alphas = alphaServices.getAll();
            return ResponseEntity.ok(alphas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alpha> getById(@PathVariable Long id) {
        try {
            Alpha alpha = alphaServices.getById(id);
            return ResponseEntity.ok(alpha);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Alpha> create(@Valid @RequestBody Alpha alpha) {
        try {
            Alpha savedAlpha = alphaServices.save(alpha);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedAlpha);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alpha> update(@PathVariable Long id, @Valid @RequestBody Alpha alpha) {
        try {
            if (!alphaServices.existsById(id)) {
                return ResponseEntity.notFound().build();
            }
            alpha.setId(id);
            Alpha updatedAlpha = alphaServices.save(alpha);
            return ResponseEntity.ok(updatedAlpha);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            alphaServices.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
