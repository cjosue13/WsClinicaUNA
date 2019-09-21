package cr.ac.una.wsclinicauna.model;

import cr.ac.una.wsclinicauna.model.Cita;
import cr.ac.una.wsclinicauna.model.ControlPaciente;
import cr.ac.una.wsclinicauna.model.Expediente;
import cr.ac.una.wsclinicauna.model.Medico;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-04T16:47:47")
@StaticMetamodel(Paciente.class)
public class Paciente_ { 

    public static volatile ListAttribute<Paciente, ControlPaciente> controlPacienteList;
    public static volatile SingularAttribute<Paciente, String> pacCedula;
    public static volatile SingularAttribute<Paciente, Date> pacFechanacimiento;
    public static volatile ListAttribute<Paciente, Expediente> expedienteList;
    public static volatile SingularAttribute<Paciente, String> pacNombre;
    public static volatile SingularAttribute<Paciente, String> pacPapellido;
    public static volatile SingularAttribute<Paciente, String> pacGenero;
    public static volatile SingularAttribute<Paciente, Long> pacVersion;
    public static volatile SingularAttribute<Paciente, String> pacCorreo;
    public static volatile SingularAttribute<Paciente, Long> pacId;
    public static volatile ListAttribute<Paciente, Cita> citaList;
    public static volatile SingularAttribute<Paciente, String> pacSapellido;
    public static volatile ListAttribute<Paciente, Medico> medicoList;

}