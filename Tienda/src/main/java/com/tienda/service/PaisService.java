package com.tienda.service;
import com.tienda.entity.Pais;
import com.tienda.repository.PaisRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaisService implements IPaisService{

    //Autowired para la inyeccion de dependencias, en este caso Pais
    @Autowired
    private PaisRepository paisRepository;

    public List<Pais> listCountry() {
        //Aqui devolvemos una lista de paises de paisRepository.
        return (List<Pais>) paisRepository.findAll();
    }
}
