package bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Dieta implements Serializable{
    
    private ArrayList<Byte> alimentosConsumidos;
    private ArrayList<Short> caloriasAlimentos;
    private LocalDate fecha;
    private int id;
    private Short caloriasTotales;

    public Dieta() {
        this.alimentosConsumidos = new ArrayList<Byte>();
        this.caloriasAlimentos = new ArrayList<Short>();
        this.fecha = LocalDate.now();
        this.id = 0;
        this.caloriasTotales = 0;
    }

    public ArrayList<Byte> getAlimentosConsumidos() {
        return alimentosConsumidos;
    }

    public void setAlimentosConsumidos(ArrayList<Byte> alimentosConsumidos) {
        this.alimentosConsumidos = alimentosConsumidos;
    }

    public ArrayList<Short> getCaloriasAlimentos() {
        return caloriasAlimentos;
    }

    public void setCaloriasAlimentos(ArrayList<Short> caloriasAlimentos) {
        this.caloriasAlimentos = caloriasAlimentos;
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

    public Short getCaloriasTotales() {
        return caloriasTotales;
    }

    public void setCaloriasTotales(Short caloriasTotales) {
        this.caloriasTotales = caloriasTotales;
    }
    
}//CIERRE DE LA CLASE
