package cr.ac.una.wsclinicauna.model;

import cr.ac.una.wsclinicauna.model.Agenda;
import cr.ac.una.wsclinicauna.model.CitasPorEspacio;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-21T14:44:04")
@StaticMetamodel(Espacio.class)
public class Espacio_ { 

    public static volatile SingularAttribute<Espacio, Long> espId;
    public static volatile ListAttribute<Espacio, CitasPorEspacio> citasPorEspacioList;
    public static volatile SingularAttribute<Espacio, Agenda> espAgenda;
    public static volatile SingularAttribute<Espacio, Date> espHoraInicio;
    public static volatile SingularAttribute<Espacio, Date> espHoraFin;
    public static volatile SingularAttribute<Espacio, Long> espVersion;

}