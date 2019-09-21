package cr.ac.una.wsclinicauna.model;

import cr.ac.una.wsclinicauna.model.EspacioHora;
import cr.ac.una.wsclinicauna.model.Medico;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-04T16:47:47")
@StaticMetamodel(Agenda.class)
public class Agenda_ { 

    public static volatile ListAttribute<Agenda, EspacioHora> espacioHoraList;
    public static volatile SingularAttribute<Agenda, Medico> medId;
    public static volatile SingularAttribute<Agenda, Long> ageVersion;
    public static volatile SingularAttribute<Agenda, Long> pkClnAgenda;

}