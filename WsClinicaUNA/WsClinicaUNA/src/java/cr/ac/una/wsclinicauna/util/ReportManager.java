/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.wsclinicauna.util;

import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author IVAN
 */
public class ReportManager {
    private static ReportManager INSTANCE = null;
    private final Map parametros;
    
    public ReportManager(){
        this.parametros = new HashMap();
    }
 
    private static void createInstance(){
        if(INSTANCE == null){
            synchronized (ReportManager.class){
                if(INSTANCE == null){
                    INSTANCE = new ReportManager();
                }
            }
        }
    }
    public static ReportManager getInstance(){
        if(INSTANCE==null){
            createInstance();
        }
        return INSTANCE;
    }
    
    private void generarReporte(String nombreArchivo){
        try {
            JasperReport report;
            report = (JasperReport) JRLoader.loadObject(ReportManager.class.getResource(""));
            JasperPrint print = JasperFillManager.fillReport(report, parametros, new JREmptyDataSource());
            JasperViewer.viewReport(print,false);
        } catch (JRException e) {
            
        }
    }
    
}
