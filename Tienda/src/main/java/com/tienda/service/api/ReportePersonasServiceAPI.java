/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.service.api;

import com.tienda.model.ReportePersonasDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author madri
 */
public interface ReportePersonasServiceAPI {
    ReportePersonasDTO obtenerReportePersonas(Map<String, Object> params) throws JRException, IOException, SQLException;
}
