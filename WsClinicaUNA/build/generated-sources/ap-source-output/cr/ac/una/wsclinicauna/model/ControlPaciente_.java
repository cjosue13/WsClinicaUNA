package cr.ac.una.wsclinicauna.model;

import cr.ac.una.wsclinicauna.model.Examen;
import cr.ac.una.wsclinicauna.model.Paciente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-04T16:47:47")
@StaticMetamodel(ControlPaciente.class)
public class ControlPaciente_ { 

    public static volatile SingularAttribute<ControlPaciente, Double> cntTemperatura;
    public static volatile SingularAttribute<ControlPaciente, String> cntObservaciones;
    public static volatile SingularAttribute<ControlPaciente, String> cntRazonConsulta;
    public static volatile SingularAttribute<ControlPaciente, Double> cntImc;
    public static volatile SingularAttribute<ControlPaciente, String> cntPlanAtencion;
    public static volatile SingularAttribute<ControlPaciente, Date> cntFecha;
    public static volatile SingularAttribute<ControlPaciente, Double> cntTalla;
    public static volatile SingularAttribute<ControlPaciente, Double> cntFrecuenciaCardiaca;
    public static volatile SingularAttribute<ControlPaciente, Long> cntVersion;
    public static volatile SingularAttribute<ControlPaciente, Examen> pkClnExamen;
    public static volatile SingularAttribute<ControlPaciente, String> cntExamenFisico;
    public static volatile SingularAttribute<ControlPaciente, Date> cntControl;
    public static volatile SingularAttribute<ControlPaciente, String> cntAnotacionEnfermeria;
    public static volatile SingularAttribute<ControlPaciente, Long> pkClnControlPaciente;
    public static volatile SingularAttribute<ControlPaciente, Double> cntPresion;
    public static volatile SingularAttribute<ControlPaciente, Paciente> pacId;
    public static volatile SingularAttribute<ControlPaciente, Date> cntHora;
    public static volatile SingularAttribute<ControlPaciente, Double> cntPeso;
    public static volatile SingularAttribute<ControlPaciente, String> cntTratamiento;

}