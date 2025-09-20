package edu.eci.arsw.alpha.controllers;

import edu.eci.arsw.alpha.models.Alpha;
import edu.eci.arsw.alpha.services.AlphaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alphas")
public class AlphaController {

    @Autowired
    private AlphaServices alphaServices;

    @GetMapping
    public List<Alpha> getAll() {
        return alphaServices.getAll();
    }

    @GetMapping("/{id}")
    public Alpha getById(@PathVariable Long id) {
        return alphaServices.getById(id);
    }

    @PostMapping
    public Alpha create(@RequestBody Alpha alpha) {
        return alphaServices.save(alpha);
    }

    @PutMapping("/{id}")
    public Alpha update(@PathVariable Long id, @RequestBody Alpha alpha) {
        alpha.setId(id);
        return alphaServices.save(alpha);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        alphaServices.delete(id);
    }
}