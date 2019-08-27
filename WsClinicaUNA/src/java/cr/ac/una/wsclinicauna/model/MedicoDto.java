package cr.ac.una.wsclinicauna.model;

import cr.ac.una.wsclinicauna.util.LocalDateAdapter;
import cr.ac.una.wsclinicauna.util.LocalDateTimeAdapter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Carlos Olivares
 */
@XmlRootElement(name = "MedicoDto")
@XmlAccessorType(XmlAccessType.FIELD)
public class MedicoDto {

    private Long ID;
    private String Codigo;
    private String Folio;
    private String carne;
    private String Estado;
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime InicioJornada;
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime FinJornada;

    public MedicoDto() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getFolio() {
        return Folio;
    }

    public void setFolio(String Folio) {
        this.Folio = Folio;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public LocalDateTime getInicioJornada() {
        return InicioJornada;
    }

    public void setInicioJornada(LocalDateTime InicioJornada) {
        this.InicioJornada = InicioJornada;
    }

    public LocalDateTime getFinJornada() {
        return FinJornada;
    }

    public void setFinJornada(LocalDateTime FinJornada) {
        this.FinJornada = FinJornada;
    }
}
