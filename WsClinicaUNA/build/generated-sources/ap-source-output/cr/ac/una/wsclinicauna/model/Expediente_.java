package cr.ac.una.wsclinicauna.model;

import cr.ac.una.wsclinicauna.model.Paciente;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-04T16:47:47")
@StaticMetamodel(Expediente.class)
public class Expediente_ { 

    public static volatile SingularAttribute<Expediente, Long> plClnExpediente;
    public static volatile SingularAttribute<Expediente, Long> expVersion;
    public static volatile SingularAttribute<Expediente, String> expAntecedentesFamiliares;
    public static volatile SingularAttribute<Expediente, String> expAntecedentePatologicos;
    public static volatile SingularAttribute<Expediente, Paciente> pacId;
    public static volatile SingularAttribute<Expediente, String> expTratamientos;
    public static volatile SingularAttribute<Expediente, String> expAlergias;
    public static volatile SingularAttribute<Expediente, String> expHospitalizaciones;
    public static volatile SingularAttribute<Expediente, String> expOperaciones;

}