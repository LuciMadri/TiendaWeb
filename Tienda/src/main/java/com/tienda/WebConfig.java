package com.tienda;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/* Internationalization ------ il8n ------ 18 letras entre I y n
 * Locale: Representa es el lenguaje, la region goegrafica, variantes del 
   dialecto/ idioma, del usuario
 * SessionLocalResolver : guarda el locale seleccionado por un usuario como 
   atributo en el request HTTP
 * LocalChangeInterceptor: detecta cual cambio de parte del usuario hacia lo que
   es
*/             
@Configuration

//Aqui implementamos lo metodos de clase tipo interface de WebMvcConfigurer
public class WebConfig implements WebMvcConfigurer {

    //El bean sirve para hacer configuraciones especificas y poder inyectarlas.
    @Bean
    //Este metodo guarda dentro del SessionLocaleResolver mi idioma como tal.
    public SessionLocaleResolver localeResolver() {
        //Creamos un objeto nuevo de esa clase que se llama slr
        var slr = new SessionLocaleResolver();
        /*Luego en esa clase que es de tipo SessionLoceleResolver 
            Tiene un metodo que se llama setDefaultLocale
            Entonces ahi mismo le setteamos un objeto de tipo locale*/
        
        /*--- Que es lo que hace este objeto?
              Este objeto nos define la region geografica en la que el usuario
              Se encuentre, la variante del dialecto en el cual este hablando.
              Todo eso se nos guarda en esta variable de tipo locale.
        */
        slr.setDefaultLocale(new Locale("en"));
        return slr;
    }
    
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        var lci = new LocaleChangeInterceptor();
        /* Aqui le estamos seteando el nombre del parametro, en esta caso seria
           lang, de language, entonces cual el detecte un cambio en lang, el va 
           a tomar ese valor y lo va a guardar en localChangeInterceptor
        */ 
        lci.setParamName("lang");
        return lci;
    }
    
    //Este metodo intercepta todas la llamadas y esas llamadas son ecuchadas 
    //el localChangeInterceptor
    @Override
    public void addInterceptors(InterceptorRegistry registro){
        registro.addInterceptor(localeChangeInterceptor());
    }
    

}
