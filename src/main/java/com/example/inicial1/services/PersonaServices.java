package com.example.inicial1.services;

import com.example.inicial1.entities.Persona;
import com.example.inicial1.repositories.PersonaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServices implements BaseService<Persona> {


    private PersonaRepository personaRepository;

    public PersonaServices(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    @Transactional
    public List<Persona> findAll() throws Exception {
        try {
            List<Persona> personas = personaRepository.findAll();
            return personas;
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona findById(Long id) throws Exception {
        try {
            Optional<Persona> personaOptional = personaRepository.findById(id);
            return personaOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona save(Persona persona) throws Exception {
       try {
           persona = personaRepository.save(persona);
           return persona;
       } catch (Exception e) {
           throw new Exception(e.getMessage());
       }
    }

    @Override
    @Transactional
    public Persona update(Long id, Persona persona) throws Exception {
        try {
            Optional<Persona> personaOptional = personaRepository.findById(id);
            Persona persona1 = personaOptional.get();
            persona1 = personaRepository.save(persona1);
            return persona1;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (personaRepository.existsById(id)) {
                personaRepository.deleteById(id);
                return true;
            } else {
                throw new Exception("No se puede eliminar a la persona con id " + id);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
