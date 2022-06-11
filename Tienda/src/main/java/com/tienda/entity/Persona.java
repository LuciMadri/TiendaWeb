package com.tienda.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//Definimos de que tipo es nuestra clase, en este caso una entidad.
@Entity
//Definir la tabla que hay en la bd en este caso se llama personas.
@Table(name = "personas")

//implementamos una interfaz "Serializable"
public class Persona implements Serializable{
    
    //Creamos los atributos que asemejen la tabla (persona).
    
    //Definimos la llame primaria con @id
    @Id
    
    //Con esta valor decimos que nuestra id va a obtener un valor autoincremental.
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String telefono;
    private String email;
    
    //Definomos la relacion  de una a muchas
    @ManyToOne
    
    //Foreign key
    @JoinColumn (name="paises_id")
    
    /*Aqui guardamos un objeto de tipo pais porque estamos haciendo una referancia
    Con un foreign key, el foreign key apunta a otra tabla entonces para obtener el
    Valor de esa columna esa tabla, ocupamos la referencia*/
    
    //Entonces apuntamos a otra entidad en esta caso "Pais"
    private Pais pais;

    
    //Creamos getters y setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
    
    
    
}
