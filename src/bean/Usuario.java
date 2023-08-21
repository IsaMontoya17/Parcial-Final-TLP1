
package bean;

import java.io.Serializable;
import java.time.LocalDate;

public class Usuario implements Serializable{
    
    private int identificacion;
    private String nombre;
    private byte edad;
    private float altura;
    private float peso;
    private byte sexo;
    private byte planSeguimiento;
    private LocalDate fechaNacimiento;
    private String correoElectronico;
    private String telefonoCelular;

    public Usuario() {
        
        this.identificacion = 0;
        this.nombre = "";
        this.edad = 0;
        this.altura = 0;
        this.peso = 0;
        this.sexo = ' ';
        this.fechaNacimiento = LocalDate.now();
        this.correoElectronico = "";
        this.telefonoCelular = "";
        this.planSeguimiento = 0;
        
    }//CONSTRUCTOR

    public int getIdentificacion() {
            return identificacion;
    }

    public void setIdentificacion(int identificacion) {
            this.identificacion = identificacion;
    }

    public String getNombre() {
            return nombre;
    }

    public void setNombre(String nombre) {
            this.nombre = nombre;
    }

    public byte getEdad() {
            return edad;
    }

    public void setEdad(byte edad) {
            this.edad = edad;
    }

    public byte getPlanSeguimiento() {
		return planSeguimiento;
	}

	public void setPlanSeguimiento(byte planSeguimiento) {
		this.planSeguimiento = planSeguimiento;
	}

	public float getAltura() {
            return altura;
    }

    public void setAltura(float altura) {
            this.altura = altura;
    }

    public float getPeso() {
            return peso;
    }

    public void setPeso(float peso) {
            this.peso = peso;
    }

    public byte getSexo() {
        return sexo;
    }

    public void setSexo(byte sexo) {
        this.sexo = sexo;
    }

    public LocalDate getFechaNacimiento() {
            return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreoElectronico() {
            return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
            this.correoElectronico = correoElectronico;
    }

    public String getTelefonoCelular() {
            return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
            this.telefonoCelular = telefonoCelular;
    }
    
}//CIERRE DE LA CLASE
