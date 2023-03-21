package org.bedu.backend.postwork_s6.service;

import jdk.jfr.Percentage;
import org.bedu.backend.postwork_s6.model.Persona;
import org.bedu.backend.postwork_s6.persistence.AgendaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AgendaService {

    private final ValidadorTelefono validadorTelefono;
    private final AgendaDAO agendaDAO;

    @Autowired
    public AgendaService(ValidadorTelefono validadorTelefono, AgendaDAO agendaDAO){
        this.validadorTelefono = validadorTelefono;
        this.agendaDAO = agendaDAO;
    }

    public Persona guardarPersona(Persona persona){

        if(!validadorTelefono.isValido(persona.getTelefono())){
            return null;
        }
        String telefono = validadorTelefono.limpiaNumero(persona.getTelefono());

        persona.setTelefono(telefono);

        return agendaDAO.guardarPersona(persona);
    }

    public Set<Persona> getPersonas(){
        return agendaDAO.getPersonas();
    }
}
