/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.wsclinicauna.util.resources;

import cr.ac.una.wsclinicauna.model.AgendaDto;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author JORDI RODRIGUEZ
 */

public class AgendaDataSource implements JRDataSource {

    private List<AgendaDto> agendas = new ArrayList<>();
    private int indice = -1;
    
    public AgendaDataSource(){
        
    }
    
    @Override
    public boolean next() throws JRException {
    return ++indice < agendas.size();
    }

    public void addAgenda(AgendaDto agenda){

        this.agendas.add(agenda);

    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
       Object valor = null;

        if ("Medico".equals(jrf.getName())){

            valor = agendas.get(indice).getAgeMedico().getUs().getNombre()+" "
                    +agendas.get(indice).getAgeMedico().getUs().getpApellido()+" "
                    +agendas.get(indice).getAgeMedico().getUs().getsApellido();
            System.out.println("Olivares");

        }
        else 
            if ("Fecha".equals(jrf.getName())){

            valor = agendas.get(indice).getAgeFecha().toString();
            System.out.println("Marin");
        }
        
        /*else if ("apellidos".equals(jrf.getName())){

            valor = listaAsistentes.get(indiceParticipanteActual).getApellidos();

        }
        else if ("dni".equals(jrf.getName())){
            valor = listaAsistentes.get(indiceParticipanteActual).getDni();
        }*/

        return valor;
    }

    @Override
    public String toString() {
        return "AgendaDataSource{" + "agendas=" + agendas + ", indice=" + indice + '}';
    }
 
}
