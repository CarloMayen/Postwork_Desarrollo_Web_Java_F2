package org.bedu.backend.postwork_s6.controller;

import org.bedu.backend.postwork_s6.model.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;

@RestController
@RequestMapping("/api/v1/persona")
public class PersonaController {
    HashSet<Persona> personas;

    @PostMapping
    public ResponseEntity<Persona> crearPersona(@RequestBody Persona persona) {
        if (personas == null) personas = new HashSet<Persona>();

        personas.add(persona);
        System.out.println(personas.toString());
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<HashSet<Persona>> getPersonas(){
        return ResponseEntity.ok(personas);
    }

}
