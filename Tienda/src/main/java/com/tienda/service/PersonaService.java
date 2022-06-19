package com.tienda.service;
import com.tienda.entity.Persona;
import com.tienda.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Le decimos de que es el tipo de clase que va implementar en este caso Servicio
@Service

//Implementamos IPersonaService
//Este implements es una clase implementaria, osea que tiene una
//o mas interfaces.
public class PersonaService implements IPersonaService {
    
    //Autowired para hacer inyeccion de dependencias. 
    @Autowired
    //Inyectamos la clase de personaRepository
    private PersonaRepository personaRepository;
    
    //Aqui nada mas generamos todos los metodos abstractos.
    @Override 
    public List<Persona> getAllPersona() {
        //Aqui devolvemos una lista de personas de personaRepository.
        return (List<Persona>) personaRepository.findAll();
    }
    @Override
    public Persona getPersonaById(long id) {
        //Vamos a  devolver el id de la persona o sino nulo
        return personaRepository.findById(id).orElse(null);
    }
    
    //Estos no devuelven nada porque son de tipo void
    @Override
    public void savePersona(Persona persona) {
        //Para guardar la persona
        personaRepository.save(persona);
    }
    @Override
    public void delete(long id) {
        //Eliminamos por id
        personaRepository.deleteById(id);
    }

}
