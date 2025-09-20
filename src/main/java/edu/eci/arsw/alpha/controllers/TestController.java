package edu.eci.arsw.alpha.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
    @RestController
    public class TestController {
        @GetMapping("/")
        public String home() {
            return "Desplegado en Azure!";
        }
    }