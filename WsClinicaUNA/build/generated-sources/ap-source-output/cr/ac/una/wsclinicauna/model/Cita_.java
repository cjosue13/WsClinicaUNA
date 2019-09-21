package cr.ac.una.wsclinicauna.model;

import cr.ac.una.wsclinicauna.model.EspacioHora;
import cr.ac.una.wsclinicauna.model.Paciente;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-04T16:47:47")
@StaticMetamodel(Cita.class)
public class Cita_ { 

    public static volatile SingularAttribute<Cita, EspacioHora> pkClnEspacioHora;
    public static volatile SingularAttribute<Cita, Long> pkClnCita;
    public static volatile SingularAttribute<Cita, String> ctEstado;
    public static volatile SingularAttribute<Cita, Paciente> pacId;
    public static volatile SingularAttribute<Cita, Long> ctVersion;
    public static volatile SingularAttribute<Cita, String> ctMotivo;

}