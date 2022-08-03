/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.commons;

import com.tienda.enums.TipoReporteEnum;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

/**
 *
 * @author madri
 */
//Clase de tipo Component de SpringFramework
@Component
public class JasperReportManager {

    //Aqui tenemos dos constantes
    private static final String REPORT_FOLDER = "reports";

    private static final String JASPER = ".jasper";

    /*Aqui tenemos un metodo que se llama export, este recibe el nombre del
        Archivo, el tipo del reporte, los parametros del reporte y la conexcion*/
    public ByteArrayOutputStream export(String fileName, String tipoReporte, Map<String, Object> params,
            Connection con) throws JRException, IOException {

        /*Logica que no permite exportar en un destino en especifico, pero 
            nosotros lo conservamos en memoria*/
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        ClassPathResource resource = new ClassPathResource(REPORT_FOLDER + File.separator + 
                fileName + JASPER);

        InputStream inputStream = resource.getInputStream();
        JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, params, con);
        /*Aqui tenemos esta clase tipo reporte enum, que es excel o pdf*/

        //Aqui es si envia como un excel
        if (tipoReporte.equalsIgnoreCase(TipoReporteEnum.EXCEL.toString())) {
            JRXlsxExporter exporter = new JRXlsxExporter();
            //Aqui tenemos el input y el output
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(stream));
            SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
            configuration.setDetectCellType(true);
            configuration.setCollapseRowSpan(true);
            exporter.setConfiguration(configuration);
            exporter.exportReport();
        } //Aqui es si se envia como pdf, donde llamamos a este metodo 
        else {
            JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
        }

        return stream;
    }

}
