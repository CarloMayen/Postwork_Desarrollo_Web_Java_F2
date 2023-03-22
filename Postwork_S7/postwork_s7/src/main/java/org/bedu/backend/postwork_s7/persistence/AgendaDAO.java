package org.bedu.backend.postwork_s7.persistence;

import org.bedu.backend.postwork_s7.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

@Repository
public class AgendaDAO {

    private static  final SortedSet<Persona> personas = new TreeSet<>();

    public Persona guardarPersona(Persona persona){
        personas.add(persona);
        return persona;
    }

    public Set<Persona> getPersonas(){
        return personas;
    }
}
