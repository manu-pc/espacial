package aplicacion;

import java.time.LocalDate;

public class Colaboracion {
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String Cientifico;
    private String Agencia;

    public Colaboracion(LocalDate fechaInicio, LocalDate fechaFin, String Cientifico, String Agencia) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.Cientifico = Cientifico;
        this.Agencia = Agencia;
    }

    public Colaboracion() {
        this.fechaInicio = null;
        this.fechaFin = null;
        this.Cientifico = "";
        this.Agencia = "";
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaInicioString() {
        return fechaInicio.toString();
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public String getFechaFinString() {
        return fechaFin.toString();
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getCientifico() {
        return Cientifico;
    }

    public void setCientifico(String Cientifico) {
        this.Cientifico = Cientifico;
    }

    public String getAgencia() {
        return Agencia;
    }

    public void setAgencia(String Agencia) {
        this.Agencia = Agencia;
    }

}
