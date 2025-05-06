package aplicacion;

import java.time.LocalDate;

public class EntradaForo {
    private int numEntrada;
    private String titulo;
    private String contenido;
    private LocalDate fecha;
    private String autorId;

    public EntradaForo(int numEntrada, String titulo, String contenido, LocalDate fecha, String autorId) {
        this.numEntrada = numEntrada;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fecha = fecha;
        this.autorId = autorId;

    }
    public EntradaForo() {
        this.numEntrada = 0;
        this.titulo = "";
        this.contenido = "";
        this.fecha = null;
        this.autorId = "";
    }

    public int getNumEntrada() {
        return numEntrada;
    }

    public void setNumEntrada(int numEntrada) {
        this.numEntrada = numEntrada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getAutorId() {
        return autorId;
    }

    public void setAutorId(String autorId) {
        this.autorId = autorId;
    }
}
