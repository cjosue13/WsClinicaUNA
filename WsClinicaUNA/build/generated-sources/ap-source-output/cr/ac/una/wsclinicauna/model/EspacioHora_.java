package cr.ac.una.wsclinicauna.model;

import cr.ac.una.wsclinicauna.model.Agenda;
import cr.ac.una.wsclinicauna.model.Cita;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-04T16:47:47")
@StaticMetamodel(EspacioHora.class)
public class EspacioHora_ { 

    public static volatile SingularAttribute<EspacioHora, Long> pkClnEspacioHora;
    public static volatile SingularAttribute<EspacioHora, Agenda> pkClnAgenda;
    public static volatile SingularAttribute<EspacioHora, Long> espVersion;
    public static volatile ListAttribute<EspacioHora, Cita> citaList;

}