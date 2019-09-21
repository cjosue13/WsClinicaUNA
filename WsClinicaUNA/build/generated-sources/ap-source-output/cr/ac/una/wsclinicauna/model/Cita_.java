package cr.ac.una.wsclinicauna.model;

import cr.ac.una.wsclinicauna.model.CitasPorEspacio;
import cr.ac.una.wsclinicauna.model.Paciente;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-21T14:44:04")
@StaticMetamodel(Cita.class)
public class Cita_ { 

    public static volatile SingularAttribute<Cita, Long> ctId;
    public static volatile SingularAttribute<Cita, String> ctEstado;
    public static volatile SingularAttribute<Cita, Paciente> ctPaciente;
    public static volatile ListAttribute<Cita, CitasPorEspacio> citasPorEspacioList;
    public static volatile SingularAttribute<Cita, String> ctCorreo;
    public static volatile SingularAttribute<Cita, Long> ctVersion;
    public static volatile SingularAttribute<Cita, String> ctTelefono;
    public static volatile SingularAttribute<Cita, String> ctMotivo;

}