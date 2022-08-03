/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.model;

import java.io.ByteArrayInputStream;

/**
 *
 * @author madri
 */
public class ReportePersonasDTO {

    private String fileName;
    
    //Cuando voy a descar el archivo necesito que sea un input String 
    private ByteArrayInputStream stream;
    
    //Esta propiedad se asigna a la hora descargar un archivo dependiendo del tamaño
    private int length;

    //getters y setters 
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public ByteArrayInputStream getStream() {
        return stream;
    }

    public void setStream(ByteArrayInputStream stream) {
        this.stream = stream;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
