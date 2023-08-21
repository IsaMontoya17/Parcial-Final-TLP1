
package bean;

import java.io.Serializable;
import java.time.LocalDate;

public class ActividadFisica implements Serializable{

    private String tipoActividad;
    private double duracion;
    private float distanciaRecorrida;
    private LocalDate fecha;
    private int id;
    
    public ActividadFisica(){}

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double d) {
        this.duracion = d;
    }

    public float getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public void setDistanciaRecorrida(float distanciaRecorrida) {
        this.distanciaRecorrida = distanciaRecorrida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
 
}//CIERRE DE LA CLASE