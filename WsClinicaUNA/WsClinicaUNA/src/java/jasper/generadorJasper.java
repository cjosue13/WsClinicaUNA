/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jasper;

import cr.ac.una.wsclinicauna.util.CodigoRespuesta;
import cr.ac.una.wsclinicauna.util.Respuesta;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Carlos Olivares
 */
public class generadorJasper {

    public JasperPrint print;

    public generadorJasper() {
    }

    public Respuesta generaReporte(String fechaIni, String fechaFin, Connection conection) {
        try {
            Map parametro = new HashMap();
            parametro.put("fechaIni", fechaIni);
            parametro.put("fechaFin", fechaFin);

            JasperReport reporte = null;
            reporte = (JasperReport) JRLoader.loadObject(generadorJasper.class.getResource("/jasper/AgendaMedica.jasper"));
            JasperPrint j = JasperFillManager.fillReport(reporte, parametro, conection);
            print = j;
            // JasperViewer viewer;

            conection.close();
            Respuesta respuesta = CrearPdf(print);
            return respuesta;
        } catch (SQLException | JRException e) {
            Logger.getLogger(generadorJasper.class.getName()).log(Level.SEVERE, null, e);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Error generando Reporte", e.getMessage());
        }
    }

    public Respuesta CrearPdf(JasperPrint j) {
        try {
            /*
            Creo el pdf
             */
            //Creo la carpeta en el disco local c
            File carpeta = new File("C:\\reporte\\");
            carpeta.mkdir();
            //Guardo el pdf en el archivo
            File archivo = new File("C:\\reporte\\ReporteAgenda.pdf");
            JasperExportManager.exportReportToPdfFile(j, archivo.getAbsolutePath());
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "Reporte Generado exitosamente", "");
        } catch (JRException ex) {
            Logger.getLogger(generadorJasper.class.getName()).log(Level.SEVERE, null, ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Error generando reporte", ex.getMessage());
        }
    }

}
