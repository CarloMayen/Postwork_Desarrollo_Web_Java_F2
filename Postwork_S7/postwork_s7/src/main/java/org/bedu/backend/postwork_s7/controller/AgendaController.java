package org.bedu.backend.postwork_s7.controller;

import org.bedu.backend.postwork_s7.model.Persona;
import org.bedu.backend.postwork_s7.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;
import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1/agenda")
public class AgendaController {

    private AgendaService agendaService;

    @Autowired
    public AgendaController(AgendaService agendaService){
        this.agendaService = agendaService;
    }

    @GetMapping
    public ResponseEntity<Set<Persona>> getPersonas(){
      return ResponseEntity.ok(agendaService.getPersonas());
    }

    @PostMapping
    public ResponseEntity<Persona> guardarPersona(@RequestBody Persona persona){
        Persona resultado = agendaService.guardarPersona(persona);

        if(resultado == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(resultado);
    }

    @GetMapping({"/", "/index"})
    public String listadoPersonas(Model model){
        model.addAttribute("personas", agendaService.getPersonas());
        return "index";
    }

    @PostMapping("/registro")
    public ModelAndView registra(@Valid Persona persona, Errors errors){
        String vistaResultado = "registroExitoso";
        if (errors.hasErrors()){
            vistaResultado = "index";
        }
        ModelAndView mav = new ModelAndView(vistaResultado);
        mav.addObject("persona", persona);
        return mav;
    }

}
