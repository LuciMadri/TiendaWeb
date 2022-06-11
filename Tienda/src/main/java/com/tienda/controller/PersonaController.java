package com.tienda.controller;
import com.tienda.entity.Persona;
import com.tienda.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author madri
 */

//Definimos de que tipo de objeto va a ser nuestra clase
@Controller
public class PersonaController {
    
    //Hacemos inyeccion de dependencias
    @Autowired
    //El controller utiliza el servicio, en este caso personaService
    private IPersonaService personaService;
    
    /*El GetMapping crea la ruta, entonces al escribir localhost/persona 
    nos ejecuta el metodo
    */
    
    @GetMapping("/persona")
    
    //Puede ser cualquier nombre en vez de INDEX
    
    /*Aqui le pasamos un objeto de tipo model, ya que le pasamos informacion
    que puede ser sustituida ya que proviene de la bd, entonces la forma en la
    que le pasamos esos valores es por el objeto de tipo model*/
    public String index(Model model){
        
        /*Aqui creamos una lista y le pasamos la informacion por medio del metodo
          getAllPersona de nuestra clase interface.*/
        List<Persona> listaPersona = personaService.getAllPersona();
        
        /*Aqui, en nuestro html donde se encuentre la palabra titulo lo va a 
          sustituir por tabla persona*/
        model.addAttribute("titulo", "Tabla Persona");
        
        /*Aqui, en nuestro html donde se encuentre la palabra personas lo va a 
         sustituir por la listaPersona*/
        model.addAttribute("personas", listaPersona);
        
        //Aqui retornamos un html que se llama personas.
        return "personas";
    }
    
}
