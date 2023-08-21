package bean;

import java.io.Serializable;
import java.time.LocalDate;

public class Sueño implements Serializable{

    float duracion;
    float latencia;
    byte ambiente;
    String calidadObjetiva;
    byte calidadSubjetiva;
    int id;
    LocalDate fecha;

    public Sueño() {
        
        this.duracion = duracion;
        this.latencia = latencia;
        this.ambiente = ambiente;
        this.calidadObjetiva = calidadObjetiva;
        this.calidadSubjetiva = calidadSubjetiva;
        this.id = id;
        this.fecha = LocalDate.now();
    }

    public String getCalidadObjetiva() {
        return calidadObjetiva;
    }

    public void setCalidadObjetiva(String calidadObjetiva) {
        this.calidadObjetiva = calidadObjetiva;
    }

    public byte getCalidadSubjetiva() {
        return calidadSubjetiva;
    }

    public void setCalidadSubjetiva(byte calidadSubjetiva) {
        this.calidadSubjetiva = calidadSubjetiva;
    }    

    public float getLatencia() {
        return latencia;
    }

    public void setLatencia(float latencia) {
        this.latencia = latencia;
    }

    public byte getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(byte ambiente) {
        this.ambiente = ambiente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

}//CIERRE DE LA CLASE
