package cr.ac.una.wsclinicauna.model;

import cr.ac.una.wsclinicauna.model.ControlPaciente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-04T16:47:47")
@StaticMetamodel(Examen.class)
public class Examen_ { 

    public static volatile ListAttribute<Examen, ControlPaciente> controlPacienteList;
    public static volatile SingularAttribute<Examen, String> exmAnotaciones;
    public static volatile SingularAttribute<Examen, Long> exmVersion;
    public static volatile SingularAttribute<Examen, String> exmNombreExamen;
    public static volatile SingularAttribute<Examen, Long> pkClnExamen;
    public static volatile SingularAttribute<Examen, Date> exmFecha;

}