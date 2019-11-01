/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.wsclinicauna.report;

import cr.ac.una.wsclinicauna.model.AgendaDto;
import cr.ac.una.wsclinicauna.model.MedicoDto;
import cr.ac.una.wsclinicauna.util.resources.AgendaDataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Carlos Olivares
 */
@XmlRootElement(name = "ReportManager")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReportManager {

    //private static ReportManager INSTANCE = null;
    //private final Map parametros;
    private JasperViewer jv;
    private JasperPrint print;
    private JRDataSource dataSource;

    public ReportManager() {
    }

    public JasperViewer getJv() {
        return jv;
    }

    public void setJv(JasperViewer jv) {
        this.jv = jv;
    }

    public JasperPrint getPrint() {
        return print;
    }

    public void setPrint(JasperPrint print) {
        this.print = print;
    }

    public JRDataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(JRDataSource dataSource) {
        this.dataSource = dataSource;
    }

    /*public ReportManager(){
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
    }*/
    private void generarReporte(String nombreArchivo) {
        try {
            //JRBeanDataSource jrb
            JasperReport report;
            report = (JasperReport) JRLoader.loadObject(getClass().getResource(nombreArchivo + ".jrxml"));
            System.out.println("sjdnjksdnjksndjn");
            print = JasperFillManager.fillReport(report, null, dataSource);
            jv = new JasperViewer(print, false);
            /*jv.setVisible(true);
            jv.setTitle("Agenda Medica");*/
        } catch (JRException e) {
            e.getStackTrace();
        }
    }

    public void ReporteAgenda(ArrayList<AgendaDto> agendas) {
        InputStream inputStream = null;
        dataSource = new AgendaDataSource();

        agendas.stream().forEach(x -> {
            String nombre = x.getAgeMedico().getUs().getNombre() + " " + x.getAgeMedico().getUs().getpApellido() + " "
                    + " " + x.getAgeMedico().getUs().getsApellido();
            ((AgendaDataSource) dataSource).addAgenda(x);

        });
        //System.out.println(dataSource);
        try{
            File f1 = new File(".");
                String dir1 = f1.getAbsolutePath();
        inputStream = new FileInputStream ("src\\java\\cr\\ac\\una\\wsclinicauna\\report\\AgendaM.jrxml");
        }catch(FileNotFoundException ex){
                System.out.println(ex.getMessage());
        }
        
        try {
             JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            print = JasperFillManager.fillReport(jasperReport, null, dataSource);
        } catch (JRException e) {
            System.out.println(e.getMessage());
        }
       // System.out.println(print);
           
        //generarReporte("AgendaM");
    }

    @Override
    public String toString() {
        return "ReportManager{" + "jv=" + jv + ", print=" + print + ", dataSource=" + dataSource + '}';
    }

}
