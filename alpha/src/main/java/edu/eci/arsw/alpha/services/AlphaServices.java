package edu.eci.arsw.alpha.services;

import edu.eci.arsw.alpha.models.Alpha;
import edu.eci.arsw.alpha.repository.AlphaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlphaServices {

    @Autowired
    private AlphaRepository alphaRepository;

    public List<Alpha> getAll() {
        return alphaRepository.findAll();
    }

    public Alpha getById(Long id) {
        return alphaRepository.findById(id).orElse(null);
    }

    public Alpha save(Alpha alpha) {
        return alphaRepository.save(alpha);
    }

    public void delete(Long id) {
        alphaRepository.deleteById(id);
    }
}

